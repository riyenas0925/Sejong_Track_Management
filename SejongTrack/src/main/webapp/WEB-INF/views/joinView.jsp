<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Join page</h2>
<form action="/memberJoin" method="post">
    id : <input type="text" name="id" required><br>
    e-mail : <input type="text" name="email" required><br>
    name : <input type="text" name="name" required><br>
    password : <input type="text" name="password" required><br>
    *모두 입력하세요<br>
    <input type="submit" value="가입"> <input type="reset" value="취소">
</form>
</body>
</html>