package com.callor.readbook.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptEx_01 {

    public static void main(String[] args) {

        StandardPBEStringEncryptor
                pbe = new StandardPBEStringEncryptor();


        String salt = "!Biz1234";
        // SHA-128, SHA-256, SHA-512, SHA-1024
        String encPolicy = "PBEWithMD5AndDES";

        pbe.setAlgorithm(encPolicy);
        pbe.setPassword(salt);

        String username = "root";
        String password = "!Biz12341234";

        String encUserName = pbe.encrypt(username);
        String encPassword = pbe.encrypt(password);

        System.out.printf("user name : %s\n", encUserName);
        System.out.printf("password : %s\n", encPassword);

        // S5Bh1CSDomD+MLjRTpcvnA==
        // 24! ( 24 * 8 )!
    }
}
