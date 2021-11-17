package com.callor.jc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * servlet-context.xml 파일을 대신할 Java Config 클래스
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.callor.jc"})
public class ServletConfig implements WebMvcConfigurer {

}
