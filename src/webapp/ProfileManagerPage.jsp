<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <title>Profile manager</title>
    </head>
    <body>
        <%@include file="Header.jsp"%>

        <h3>Profile manager</h3>
        <h3>Here you can manage profiles</h3>

        <form action = "registration" method = "get">
            <button type = "submit">Registration new profile</button>
        </form>

        <form action = "profile" method = "get">
            <input type="text" name="method" value="findAll" hidden>
            <button type = "submit">Show all profiles</button>
        </form>

        <form action = "profile" method = "get">
            <input type="text" name="method" value="findById" hidden>
            <input type="text" name="id">
            <button type = "submit">Find profile</button>
        </form>

        <a href='HomePageMDA.jsp'>Home page</a>

        <%@include file="Footer.jsp"%>
    </body>
</html>
