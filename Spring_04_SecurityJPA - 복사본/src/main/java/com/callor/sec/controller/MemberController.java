package com.callor.sec.controller;


import com.callor.sec.models.UserDetailsVO;
import com.callor.sec.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value="/member")
public class MemberController {

    private final MemberService memberService;
    public MemberController(@Qualifier("memServiceV1")
                                    MemberService memberService) {

        this.memberService = memberService;
    }

    // login form 을 열기 위한 URL
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(String ERROR_MSG, String AUTHOR, Model model) {

        log.debug("GET Login");
        model.addAttribute("ERROR_MSG",ERROR_MSG);
        model.addAttribute("AUTHOR",AUTHOR);

        return "member/login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login_fail() {
        log.debug("POST Login");
        return "member/login";
    }

    @RequestMapping(value="/join",method=RequestMethod.GET)
    public String join() {
        return "member/join";
    }

    @RequestMapping(value="/join",method=RequestMethod.POST)
    public String join(UserDetailsVO userVO) {
        log.debug("회원가입 : {}", userVO.toString());

        memberService.insert(userVO);

        return "member/join";
    }

    @ResponseBody
    @RequestMapping(value="/idcheck",method=RequestMethod.GET)
    public UserDetails idcheck(String username) {

        /**
         * service(dao) findById(username) 으로 조회를 하여
         * 결과를 바로 return 할수 있다
         *
         * 이미 데이터가 있으면 회원정보가 return
         * 그렇지 않으면 null 값이 자동으로 return 될 것이다
         *
         * return sService.findById(username)
         *
         */
        log.debug("USERVO {}", username);
        UserDetailsVO userVO = memberService.findById(username);
        // log.debug("USERVO {}", userVO.toString());/
        // if(username.equalsIgnoreCase("callor")) {
        //    return "callor";
        // } else {
        //    return null;
        // }
        return userVO;
    }
}
