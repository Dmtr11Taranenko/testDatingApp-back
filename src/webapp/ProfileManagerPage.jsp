<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <title>${requestScope.wordBundle.getWord("profileManager")}</title>
    </head>
    <body>
        <%@include file="Header.jsp"%>

        <h3>${requestScope.wordBundle.getWord("profileManager")}</h3>
        <h3>${requestScope.wordBundle.getWord("hereYouCanManageProfiles")}</h3>

        <form action = "registration" method = "get">
            <button type = "submit">${requestScope.wordBundle.getWord("registrationNewProfile")}</button>
        </form>

        <form action = "profile" method = "get">
            <input type="text" name="method" value="findAll" hidden>
            <button type = "submit">${requestScope.wordBundle.getWord("showAllProfiles")}</button>
        </form>

        <form action = "profile" method = "get">
            <input type="text" name="method" value="findById" hidden>
            <input type="text" name="id">
            <button type = "submit">${requestScope.wordBundle.getWord("findProfile")}</button>
        </form>

        <a href='HomePageMDA.jsp'>${requestScope.wordBundle.getWord("homePage")}</a>

        <%@include file="Footer.jsp"%>
    </body>
</html>
