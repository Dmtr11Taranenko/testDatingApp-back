<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <h3>MY TEST DATING APP</h3>
    <form action="lang" method="post">
        <button name="lang" value="ru">ru</button>
        <button name="lang" value="en">en</button>
    </form>
    <h4>Current lang: ${cookie["lang"].value}</h4>
    <hr>
</div>