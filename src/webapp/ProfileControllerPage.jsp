<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <title>Profile manager</title>
    </head>
    <body>
        <%@include file="Header.jsp"%>

        <h3>Profile manager</h3>
        <h3>${requestScope.response}</h3>

        <a href='${pageContext.request.contextPath}/profile.html'>Main</a>
        <%@include file="Footer.jsp"%>
    </body>
</html>