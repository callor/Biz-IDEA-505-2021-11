package com.callor.student.service.impl;

import com.callor.student.model.StudentVO;
import com.callor.student.repository.StDao;
import com.callor.student.repository.StDaoImpl;
import com.callor.student.service.StService;

import java.util.Collections;
import java.util.List;

/**
 * StDao 형 객체를 생성하고 인스턴스가 만들어 지는 순간
 * StDao, StDaoImpl, StService 는 상당히 끈끈한 관계가 이루어 진다
 * 결합이 발생했다
 *
 * StDaoImpl 클래스의 변화(변경, 업데이트)가 발생하면
 * StService 에게 영향이 미치게 된다.
 *
 * 아래의 stDao 객체는 StService 와의 결합도를 고민해야 한다
 * 1번 코드는 StDaoImpl 클래스로 선언하고 클래스로 직접 객체 생성
 * 2번 코드는 StDao 인터페이스로 선언하고 클래스로 간접 객체 생성
 *
 * 이 코드에 1번 코드는 2번 코드보다 결합도가 더 높다
 *
 * Sub 로 작성된 클래스 모듈은 반드시 인터페이스를 생성하여
 * 결합도를 낮추는 작업이 필요
 *
 */
public class StService2 implements StService {

    // interface 로 선언하고 상속받은 class 로 초기화(생성)하기
    // StDaoImpl 클래스를 사용하여 StDao 형(type)의 stDao 객체 생성
    // 클래스의 생성자를 호출하여 객체를 생성하면
    // 이 객체는 StDao 형 인스턴스가 된다
    private StDao stDao2 = new StDaoImpl(); // 2번 코드

    public List<StudentVO> selectAll() {
        List<StudentVO> stList2 = stDao2.selectAll();
        return stList2;
    }

}
