package com.callor.jc.repository.sql;

import org.apache.ibatis.jdbc.SQL;

public class BookSQL {

    /**
     * mybatis mapper 에 주입할 SQL 코드는
     * 반드시 final String 으로 선언해야 한다.
     */
    public static final String book_insert_sql
            = " INSERT INTO tbl_naver_books " +
            " ( isbn, title, author, publisher )" +
            " VALUES( #{isbn},#{title},#{author}, #{publisher} ) " ;

    public String book_insert() {
        // mybatis 3.5.x 이상에서 사용가능
        SQL sql = new SQL();
        sql.INSERT_INTO("tbl_naver_books");
        sql.INTO_COLUMNS("isbn").INTO_VALUES("#{isnb}");
        return sql.toString();
    }

    public String book_update_sql() {

        SQL sql = new SQL();
        sql.UPDATE("tbl_naver_books");
        sql.SET("title = #{title}");
        sql.SET("author = #{author}");
        sql.SET("publisher = #{publish}");
        sql.WHERE("isbn = #{isbn}");
        return sql.toString();

    }


}
