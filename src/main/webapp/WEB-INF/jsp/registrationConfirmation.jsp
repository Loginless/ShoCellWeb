<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted user information</h2>
<table>
    <tr>
        <td>Login</td>
        <td>${login}</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>${age}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${email}</td>
    </tr>
</table>
</body>
</html>