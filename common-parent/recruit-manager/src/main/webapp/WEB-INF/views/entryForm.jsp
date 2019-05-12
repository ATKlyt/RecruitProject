<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/4/30
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>报名</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>

</head>
<body>
<c:if test="${entryForm != null}" >
    <div style="text-align: center; padding:11% 0;">
        <p style="font-size: 20px; font-weight: 300; color: #999;">你已报名成功，请勿重复报名</p>
    </div>
</c:if>
<c:if test="${entryForm == null}">
<div class="container" style="width: 400px;">
    <div>
        <h3 style="text-align: center;">
            <p>笔试报名</p>
        </h3>
    </div>
    <div class="rg_form_center">
        <!--报名表单-->
        <form class="form-horizontal" id="entryForm" action="${pageContext.request.contextPath}/entryForm/toEntry.do" method="post">
            <!--提交处理请求的标识符-->
            <input type="hidden" name="userId" value="${user.id}">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" id="name" class="form-control" name="name" value="${entryForm.name}" placeholder="请输入真实姓名"/>
            </div>
            <div class="form-group">
                <label>性别：</label>
                <input type="radio" name="gender" value="男" checked="checked" />男
                <input type="radio" name="gender" value="女" />女
            </div>

            <div class="form-group">
                <label for="school">毕业院校</label>
                <input type="text" id="school" class="form-control" name="school" value="${entryForm.school}" placeholder="请输入您的毕业院校"/>
            </div>
            <div class="form-group">
                <label for="age">年龄</label>
                <input type="text" id="age" class="form-control" name="age" value="${entryForm.age}" placeholder="请输入您的年龄"/>
            </div>
            <div class="form-group">
                <label for="major">专业</label>
                <input type="text" id="major" class="form-control" name="major" value="${entryForm.major}" placeholder="请输入您的专业"/>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" id="email" class="form-control" name="email" value="${entryForm.email}" placeholder="请输入您的邮箱"/>
            </div>

            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="submit" value="确定报名">
                <input class="btn btn btn-group" type="reset" value="重置表单">
                <a class="btn btn-default" href="${pageContext.request.contextPath}/user/home.do">返回</a>
            </div>

        </form>
    </div>
</c:if>

        <script src="../../js/login.js" ></script>
</div>
</body>
</html>
