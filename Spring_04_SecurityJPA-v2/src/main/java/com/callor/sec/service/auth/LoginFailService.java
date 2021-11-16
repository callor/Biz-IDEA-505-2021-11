package com.callor.sec.service.auth;

import com.callor.sec.config.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

// exception 핸들러 import
import org.springframework.security.authentication.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Service("loginFailService")
public class LoginFailService implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        log.debug("로그인 실패 처리 시작");
        log.debug("Exception {} ", exception.getClass().getName());

        String exceptionClassName = exception.getClass().getName();

        // 어떤 문제가 발생하여 LoginFail 이 작동되었는지를 알기 위해
        // exception 의 정체를 파악하기
        // 1. exception 의 클래스 이름을 문자열로 비교하여 정체파악하기
        //    type 오류로 인한 문제를 일으킬 수 있다
        if(exceptionClassName
                .equalsIgnoreCase("credentialsExpiredException")) {
        }

        // 2. exception 객체가 어떤 클래스의 인스턴스인가를 알아보고
        //      exception 의 정체를 파악하기
        //      type 오류는 발생하지 않는다.
        String error_msg = "";
        if(exception instanceof CredentialsExpiredException) {
            error_msg = Message.ERROR.CredentialsExpired;
        } else if(exception instanceof AccountExpiredException) {
            error_msg = Message.ERROR.AccountExpired;
        } else if(exception instanceof DisabledException) {
            error_msg = Message.ERROR.Disabled;
        } else if(exception instanceof LockedException) {
            error_msg = Message.ERROR.Locked;
        } else if(exception instanceof SessionAuthenticationException) {
            error_msg = Message.ERROR.SessionAuthentication;
        } else {
            error_msg = Message.ERROR.BadCredentials;
        }

        /**
         * GET /member/login URL 은 login.jsp 을 열기 위한 요청
         * login.jsp 에서 "로그인" 버튼을 클릭(submit) 하면
         * POST /login URL 로 요청이 전달된다.
         *
         * 로그인이 실패했을때
         * 다시 /member/login 으로 forwarding 을 수행한다
         *
         * 이때 /member/login 은 POST 방식으로 호출이 된다
         * POST /login 을 수행하는 과정에서 forwarding 을 했기 때문에
         *
         * 만약 redirect 를 했다면 GET 으로 호출이 된다.
         */
        request.setAttribute("ERROR_MSG", error_msg);
        // /member/login URL 로 forwarding 을 수행하라
        // redirect 가 아니고 forwarding
        request.getRequestDispatcher("/member/login?error")
                .forward(request,response);

    }
}
