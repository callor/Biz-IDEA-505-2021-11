package com.callor.student.service;

import com.callor.student.models.StudentVO;

public interface StudentService extends GenericService<StudentVO, String>{

    public StudentVO insert();

}
