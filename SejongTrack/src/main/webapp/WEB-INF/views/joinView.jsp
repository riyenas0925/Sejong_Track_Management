<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Join page</h2>
<form action="/memberJoin" method="post">
    id : <input type="text" name="id"><br>
    e-mail : <input type="text" name="email"><br>
    name : <input type="text" name="name"><br>
    password : <input type="text" name="password"><br>
    <input type="submit" value="가입"> <input type="reset" value="취소">
</form>
</body>
</html>