<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/4/29
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>新用户注册</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <div>
        <h3 style="text-align: center;">
            <p>新用户注册</p>
            <p>USER REGISTER</p>
        </h3>
    </div>
    <div class="rg_form_center">
        <!--注册表单-->
        <form class="form-horizontal" id="registerForm" action="user/toRegister.do" method="post">
            <!--提交处理请求的标识符-->
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" id="username" class="form-control" name="username" placeholder="请输入账号"/>
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" id="password" class="form-control" name="password" placeholder="请输入密码"/>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" id="email" class="form-control" name="email" placeholder="请输入Email"/>
            </div>
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" id="name" class="form-control" name="name" placeholder="请输入真实姓名"/>
            </div>
            <div class="form-group">
                <label for="school">学校</label>
                <input type="text" id="school" class="form-control" name="school" placeholder="请输入您的学校"/>
            </div>
            <div class="form-group">
                <label for="grade">年级</label>
                <input type="text" id="grade" class="form-control" name="grade" placeholder="请输入您的年级"/>
            </div>
            <div class="form-group">
                <label for="number">学号</label>
                <input type="text" id="number" class="form-control" name="number" placeholder="请输入您的学号"/>
            </div>

            <div class="form-inline">
                <label for="code">验证码：</label>
                <input type="text" name="code" class="form-control" id="code" placeholder="请输入验证码"
                       style="width: 150px;"/>
                <img id="imgCode" src="/check/checkCode.do" title="看不清点击刷新" align="right" style="height: 35px; width: 100px ;"
                     class="img-rounded" onclick="this.src='/check/checkCode.do?d='+Math.random();"/>
            </div>
            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="submit" value="注册">
                <input class="btn btn btn-group" type="reset" value="重置">
            </div>

        </form>
    </div>
    <div class="rg_form_right">
        <p>
            已有账号？
            <a href="${pageContext.request.contextPath}/user/index.do">立即登录</a>
        </p>
    </div>
</div>


<script src="../../js/login.js" ></script>

</body>
</html>
