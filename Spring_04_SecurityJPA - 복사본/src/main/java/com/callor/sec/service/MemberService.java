package com.callor.sec.service;

import com.callor.sec.models.UserDetailsVO;

import java.util.List;

public interface MemberService
        extends GenericService<UserDetailsVO, String> {

    // GenericService 에 선언된 기본 CRUD 는 같이 상속받는다

    // 별도로 tbl_member table 과 관련된 추가 method 정의
    public List<UserDetailsVO> findByEmail(String email);
    public List<UserDetailsVO> findByTel(String tel);

    // DB 에 저장된 사용자가 몇명이나 되냐?
    public int userCount() ;

}
