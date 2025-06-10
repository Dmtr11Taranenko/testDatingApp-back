<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile id${requestScope.profile.id}</title>
</head>
<body>
    <%@include file="Header.jsp"%>

    <div>
        <table>
            <tr>
                <td><h4>Email</h4></td>
                <td><h4>${requestScope.profile.email}</h4></td>
            </tr>
            <tr>
                <td><h4>Name</h4></td>
                <td><h4>${requestScope.profile.name}</h4></td>
            </tr>
            <tr>
                <td><h4>Surname</h4></td>
                <td><h4>${requestScope.profile.surname}</h4></td>
            </tr>
            <tr>
                <td><h4>About</h4></td>
                <td><h4>${requestScope.profile.about}</h4></td>
            </tr>
        </table>
    </div>

    <a href='${pageContext.request.contextPath}/profile.html'>Main</a>
    <%@include file="Footer.jsp"%>
</body>
</html>
