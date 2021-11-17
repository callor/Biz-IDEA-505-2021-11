# Java Config type Spring Project
* Java 3.x 에서 사용하기 시작한 Annotation 이 보편화 되면서  
Spring framework 에서 상당부분 context.xml 을 사용하지 않고  
@Component, @Controller, @Service, @Repository 등등의 Annotation 으로  
bean 생성을 대신하게 된다.
* 하지만 web.xml, applicationContext.xml, dispatcher-servlet.xml 등은  
여전히 프로젝트에서 사용을 계속해 왔다.
* .xml 방식의 설정에서 사소한 type 오류(스펠오류), tag 오류 등으로  
프로젝트가 전체적으로 문제를 일으키는 경우가 매우 많다
* .xml 을 사용하지 않는 프로젝트를 만들고자 하여 새롭고 구현된 프로젝트 구조

* java 의 class 를 사용하여 .xml 파일을 대신하는 프로젝트를 구현한다

## Java Config 를 사용한 MyBatis Project 핸들링
    spring-jdbc
    commons-dbcp2
    myabatis
    myabtis-spring
    mysql-connection-j

    lombok
    sjf4j
    logback-classic
    jackson
