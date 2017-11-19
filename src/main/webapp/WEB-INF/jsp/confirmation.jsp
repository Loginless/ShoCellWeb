<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Confirmation Page</title>
</head>
<body>
login:${registeredUser.login}
<br>
password:${registeredUser.password}
<br>
email:${registeredUser.email}
<br>
<hr>
<sf:form action="confirmation" method="GET">
    <button name="confirmation" type="submit"> Confirmation
    </button>
</sf:form>
</body>
</html>