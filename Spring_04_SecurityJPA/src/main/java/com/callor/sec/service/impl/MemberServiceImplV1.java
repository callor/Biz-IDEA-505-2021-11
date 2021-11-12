package com.callor.sec.service.impl;

import com.callor.sec.models.UserDetailsVO;
import com.callor.sec.repository.MemberDao;
import com.callor.sec.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memServiceV1")
public class MemberServiceImplV1 implements MemberService {

    private final MemberDao memDao;
    public MemberServiceImplV1(MemberDao memDao) {
        this.memDao = memDao;
    }

    @Override
    public List<UserDetailsVO> selectAll() {
        List<UserDetailsVO> memberList = memDao.findAll();
        return memberList;
    }
    @Override
    public UserDetailsVO findById(String username) {

        /**
         * JpaRepository 에 선언된 findById(pk) 는
         * SELECT * FROM [table] WHERE PK = [pk] SQL 을 실행하고
         * 결과를 Optional<UserDetailsVO> type 으로 return 을 한다
         * Optional 로 감싸진 데이터는 null safe type 의 데이터이다
         * null 으로 뭔가를 검사하려고 하면
         * 문제가 되기도 하다
         *
         * 결과값.orElse(리턴값) method 를 사용하여
         * 결과값이 실제로 null 이면 orElse(리턴값)을 참조하여
         * 그 값을 연산 결과로 return 해준다
         *
         * 이러한 원리를 이용하여
         * findById() 한 결과가 없으면 null 을 return 하도록
         * 만들어 준다
         *
         */
        UserDetailsVO userVO
                =  memDao.findById(username)
                            .orElse(null);
        return userVO;
    }
    @Override
    public void insert(UserDetailsVO userDetailsVO) {
        memDao.save(userDetailsVO);
    }

    @Override
    public void update(UserDetailsVO userDetailsVO) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<UserDetailsVO> findByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDetailsVO> findByTel(String tel) {
        return null;
    }

    @Override
    public int userCount() {
        return 0;
    }
}
