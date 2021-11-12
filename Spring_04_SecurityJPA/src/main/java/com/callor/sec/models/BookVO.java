package com.callor.sec.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "book_vo")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class BookVO implements Serializable {
    private static final long serialVersionUID = 7747497078938448794L;

    @Id
    @Column(name = "b_isbn", nullable = false, length = 13)
    private String b_isbn;

}