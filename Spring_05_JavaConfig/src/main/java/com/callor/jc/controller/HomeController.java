package com.callor.jc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value="/",
            method= RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    public String home() {
        return "home";
    }

}
