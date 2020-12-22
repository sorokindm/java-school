<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Rehabilitation</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>
<div class="navbar">
    <a class="navbar-link" href="${pageContext.request.contextPath}/">Reha</a>
</div>
<br>
<div class="login">
    <form method="post"
          action="doLogin">
        <table>
            <tr>
                <td><input value="admin" type="text" name="username"></td>
            </tr>
            <tr>
                <td><input value="admin" type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Log in"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>