package com.callor.student.repository;

import com.callor.student.model.StudentVO;
import com.callor.student.repository.StDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StDaoImpl implements StDao {

    private final String[] stNames =
            {"홍길동", "이몽룡", "성춘향", "임꺽정", "장영실", "장보고"};
    private final Random RND = new Random();
    public List<StudentVO> findAll() {
        return null;
    }

    @Override
    public List<StudentVO> selectAll() {

        final List<StudentVO> stList = new ArrayList();
        for(int i = 0 ; i < 10 ; i++) {
            String stNum = String.format("2021%04d",i+1);
            String stName = stNames[RND.nextInt(stNames.length)];
            StudentVO vo = StudentVO.builder()
                    .st_num(stNum)
                    .st_name(stName)
                    .st_dept("컴퓨터공학")
                    .st_grade((RND.nextInt(4) + 1) + "")
                    .st_address("광주광역시")
                    .st_tel(
                            String.format("062-%04d-%04d",
                                RND.nextInt(9999) + 1,
                                RND.nextInt(9999) + 1
                            )
                    ).build();
            stList.add(vo);
        }
        return stList;
    }

    @Override
    public StudentVO findById(String st_num) {
        return null;
    }

    @Override
    public void insert(StudentVO vo) {

    }

    @Override
    public void update(StudentVO vo) {

    }

    @Override
    public void delete(String st_num) {

    }
}
