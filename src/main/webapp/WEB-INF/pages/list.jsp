<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="/resources/globle.jsp" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Title</title>
</head>
<body>
    List Page.
    <br>
    欢迎您：<shiro:principal/>.
    <br>
    <a href="${ctxPath}/user">User Page</a>
    <shiro:hasRole name="admin">
        <br>
        <a href="${ctxPath}/admin">Admin Page</a>
    </shiro:hasRole>
    <br>
    <a href="${ctxPath}/testShiroAnnotation">Test ShiroAnnotation</a>
    <br>
    <a href="${ctxPath}/logout">退出</a>

</body>
</html>