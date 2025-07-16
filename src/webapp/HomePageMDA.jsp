<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <title>${requestScope.wordBundle.getWord("MyDatingApp")}</title>
    </head>
    <body>
        <%@include file="Header.jsp"%>

        <h3>${requestScope.wordBundle.getWord("welcomeToMyDatingApp")}</h3>
        <h3>${requestScope.wordBundle.getWord("hereYouCanChooseSomeMethodAndLookWhatHappening")}</h3>

        <form action = "like" method = "get">
            <button type = "submit">${requestScope.wordBundle.getWord("goToPageWithLike")}</button>
        </form>

        <form action = "forward" method = "get">
            <button type = "submit">${requestScope.wordBundle.getWord("goToPageWithForward")}</button>
        </form>

        <form action = "ProfileManagerPage.jsp" method = "get">
            <button type = "submit">${requestScope.wordBundle.getWord("goToProfileManager")}</button>
        </form>

        <a href='index.html'>${requestScope.wordBundle.getWord("main")}</a>

        <%@include file="Footer.jsp"%>
    </body>
</html>