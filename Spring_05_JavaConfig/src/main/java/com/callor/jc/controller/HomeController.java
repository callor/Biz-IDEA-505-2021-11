package com.callor.jc.controller;


import com.callor.jc.repository.BookDao;
import com.callor.jc.service.impl.NaverServiceV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@Controller
public class HomeController {

    private final NaverServiceV1 naverService;
    private final BookDao bookDao;
    public HomeController(NaverServiceV1 naverService,
                          BookDao bookDao) {
        this.naverService = naverService;
        this.bookDao = bookDao;
    }

    @RequestMapping(value="/",
            method= RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    public String home() {
        bookDao.selectAll();
        return "home";
    }

    @ResponseBody
    @RequestMapping(value="/",
            method=RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
            )
    public String home(String search) throws IOException {
        String queryString = naverService.queryString(search);
        String jsonString = naverService.getJsonString(queryString);
        return jsonString;
    }
}
