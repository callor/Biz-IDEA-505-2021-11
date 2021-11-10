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

        Set<String> keys = sysEnvList.keySet();
        for(String key : keys) {
            System.out.println(key + " : " + sysEnvList.get(key));
        }

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
