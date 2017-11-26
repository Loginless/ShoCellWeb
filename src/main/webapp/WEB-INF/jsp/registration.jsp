<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<style>
    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    /* Set a style for all buttons */
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

    /* Extra styles for the cancel button */
    .cancelbtn {
        padding: 14px 20px;
        background-color: #f44336;
    }

    /* Float cancel and signup buttons and add an equal width */
    .cancelbtn,.signupbtn {
        float: left;
        width: 50%;
    }

    /* Add padding to container elements */
    .container {
        padding: 16px;
    }

    /* Clear floats */
    .clearfix::after {
        content: "";
        clear: both;
        display: table;
    }

    /* Change styles for cancel button and signup button on extra small screens */
    @media screen and (max-width: 300px) {
        .cancelbtn, .signupbtn {
            width: 100%;
        }
    }
</style>
<body>

<h1>Create new user</h1><br>

<form id="registerForm" commandName="registerForm" method="post"
      action="${pageContext.request.contextPath}/registerProcess">

    <div class="container">


        <label><b>Login</b></label>
        <input type="text" placeholder="Enter new Login" name="login" required>

        <label><b>Password</b></label>
        <input type="text" placeholder="Enter Password" name="password" required>

        <label><b>Email</b></label>
        <input type="email" placeholder="Enter Email" name="email" required>
        <div class="clearfix">
            <%--<input type="submit" value="Register new user" name="Register">--%>
            <button type="submit" class="signupbtn">Register new user</button>
        </div>
    </div>

</form>
</body>

</html>