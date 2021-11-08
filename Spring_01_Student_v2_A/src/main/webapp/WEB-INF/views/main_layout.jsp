<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <title>학사관리</title>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="nav" />
    <tiles:insertAttribute name="content" />
    <tiles:insertAttribute name="foooter"/>
</body>
</html>
