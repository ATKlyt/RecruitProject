<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/7
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>管理员列表</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">管理员信息列表</h3>
    <div style="float: left;">
        <form class="form-inline"
              action="${pageContext.request.contextPath}/user/adminList.do"
              method="post">
            <div class="form-group">
                <label for="name">姓名：</label>
                <input type="text" name="name" class="form-control" id="name" value="${condition.name[0]}">
            </div>
            <div class="form-group">
                <label for="role">角色：</label>
                <input type="text" name="role" class="form-control" id="role" value="${condition.role[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right; margin: 5px;">
        <a class="btn btn-default" href="${pageContext.request.contextPath}/user/manager.do">返回</a>
        <button id="addAdmin" class="btn btn-primary" data-toggle="modal" data-target="#myModal">添加管理员</button>
    </div>
    <form id="form" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>编号</th>
                <th>头像</th>
                <th>用户名</th>
                <th>姓名</th>
                <th>昵称</th>
                <th>身份</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${adminList}" var="admin" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td><img src="${admin.avatar}" width="20px" height="20px"></td>
                    <td>${admin.username}</td>
                    <td>${admin.name}</td>
                    <td>${admin.nickname}</td>
                    <td>${admin.role}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/user/adminFind.do?userId=${admin.id}">查看</a>&nbsp;
                        <c:if test="${user.role == '超级管理员' && admin.role != '超级管理员'}">
                        <a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/user/updateAdmin.do?userId=${admin.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/user/delete.do?userId=${admin.id}">删除</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${page.pageNum == 1}"><li class="disabled"></c:if>
                <c:if test="${page.pageNum != 1}"><li></c:if>
                <a href="${pageContext.request.contextPath}/user/adminList.do?page=${page.prePage}&name=${condition.name[0]}&role=${condition.role[0]}"
                   aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
                <c:forEach begin="1" end="${page.pages}" var="i">
                    <c:if test="${page.pageNum == i}">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/user/adminList.do?page=${i}&name=${condition.name[0]}&role=${condition.role[0]}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${page.pageNum != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/user/adminList.do?page=${i}&name=${condition.name[0]}&role=${condition.role[0]}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.pageNum == page.pages}"><li class="disabled"></c:if>
                <c:if test="${page.pageNum != page.pages}"><li></c:if>
                <a href="${pageContext.request.contextPath}/user/adminList.do?page=${page.nextPage}&name=${condition.name[0]}&role=${condition.role[0]}"
                   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
                <span style="font-size: 25px; margin-left: 5px;">
						共${page.total}条记录，共${page.pages}页 </span>

            </ul>
        </nav>
    </div>

</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">添加管理员</h4>
            </div>
            <div class="modal-body">
                <form id="adminForm" action="${pageContext.request.contextPath}/user/addAdmin.do" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label for="adminUsername" class="col-sm-2 control-label">用户名:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="adminUsername"
                                   name="adminUsername" placeholder="用户名">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="adminPassword" class="col-sm-2 control-label">密码:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="adminPassword"
                                   name="adminPassword" placeholder="密码">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="adminName" class="col-sm-2 control-label">姓名:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="adminName"
                                   name="adminName" placeholder="姓名">
                            <span class="help-block"></span>
                        </div>


                    </div>
                    <div class="form-group">
                        <label for="adminRole" class="col-sm-2 control-label">角色:</label>
                        <div class="col-sm-4" id="adminRole">
                            <select class="form-control" name="adminRole">
                                <option>笔试官</option>
                                <option>面试官</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"  data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" id="btn-save">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<script>
    $(function() {
        $("#addAdmin").click(function () {
            clear($("#adminUsername"));
            clear($("#adminPassword"));
            clear($("#adminName"));
            $("#adminForm")[0].reset();// 每次关闭表单后重新打开表单需要清空表单的数据
            checkAdminUsername();
        });
        $("#btn-save").click(function () {
            if (validate()) {
                if ($("#btn-save").attr("ajax-value") == "false") {
                    alert("无法插入");
                } else {
                    save();
                }
            }
        });
    });

    function save(){
        $.ajax({
            url  : "${pageContext.request.contextPath}/user/addAdmin.do",
            type : "POST",
            data : $("#adminForm").serialize()
        });
        $('#myModal').modal('hide');
        alert("保存成功")
        location.reload();

    }
    function validate() {// 校验表单数据
        var adminUsername = $("#adminUsername").val();
        var regUsername = /^\w{1,20}$/;
        if (!regUsername.test(adminUsername)) {
            show_validate_message($("#adminUsername"), false, "用户名格式不正确")
            return false;
        } else {
            show_validate_message($("#adminUsername"), true, "")
        }

        var adminPassword = $("#adminPassword").val();
        var regPassword = /^[A-Za-z0-9_]{1,20}$/;
        if (!regPassword.test(adminPassword)) {
            show_validate_message($("#adminPassword"), false, "密码格式不正确")
            return false;
        } else {
            show_validate_message($("#adminPassword"), true, "")
        }

        var adminName = $("#adminName").val();
        var regName = /^([\u4e00-\u9fa5·]|[A-Za-z]){2,}$/;
        if (!regName.test(adminName)) {
            // alert("邮箱格式不对");
            show_validate_message($("#adminName"), false, "姓名格式不正确")
            return false;
        } else {
            show_validate_message($("#adminName"), true, "")
            if ($("#btn-save").attr("ajax-value") == false) {
                alert("不成功");
                return false;
            }
            return true;
        }

    }
    function checkAdminUsername() {
        $("#adminUsername").change(function() {// 为姓名输入框绑定一个change事件,发送ajax请求,检测是否用户已经注册
            var adminUsername = $("#adminUsername").val();
            $.ajax({
                url : "${pageContext.request.contextPath}/user/checkAdminUsername.do",
                data : {
                    "adminUsername" : adminUsername
                },
                type : "POST",
                success : function(resultInfo) {
                    if (resultInfo.flag) {
                        show_validate_message($("#adminUsername"), true, "");
                        $("#btn-save").attr("ajax-value", true);
                    } else {
                        show_validate_message($("#adminUsername"), false, "用户名不可用");
                        $("#btn-save").attr("ajax-value", false);
                    }
                }
            })
        });
    }
    function show_validate_message(element, flag, msg) {// 显示校验的结果和信息
        clear(element);
        if (flag == true) {
            $(element).parent().addClass("has-success");
        }
        if (flag == false) {
            $(element).parent().addClass("has-error");
            $(element).next("span").text(msg);
        }
    }
    function clear(element) {
        // 每次显示前要清空
        $(element).parent().removeClass("has-success");
        $(element).parent().removeClass("has-error");
        $(element).next("span").empty();
    }
</script>
</body>
</html>
