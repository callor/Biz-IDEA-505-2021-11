package com.callor.jc.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class MakeDBConnection {

    public static void main(String[] args) throws FileNotFoundException {
        final String propsFile = "./src/main/resources/db.properties";
        final Map<String, String> sysEnv = System.getenv();

        final String driver = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/naraDB";
        final Scanner scan = new Scanner(System.in);

        String saltPass = sysEnv.get("callor.com");
        System.out.println("시스템 환경변수 : "  + saltPass);

        System.out.print("username : ");
        String username = scan.nextLine();

        System.out.print("password : ");
        String password = scan.nextLine();

        StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
        pbe.setAlgorithm("PBEWithMD5AndDES");
        pbe.setPassword(saltPass);

        String encUsername = pbe.encrypt(username);
        String encPassword = pbe.encrypt(password);

        PrintWriter out = new PrintWriter(propsFile);
        out.println("# MySQL 연결 설정");

        out.printf("db.driver=%s\n",driver);
        out.printf("db.url=%s\n",url);
        out.printf("db.username=%s\n",encUsername);
        out.printf("db.password=%s\n",encPassword);
        out.flush();
        out.close();
        System.out.println("DB Connection Properties Complete!!");
    }
}
