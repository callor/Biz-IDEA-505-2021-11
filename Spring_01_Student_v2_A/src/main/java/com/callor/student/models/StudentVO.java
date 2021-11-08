package com.callor.student.models;

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
    private String st_tel;
    private String st_address;

}
