package com.callor.student.repository;

import com.callor.student.models.StudentVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao
        extends JpaRepository<StudentVO,String> {

}
