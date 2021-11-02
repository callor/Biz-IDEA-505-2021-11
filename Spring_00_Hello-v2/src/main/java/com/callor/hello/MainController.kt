package com.callor.hello

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MainController {

    @ResponseBody
    @RequestMapping(value=["/main"],method=[RequestMethod.GET])
    fun main() :String {
        return "나는 코틀린 컨트롤러 입니다"
    }

    @RequestMapping(value = ["/home"], method = [RequestMethod.GET])
    fun home(model: Model): String? {
        model.addAttribute("NAME", "홍길동")
        return "home"
    }


}