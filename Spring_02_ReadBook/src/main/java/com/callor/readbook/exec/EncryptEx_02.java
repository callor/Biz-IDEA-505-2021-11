package com.callor.readbook.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EncryptEx_02 {

    public static void main(String[] args) throws FileNotFoundException {

        String propsFile
                = "./src/main/webapp/WEB-INF/spring/props/" +
                "db.conn.properties";


        // 운영체제에 등록된 환경변수를 Map(list) 형태로 만들어 준다
        Map<String,String> sysEnvList = System.getenv();

        /**
         * Map<> type 의 데이터(여러개의 데이터, Collections)
         *
         * literal
         * forEach() 명령으로 전체 리스트를 순회하면서
         * 연산을 수행할수 있는 데이터 type
         *      List<> ArrayList<>
         *
         * Map<> type 의 데이터는
         * Collections(다수의 데이터를 호함하는 데이터) 이지만
         * Literal 이니다.
         * Map 담긴 데이터를 foreach() 등을 직접 사용하여 확인할 수 없다
         *
         * Map 에 담긴 데이터를 foreach() 를 이용하여 연산을 하고자 할때는
         * 1. Map 의 key 값을 추출하여 Set 데이터로 변환한다.
         *      Map 에서 제공하는 keySet() method 를 사용하여
         *      Key 들만 볃도로 추출하여 Set 데이터를 변환 할수 있다
         * 2. 추출된 Key 들을 foreach() 를 사용하여 연산을 수행한다
         */
        Set<String> keys = sysEnvList.keySet();
        for(String key : keys) {
            System.out.println(key + " : " + sysEnvList.get(key));
        }

        // 시스템 환경변수 중에 callor.com 변수의 값을 추출(getter)하여
        // salt 변수에 담는다
        String salt = sysEnvList.get("callor.com");
        System.out.println("=".repeat(100));
        System.out.println("시스템 환경변수 callor.com : "  + salt);

        String driver = "db.driver=com.mysql.cj.jdbc.Driver";
        String url = "db.url=jdbc:mysql://localhost:3306/naraDB";

        Scanner scan = new Scanner(System.in);

        System.out.print("username : ");
        String username = scan.nextLine();

        System.out.print("password : ");
        String password = scan.nextLine();

        StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
        pbe.setAlgorithm("PBEWithMD5andDES");
        pbe.setPassword(salt);

        String encUserName = pbe.encrypt(username);
        String encPassword = pbe.encrypt(password);

        String saveUserName = String.format("db.username=ENC(%s)", encUserName);
        String savePassword = String.format("db.password=ENC(%s)",encPassword);

        PrintWriter out = new PrintWriter(propsFile);

        out.println("# MySQL DB 연결 설정");
        out.println(driver);
        out.println(url);
        out.println(saveUserName);
        out.println(savePassword);

        out.flush();
        out.close();
        scan.close();
        System.out.println("Properties 파일 생성 완료");
    }

}
