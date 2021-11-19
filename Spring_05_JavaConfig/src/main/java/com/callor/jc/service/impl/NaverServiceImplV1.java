package com.callor.jc.service.impl;

import com.callor.jc.models.BookVO;
import com.callor.jc.models.NaverRestLayout;
import com.callor.jc.service.NaverService;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.util.Collections;
import java.util.List;

/**
 *
 * abstract(추상) 클래스
 * 일반 클래스와 인터페이스의 기능을 결합한 클래스
 * 인터페이스 처럼 구현되지 않은 프로토 타입의 method 를 가지면서
 * 일부는 자체적으로 구현된 method 도 포함하는 클래스
 *
 * 인터페이스
 * 클래스를 만들기 위한 설계도 역할
 * method 의 프로토 타입만 있고 실제 구현된 코드는 업다다
*
 */
@Slf4j

@Service("naverServiceV1")
public class NaverServiceImplV1 extends NaverService<BookVO> {

    @Value("${naver.client_id}")
    private String naver_client_id;

    @Value("${naver.client_secret}")
    private String naver_client_secret;

    private final StandardPBEStringEncryptor encryptor;
    public NaverServiceImplV1(StandardPBEStringEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    // naver open API 에 연결하기
    public String getJsonString(String queryString) throws IOException {

        URL url = new URL(queryString);
        HttpURLConnection httpCon
                = (HttpURLConnection) url.openConnection();

        httpCon.setRequestMethod("GET");

        log.debug("PBE {}", encryptor.toString());
        httpCon.setRequestProperty("X-Naver-Client-Id",
                encryptor.decrypt(naver_client_id));
        httpCon.setRequestProperty("X-Naver-Client-Secret",
                encryptor.decrypt(naver_client_secret));

        InputStreamReader is = null;

        // naver 야 내가 보낸 요청을 어떻게 할래?
        int httpStatusCode = httpCon.getResponseCode();

        if(httpStatusCode == 200) {
            is = new InputStreamReader(httpCon.getInputStream(),
                    "UTF-8");
        } else {
            is = new InputStreamReader(httpCon.getErrorStream(),
                    "UTF-8");
        }

        BufferedReader buffer = new BufferedReader(is);
        StringBuffer stringBuffer = new StringBuffer();
        while(true) {
            String reader = buffer.readLine();
            if(reader == null) break;

            stringBuffer.append(reader);
        }
        return  stringBuffer.toString();
    }

    /**
     * RestTemplate 을 사용하여 naver 도서정보 가져오기
     */
    @Override
    public List<BookVO> naverList(String queryString) throws URISyntaxException {

        /**
         * VO 클래스를 Wrapping 하여 API 데이터 가져오기
         */
        RestTemplate restTemp = new RestTemplate();
        ResponseEntity<NaverRestLayout> restList = null;

        URI restURI = new URI(queryString);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",
                encryptor.decrypt(naver_client_id));
        headers.set("X-Naver-Client-Secret",
                encryptor.decrypt(naver_client_secret));

        // API 에서 XML, JSON 데이터를 한가지 URL로 요청하는 경우
        // 수신한 데이터 Type 을 지정해주기
        headers.setAccept(
                Collections.singletonList(MediaType.APPLICATION_JSON)
        );

        // 설정된 header 정보를 Http 프로토콜에 담기
        HttpEntity<String> httpEntity
                = new HttpEntity<String>("parameters", headers);


        restList = restTemp.exchange(
                restURI,
                HttpMethod.GET,httpEntity,
                NaverRestLayout.class);

        return restList.getBody().getItems();

    }


}
