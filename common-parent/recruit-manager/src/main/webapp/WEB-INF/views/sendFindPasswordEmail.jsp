<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/12
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>找回密码</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">用户登录</h3>
    <form id="findEmailForm" action="${pageContext.request.contextPath}/user/sendFindPasswordEmail.do" method="post">
        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="email" name="email" class="form-control" id="email" placeholder="请输入邮箱"/>
        </div>
        <div class="form-inline">
            <label for="code">验证码：</label>
            <input type="text" name="code" class="form-control" id="code" placeholder="请输入验证码" style="width: 150px;"/>
            <img src="/check/checkCode.do" title="看不清点击刷新" align="right"  style="height: 35px; width: 100px ;"
                 class="img-rounded" onclick="this.src='/check/checkCode.do?d='+Math.random();"/>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="找回密码">
        </div>
    </form>
</div>


<script src="../../js/login.js" ></script>
</body>
</html>
