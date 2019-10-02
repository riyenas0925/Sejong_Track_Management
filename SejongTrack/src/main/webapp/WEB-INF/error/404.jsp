<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>NOT FOUND</title>
</head>
<body>
<div class="cover">
    <p font-size="100">404 NOT-FOUND</p>
    <c:out value="${requestScope['javax.servlet.error.exception']}"/>
</div>
</body>
</html>