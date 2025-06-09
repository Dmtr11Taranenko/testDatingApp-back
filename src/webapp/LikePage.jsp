<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <%@include file="Header.jsp"%>

    <h3>${requestScope.answer}</h3>
    <h3>${requestScope.userAgent}</h3>
    <h3>${requestScope.reqURL}</h3>
    <a href='${pageContext.request.contextPath}/home-page-MyDatingApp'>Main</a>

    <%@include file="Footer.jsp"%>
</body>
</html>