package com.callor.jc.service;

import java.net.URLEncoder;
import java.util.List;

public abstract class NaverService<T> {

    // 필수적으로 생성할 method
    public String queryString(String search) {
        String searchUTF8 = URLEncoder.encode(search,"UTF-8");
        StringBuilder quryURL = new StringBuilder();
        quryURL.append(NAVER_BOOK_URL);
        quryURL.append(String.format("?query=%s",searchUTF8));
        return quryURL.toString();
    }

    // 선택적으로 사용할 method
    public abstract String getJsonString(String queryString);
    public abstract List<T> naverList(String queryString);

}
