<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile id${requestScope.profile.id}</title>
</head>
<body>
    <%@include file="Header.jsp"%>

    <div>
        <form method="post" action="profile">
            <table>
                <input type="text" name="id" hidden value="${requestScope.profile.id}">
                <tr>
                    <td><h4>Email</h4></td>
                    <td><input type="email" name="email" value="${requestScope.profile.email}"></td>
                </tr>
                <tr>
                    <td><h4>Name</h4></td>
                    <td><input type="text" name="name" value="${requestScope.profile.name}"></td>
                </tr>
                <tr>
                    <td><h4>Surname</h4></td>
                    <td><input type="text" name="surname" value="${requestScope.profile.surname}"></td>
                </tr>
                <tr>
                    <td><h4>About</h4></td>
                    <td><input type="text" name="about" value="${requestScope.profile.about}"></td>
                </tr>
            </table>
            <button type="submit">Save</button>
        </form>
    </div>

    <a href='ProfileManagerPage.jsp'>Main</a>
    <%@include file="Footer.jsp"%>
</body>
</html>
