<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="resources/globle.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
</head>
<body>
    Login Page.
    <form id="" action="${ctxPath}/login">
        <br><br>
        <label for="username">姓名：</label><input id="username" name="username" type="text">
        <br><br>
        <label for="password">密码：</label><input id="password" name="password" type="password">
        <br><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>