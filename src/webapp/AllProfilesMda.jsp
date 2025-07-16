<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>${requestScope.wordBundle.getWord("allProfiles")}</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>

        <c:forEach var="profile" items="${requestScope.profiles}">
            <form action="profile" method="get">
                <input type="hidden" name="method" value="findById"/>
                <input type="hidden" name="id" value="${profile.id}"/>
                <button type="submit">${profile.name} ${profile.surname}</button>
            </form>
        </c:forEach>

        <a href='ProfileManagerPage.jsp'>${requestScope.wordBundle.getWord("profileManager")}</a>
        <%@include file="Footer.jsp" %>
    </body>
</html>
