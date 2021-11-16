package com.callor.sec.service.auth;

import com.callor.sec.models.UserDetailsVO;
import com.callor.sec.repository.MemberDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * security 에서 login 서비를 수행하는  방법이 다얗하다
 * <p>
 * DB 와 연동을 하여 로그인을 수행하는 비교적 쉬운 방법으로
 * UserDetailService 상속받아 클래스를 만들고 수행한다다 *
 * <p>
 * UserDetailService uds = new LoginService()
 * uds.loadUserByUsername(username)
 */
@Slf4j
@Service("loginService")
public class LoginService implements UserDetailsService {

    private final String encPassword = "$2a$04$Hdu3p5qGzssmGRpq.I9UrehUnkLBtWXOMBy/FOSZMgm5rNAqSSOHa";
    private final MemberDao memberDao;
    public LoginService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1. dao 에서 사용자 정보 가져오기
        //  username 으로 member table 에서
        // findById(username) 등을 수행하여
        // User 정보를 가져온다
        UserDetailsVO userVO = UserDetailsVO.builder()
                .username("callor")
                .password(encPassword)
                .isAccountNonExpired(true)
                .isEnabled(false)
                .isCredentialsNonExpired(true)
                .isAccountNonLocked(true)
               .build();
        // UserDetailsVO userVO = memberDao.findById(username).get();

        // 2. dao 에서 받은 사용자 정보가 없으면
        //      즉 username 에 저장된 사용자이름이
        //      DB에 없으면
        //      강제로 exception 을 발생하여
        //      security 에게 알려준다
        if (userVO == null) {
            log.debug("{} username 없음", username);
            throw new UsernameNotFoundException(username + " 사용자 없음");
        }

        //===========================
        // security 에 내장된 코드
        // try {
        //    UserDetails vo
        //            = loadUserByUsername("callor");
        //    // 비밀번호를 검사는 코드가 내장되어 있을 것이다
        // } catch (UsernameNotFoundException e) {
        //    // redirect "/member/login?error=xxxx";
        // }
        //=============================
        return userVO;
    }
}
