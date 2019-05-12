<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/2
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${activeMsg.flag == true}">
    <div style="text-align: center; padding:11% 0;">
        <p>${activeMsg.tipMsg}</p>
        <p ><a href="${pageContext.request.contextPath}/user/home.do" style="font-size: 20px; font-weight: 300; color: #01AAED;">返回主页</a></p>
    </div>
</c:if>
<c:if test="${activeMsg.flag == false}">
    ${activeMsg.tipMsg}
</c:if>
</body>
</html>
