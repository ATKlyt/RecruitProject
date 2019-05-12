<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/12
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>修改管理员信息</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <div>
        <h3 style="text-align: center;">修改管理员信息
        </h3>
    </div>
    <div class="rg_form_center">
        <!--注册表单-->
        <form class="form-horizontal" id="registerForm" action="${pageContext.request.contextPath}/user/toUpdateAdmin.do" method="post">
            <!--提交处理请求的标识符-->
            <input type="hidden" value="${user.id}" name="id">
            <div class="form-group">
                <label for="updateUsername">用户名</label>
                <input type="text" id="updateUsername" class="form-control" name="updateUsername" value="${user.username}" placeholder="请输入账号" readonly/>
            </div>
            <div class="form-group">
                <label for="updatePassword">密码</label>
                <input type="password" id="updatePassword" class="form-control" name="updatePassword" value="${user.password}" placeholder="请输入密码" readonly/>
            </div>

            <div class="form-group">
                <label for="updateNickname">昵称</label>
                <input type="text" id="updateNickname" class="form-control" name="updateNickname" value="${user.nickname}" placeholder="请输入昵称"/>
            </div>

            <div class="form-group">
                <label for="updateName">名字</label>
                <input type="text" id="updateName" class="form-control" name="updateName" value="${user.name}" placeholder="请输入真实姓名"/>
            </div>
            <div class="form-group">
                <label for="updateRole" class="col-sm-2 control-label">角色:</label>
                <div class="col-sm-4" id="updateRole">
                    <select class="form-control" name="updateRole">
                        <option>笔试官</option>
                        <option>面试官</option>
                    </select>
                </div>
            </div>

            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="submit" value="保存">
                <input class="btn btn btn-group" type="reset" value="重置">
            </div>

        </form>
    </div>
</div>

</body>
</html>
