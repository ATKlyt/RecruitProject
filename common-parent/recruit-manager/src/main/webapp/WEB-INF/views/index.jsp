<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/4/28
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>用户登录</title>
<%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>

    <script>
        //校验用户名
        function checkUsername() {
            //1.获取用户名值
            var username = $("#username").val();
            //2.定义正则
            var reg_username = /^\w{1,20}$/;
            //3.判断，给出提示信息
            var flag = reg_username.test(username);
            if (flag) {
                //用户名合法
                $("#username").css("border", "1px solid green");
            } else {
                //用户名非法,加一个红色边框
                $("#username").css("border", "1px solid red");
            }
            return flag;
        }

        //校验密码
        function checkPassword() {
            //1.获取密码值
            var password = $("#password").val();
            //2.定义正则
            var reg_password = /^[A-Za-z0-9_]{1,20}$/;
            //3.判断，给出提示信息
            var flag = reg_password.test(password);
            if (flag) {
                //密码合法
                $("#password").css("border", "1px solid green");
            } else {
                //密码非法,加一个红色边框
                $("#password").css("border", "1px solid red");
            }
            return flag;
        }

        //校验验证码
        function checkCode() {
            //1.获取学号
            var checkCode = $("#checkCode").val();
            //2.定义正则
            var reg_checkCode = /^\d{4}$/;
            //3.判断，给出提示信息
            var flag = reg_checkCode.test(checkCode);
            if (flag) {
                //学号合法
                $("#checkCode").css("border", "1px solid green");
            } else {
                //学号非法,加一个红色边框
                $("#checkCode").css("border", "1px solid red");
            }
            return flag;
        }

        $(function () {
            //当表单提交时，调用所有的校验方法
            $("#loginForm").submit(function () {
                //1.发送数据到服务器
                if (checkUsername() && checkPassword()) {

                    //var parameters = $("#loginForm").serialize();
                    //var jsonObj = JSON.stringify(parameters);

                    //校验通过,发送ajax请求，提交表单的数据
                    $.ajax({
                        type:"post",
                        url:"${pageContext.request.contextPath}/user/login.do",
                        data:$("#loginForm").serialize(),
                        success:function (resultInfo) {
                            console.log(resultInfo);
                            if(resultInfo.flag){
                                alert("登录成功")
                                if(resultInfo.tipMsg === "用户"){
                                    location.href="${pageContext.request.contextPath}/user/home.do";
                                }else{
                                    location.href="${pageContext.request.contextPath}/user/manager.do";
                                }
                            }else {
                                //失败,给errorMsg添加提示信息
                                alert(resultInfo.tipMsg);
                                //使验证码刷新
                                location.reload();
                            }
                        },
                        dataType:"json",
                    })
                }
                //2.不让页面跳转
                return false;
                //如果这个方法没有返回值，或者返回为true，则表单提交，如果返回为false，则表单不提交
            });

            //当某一个组件失去焦点是，调用对应的校验方法
            $("#username").blur(checkUsername);
            $("#password").blur(checkPassword);
            $("#checkCode").blur(checkCode);
        });

    </script>
</head>
<body>


<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">用户登录</h3>
    <form id="loginForm" action="user/login.do" method="post">
        <div class="form-group">
            <label for="username">用户名：</label>
            <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"/>
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>
        <div class="form-inline">
            <label for="code">验证码：</label>
            <input type="text" name="code" class="form-control" id="code" placeholder="请输入验证码" style="width: 150px;"/>
            <img src="/check/checkCode.do" title="看不清点击刷新" align="right"  style="height: 35px; width: 100px ;"
                 class="img-rounded" onclick="this.src='/check/checkCode.do?d='+Math.random();"/>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>
    <hr/>
<div style="text-align: center">
    <span>尚未注册?<a href="${pageContext.request.contextPath}/user/register.do">立即注册</a></span><br/>
    <span>忘记密码?<a href="${pageContext.request.contextPath}/user/find.do">找回密码</a></span>
</div>
</div>
</body>
</html>
