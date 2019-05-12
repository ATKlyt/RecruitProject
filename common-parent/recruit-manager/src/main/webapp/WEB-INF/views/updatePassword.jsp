<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/1
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>修改密码</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">用户登录</h3>
    <form id="updatePasswordForm" action="${pageContext.request.contextPath}/user/toUpdatePassword.do" method="post">

        <input type="hidden" name="id" value="${user.id}"/>

        <div class="form-group">
            <label for="originalPassword">原密码：</label>
            <input type="password" name="originalPassword" class="form-control" id="originalPassword" placeholder="请输入原密码"/>
        </div>
        <div class="form-group">
            <label for="newPassword">新密码：</label>
            <input type="password" name="newPassword" class="form-control" id="newPassword" placeholder="请输入新密码"/>
        </div>
        <div class="form-group">
            <label for="confirmationPassword">确认密码：</label>
            <input type="password" name="confirmationPassword" class="form-control" id="confirmationPassword" placeholder="请确认新密码"/>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="确认修改">
        </div>
    </form>
</div>


<script src="../../js/login.js" ></script>

</body>
</html>
