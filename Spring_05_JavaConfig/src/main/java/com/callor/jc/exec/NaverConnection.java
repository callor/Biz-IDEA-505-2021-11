package com.callor.jc.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

public class NaverConnection {

    private final static String CLIENT_ID = "YOUR NAVER CLIENT ID";
    private final static String CLIENT_SECRET = "YOUR NAVER CLIENT SECRET";
    private final static String BASE_FOLDER = "./src/main/resources/";

    public static void main(String[] args) throws FileNotFoundException {

        final Map<String, String> envList = System.getenv();
        final String saltPass = envList.get("callor.com");
        System.out.println("환경변수 : " + saltPass);

        final StandardPBEStringEncryptor encryptor
                = new StandardPBEStringEncryptor();

        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPassword(saltPass);

        String saveFile = BASE_FOLDER + "naver.properties";
        PrintWriter out = new PrintWriter(saveFile);

        out.println("# naver 접속 정보");
        out.printf("naver.client_id=%s\n",
                encryptor.encrypt(CLIENT_ID));
        out.printf("naver.client_secret=%s\n",
                encryptor.encrypt(CLIENT_SECRET));

        out.flush();
        out.close();
        System.out.println("네이버 접속정보 작성 완료~~~");
    }
}
