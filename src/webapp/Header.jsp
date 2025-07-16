<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <h3>${requestScope.wordBundle.getWord("MYTESTDATINGAPP")}</h3>
    <form action="lang" method="post">
        <button name="lang" value="ru">ru</button>
        <button name="lang" value="en">en</button>
    </form>
    <h4>${requestScope.wordBundle.getWord("currentLang")}${cookie["lang"].value}</h4>
    <hr>
</div>