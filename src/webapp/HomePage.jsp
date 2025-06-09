<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
    <head>
        <title>MyDatingApp</title>
    </head>
    <body>
        <%@include file="Header.jsp"%>

        <h3>Welcome to my Dating App!</h3>
        <h3>Here you can choose some method and look what happening </h3>

        <form action = "like" method = "get">
            <button type = "submit">Go to page with like</button>
        </form>

        <form action = "forward" method = "get">
            <button type = "submit">Go to page with forward</button>
        </form>

        <form action = "profile.html" method = "get">
            <button type = "submit">Go to page with profiles</button>
        </form>

        <a href='index.html'>Main</a>

        <%@include file="Footer.jsp"%>
    </body>
</html>