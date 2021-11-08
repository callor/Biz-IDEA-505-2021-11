<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<table class="student">
    <thead>
        <tr>
            <th>학번</th>
            <th>이름</th>
            <th>학과</th>
            <th>학년</th>
            <th>전화번호</th>
            <th>주소</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${empty ST_LIST}">
            <tr><td colspan="6">데이터가 없습니다</td></tr>
        </c:if>
        <c:forEach items="${ST_LIST}" var="ST">
            <tr data-num="${ST.st_num}">
                <td>${ST.st_num}</td>
                <td>${ST.st_name}</td>
                <td>${ST.st_dept}</td>
                <td>${ST.st_grade}</td>
                <td>${ST.st_tel}</td>
                <td>${ST.st_address}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

