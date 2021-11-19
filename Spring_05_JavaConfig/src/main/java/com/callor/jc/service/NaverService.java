package com.callor.jc.service;

import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

@PropertySource("classpath:naver.properties")
public abstract class NaverService<T> {


    public static final String NAVER_BOOK_URL
            = "https://openapi.naver.com/v1/search/book.json";

    // 필수적으로 생성할 method
    public String queryString(String search) throws UnsupportedEncodingException {
        String searchUTF8 = URLEncoder.encode(search,"UTF-8");
        StringBuilder quryURL = new StringBuilder();
        quryURL.append(NAVER_BOOK_URL);
        quryURL.append(String.format("?query=%s",searchUTF8));
        return quryURL.toString();
    }

    // 선택적으로 사용할 method
    public abstract String getJsonString(String queryString) throws IOException;
    public abstract List<T> naverList(String queryString) throws URISyntaxException;

}
