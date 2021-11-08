package com.callor.student.service.impl;

import com.callor.student.models.StudentVO;
import com.callor.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stServiceV1")
public class StudentServiceImplV1 implements StudentService {
    @Override
    public List<StudentVO> selectAll() {
        return null;
    }

    @Override
    public StudentVO findById(String s) {
        return null;
    }

    @Override
    public void insert(StudentVO model) {

    }

    @Override
    public void update(StudentVO model) {

    }

    @Override
    public void delete(String s) {

    }

    /**
     * 학생정보를 추가(새로등록)할때
     * 학번을 자동으로 생성하여 학생 model 객체를 생성한 후
     * Controller 에서 write.jsp 로 보내기
     * @return
     */
    @Override
    public StudentVO insert() {

        StudentVO stVO = StudentVO.builder()
                .st_num("20210001")
                .build();
        return stVO;
    }
}
