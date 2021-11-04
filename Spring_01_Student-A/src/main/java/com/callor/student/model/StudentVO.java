package com.callor.student.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StudentVO {
    private String st_num;
    private String st_name;
    private String st_dept;
    private String st_grade;
    private String st_address;
    private String st_tel;
}
