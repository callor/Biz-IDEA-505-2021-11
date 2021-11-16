package com.callor.sec.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * spring security 에서 회원 인증 정보(회원정보)를
 * 담아서 사용할 UserVO는 반드시 UserDetails 인터페이스를 상속하여
 * 작성하도록 하고 있다
 *
 * security 에 내장된 어떤 연산에서
 * 사용자 정보를 읽고, 쓰기를 시도하려고 한다.
 *      내 맘대로 vo 의 변수를 선언하고,
 *      getter, setter 도 임의로 선언을 하게 된다면
 *
 * Security 의 어떤 연산이 VO 객체에 값을
 *      쓰거나(setter)
 *      읽을때(getter) 할때 상당히 문제를 일으킬 것이다
 *
 * 인터페이스를 상속받으면 method 를 정해진 이름으로
 * 강제 선언을 해야 하는데
 *
 * 여기에서는 lombok 의 기능을 사용하기 위하여
 * 정해진 이름으로 각각 member 변수를 선언하고
 * lombok 을 사용하여 getter, setter 를 선언한다
 *
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_members")
public class UserDetailsVO implements UserDetails {

    private static final long serialVersionID = 1L;

    /* 필수로 선언해야할 변수 들 */
    @Id
    @Column(columnDefinition = "VARCHAR(125)")
    private String username;

    @Column(columnDefinition = "VARCHAR(512)",
            nullable = false)
    private String password;

    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;

    // table 을 생성할때 이 변수는 칼럼으로 설정하지 말라
    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    /* 필요에 따라 추가하여 사용하는 변수 들 */
    private String email;
    private String tel;
    private String address;



}
