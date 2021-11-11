<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>

    form.login_form {
        width: 400px;
        padding:40px;
        background-color: #191919;
        text-align: center;
        border-radius: 20px;
        box-shadow: 12px 12px 2px 1px rgba(0,0,255,0.3);
        margin:20px auto;
    }

    form.login_form h2 {
        color:white;
        font-weight: 500;
    }

    form.login_form h3 {
        color: yellow;
        background-color: red;
        padding:14px 10px;
    }

    form.login_form input {
        background: none;
        margin:20px auto;
        text-align: center;
        border:2px solid #3498db;
        padding: 14px 10px;
        width: 200px;
        outline: none;
        color:white;
        border-radius: 25px;
        transition: 0.2s;
    }

    form.login_form input:focus {
        width: 280px;
        border-color: #2ECC71;
    }

    form.login_form button {
        background: none;
        margin:20px auto;
        width: 200px;
        padding: 14px 10px;

        text-align: center;
        outline: none;

        color: white;
        border-radius: 25px;
        transition: 0.3s;
    }
    form.login_form button:hover {
        background-color: #2ECC71;
    }
</style>

<form:form action="${rootPath}/login" cssClass="login_form">
    <fieldset>
        <h2>로그인</h2>
        <c:if test="${param.error != null}">
            <h3>로그인 오류!!!</h3>
        </c:if>
        <input
                placeholder="사용자 ID"
                name="username">
        <input
                placeholder="비밀번호"
                type="password"
                name="password">
        <button>로그인</button>
        <button type="button">회원가입</button>
    </fieldset>
</form:form>
