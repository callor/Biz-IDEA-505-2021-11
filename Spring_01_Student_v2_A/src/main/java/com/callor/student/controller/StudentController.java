package com.callor.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/st")
public class StudentController {

    @RequestMapping(value="/list",method= RequestMethod.GET)
    public String list() {
        // tiles_layout.xml 에 name ST/* 로 설정된 곳을
        // 참조하여 view 를 rendering 
        // name="ST/*" * 표대신 st_list 문자열이 대치
        return "ST/st_list";
    }
    @RequestMapping(value="/detail",method= RequestMethod.GET)
    public String detail() {
        return "ST/st_detail";
    }
    @RequestMapping(value="/write",method= RequestMethod.GET)
    public String write() {
        return "ST/st_write";
    }


    @RequestMapping(value="/list2",method= RequestMethod.GET)
    public String list2() {
        // tiles_layout.xml 에 name ST/* 로 설정된 곳을
        // 참조하여 view 를 rendering
        // name="ST/*" * 표대신 st_list 문자열이 대치
        return "student/st_list";
    }



}
