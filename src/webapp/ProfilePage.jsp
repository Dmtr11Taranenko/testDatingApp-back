<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Profile id${requestScope.profile.id}</title>
</head>
<body>
    <%@include file="Header.jsp"%>

    <div>
        <form method="post" action="profile">
            <c:if test="${requestScope.profile.id != 0}">
                <input type="hidden" name="_method" value="PUT">
            </c:if>
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

                <tr>
                    <td><h4>Gender</h4></td>
                    <td>
                        <select name="gender">
                            <option value="${requestScope.profile.gender}" selected hidden>${requestScope.profile.gender}</option>
                            <c:forEach var="gender" items="${applicationScope.genders}">
                                <option value="${gender}">${gender}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <button type="submit">Save</button>
        </form>

        <c:if test="${requestScope.profile.id != 0}">
            <form method="post" action="profile">
                <input type="hidden" name="_method" value="DELETE">
                <input type="hidden" name="id" value="${requestScope.profile.id}">
                <button type="submit">Delete</button>
            </form>
        </c:if>


    </div>

    <a href='ProfileManagerPage.jsp'>Profile manager</a>
    <%@include file="Footer.jsp"%>
</body>
</html>
