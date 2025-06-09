<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
    <head>
        <title>Profile manager</title>
    </head>
    <body>
        <%@include file="Header.jsp"%>

        <h3>Profile manager</h3>
        <h3>${requestScope.response}</h3>

        <a href='${pageContext.request.contextPath}/home-page-MyDatingApp'>Main</a>
        <%@include file="Footer.jsp"%>
    </body>
</html>