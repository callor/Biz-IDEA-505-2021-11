package com.callor.sec.service;

import java.util.List;

/**
 * 여러 service interface 를 만들기 위한 구조형 interface
 * Generic 사용하여 interface 를 선언하였다
 *
 * 기본 CRUD 5 개의 method 를 선언
 *
 * @param <VO>
 * @param <PK>
 */
public interface GenericService <VO, PK>{

    public List<VO> selectAll();
    public VO findById(PK pk);

    public void insert(VO vo);
    public void update(VO vo);
    public void delete(PK pk);

}
