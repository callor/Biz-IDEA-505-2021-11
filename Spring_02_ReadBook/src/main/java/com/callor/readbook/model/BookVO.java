package com.callor.readbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_books")
public class BookVO {

    @Id
    private String isbn;
    private String title;
    private String author;
    private String comp;
    private Integer price;
    private String date;

}
