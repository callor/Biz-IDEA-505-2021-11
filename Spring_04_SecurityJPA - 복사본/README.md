# Spring Security 를  사용한 회원가입 및 로그인 

## 회원가입 할때
* 사용자의 비밀번호를 BCryptPasswordEncoder 를 사용하여 비번을 암호화 하여 저장하기
* 일반적인 CRUD 구현중 insert, update 등에서 암호화 과정을 수행하기

## 로그인 정책 설정
* security-context.xml 에 로그인이 필요한 URL 에대한 pattern 을 설정하기
* login form 을 만들어서 로그인을 수행하기
* login submit 은 security 에서 제공하는 기본 설정 기능을 사용하기

## 로그인 과정의 Custom 정책
* UserDetails(service)를 impl 하여 클래스 생성 : LoginService.java
* PasswordEncoder(BCryptPasswordEncoder) 를 security-context.xml 에 bean 등록

## UserDetails(LoginService).loadUserByUsername()
* DB(Dao) 로 부터 사용자 정보를 findById() 하여 가져오기
* 사용자 정보가 있으면 사용자 정보를 return
* 없으면 UserNameNotFound exception 발생하기

## UserDetails 에서 구현한 로그인의 문제점
* 사용자의 로그인이 어떤 이유로 실패했는지 명확하개 알릴수 없다
* 모든 이유는 BadCredential 로 처리되어 view 에서 적절한 처리를 하기가 어렵다

## LoginFail 을 Custom 하여 좀더 자세한 로그인 실패 메시지 표현



