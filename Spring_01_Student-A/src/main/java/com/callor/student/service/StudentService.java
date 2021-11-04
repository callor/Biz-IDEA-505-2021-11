package com.callor.student.service;

import com.callor.student.model.StudentVO;

import java.util.List;

public interface StudentService {

    public List<StudentVO> selectAll();
    public StudentVO findByNum(String st_num);

    public List<StudentVO> findByName(String st_name);
    public List<StudentVO> findByTel(String st_tel);

    public List<StudentVO> findByDept(String st_dept);
    public List<StudentVO> findByGrade(String st_grade);

    // 학생데이터 추가할때 새로운 학번을 생하여 StudentVO 개체 만드는 method
    public StudentVO insert();

    // DB 에 추가하는 method
    public void insert(StudentVO stVO);

    public void update(StudentVO stVO);
    public void delete(String st_num);

}
