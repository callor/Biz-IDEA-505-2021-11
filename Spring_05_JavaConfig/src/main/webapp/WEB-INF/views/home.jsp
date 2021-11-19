<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <title>나의 독서록</title>
    <link href="${rootPath}/static/main.css?ver=2021-11-19-001" rel="stylesheet">
</head>
<body>
    <header>
        <h1>READ BOOK 2021</h1>
    </header>
    <nav>
        <ul>
            <li>Home</li>
            <li>
                <form method="POST">
                <input name="search"
                       placeholder="검색어를 입력하세요">
                </form>
            </li>
        </ul>
    </nav>
    <section class="main">

    </section>
    <footer>
        <address>CopyRight &copy; callor@callor.com</address>
    </footer>
</body>
</html>
