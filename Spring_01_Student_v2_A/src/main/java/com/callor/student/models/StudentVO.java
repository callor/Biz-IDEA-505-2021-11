package com.callor.student.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table(name="tbl_student")
public class StudentVO {

    @Id
    @Column(name="st_num",columnDefinition = "VARCHAR(8)")
    private String st_num;

    @Column(name="st_name",columnDefinition = "VARCHAR(20)")
    private String st_name;

    @Column(name="st_dept",columnDefinition = "VARCHAR(8)")
    private String st_dept;

    @Column(name="st_grade",columnDefinition = "VARCHAR(1)")
    private String st_grade;

    @Column(name="st_tel",columnDefinition = "VARCHAR(20)")
    private String st_tel;

    @Column(nullable = true)
    private String st_address;

}
