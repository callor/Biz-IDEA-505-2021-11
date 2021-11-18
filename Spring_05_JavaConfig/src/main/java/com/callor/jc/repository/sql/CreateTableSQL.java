package com.callor.jc.repository.sql;

public class CreateTableSQL {

    public static final String create_book_table
            = "CREATE TABLE IF NOT EXISTS tbl_naver_books (" +
            "    isbn VARCHAR(13) PRIMARY KEY," +
            "    title VARCHAR(125)," +
            "    link VARCHAR(125)," +
            "    image VARCHAR(125)," +
            "    author VARCHAR(125)," +
            "    price VARCHAR(125)," +
            "    discount VARCHAR(125)," +
            "    publisher VARCHAR(125)," +
            "    description VARCHAR(255)," +
            "    pubdate VARCHAR(125) )" ;

}
