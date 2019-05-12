<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/4/29
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Title</title>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../layui/css/layui.css" rel="stylesheet" media="all">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div style="float: right">
    <ul class="nav nav-pills">
        <li role="presentation">
            <img id="userAvatar" src="${user.avatar}" width="40px" height="40px" border="1">
        </li>
        <li role="presentation" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
               aria-expanded="false">
                用户：${user.nickname} <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <a data-toggle="modal" data-target="#myModal">修改头像</a><br/>
                <a  id="updateNickname" data-toggle="modal" data-target="#myModal1">修改昵称</a><br/>
                <a  href="${pageContext.request.contextPath}/user/exit.do">安全退出</a>
            </ul>
        </li>
    </ul>
</div>

<div class="layui-side" class="layui-side-bg" class="layui-larry-side" id="larry-side">
    <div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">
        <ul class="layui-nav layui-nav-tree layui-inline" style="margin-right: 10px;" lay-filter="demo">
            <li class="layui-nav-item layui-this">
                <a href="javascript:;" data-url="main.html">
                    <span>后台首页</span>
                </a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <span>我的面板</span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/user/updatePassword.do">修改密码</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/user/exit.do">安全退出</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item ">
                <a href="javascript:;">
                    <span>招聘管理</span>
                </a>
                <dl class="layui-nav-child">
                    <%--查看所有考生--%>
                    <%--安排笔试时间--%>
                    <c:if test="${user.role == '笔试官'}">
                        <dd><a href="${pageContext.request.contextPath}/user/examineeList.do">考生管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/time/getTypeTime.do?type=0">时间管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/blank/findBlankAnswerList.do">阅卷管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/question/findAllQuestion.do">题库管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/testPaper/testPaperList.do">组卷管理</a></dd>
                    </c:if>
                    <%--安排面试时间--%>
                    <c:if test="${user.role == '面试官'}">
                        <dd><a href="${pageContext.request.contextPath}/user/examineeList.do">考生管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/time/getTypeTime.do?type=1">时间管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/interview/findInterviewList.do">面试管理</a></dd>
                    </c:if>
                </dl>
                <c:if test="${user.role == '超级管理员'}">
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/user/commonUserList.do">普通用户管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/user/examineeList.do">考生管理</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/user/adminList.do">管理员管理</a></dd>
                    </dl>
                </c:if>
            </li>
        </ul>
    </div>

</div>

<!-- 按钮触发模态框 -->

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">更换头像</h4>
            </div>
            <div class="modal-body">
                <form id="imgForm" action="${pageContext.request.contextPath}/user/updateAvatar.do" method="post">
                    <input  type="hidden" name="id" value="${user.id}"/>
                    <img id="imgAvatar" src="${user.avatar}" width="100px" height="100px" border="1">
                    <input type="file" name="userAvatar" onchange="submitImage();">
                    <input id="avatar" type="hidden" name="avatar" value="${user.avatar}">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"  data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" id="btn-uploadAvatar">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel1">更换头像</h4>
            </div>
            <div class="modal-body">
                <form id="nicknameForm" action="${pageContext.request.contextPath}/user/updateNickname.do" method="post">
                    <input type="hidden" name="userId" value="${user.id}">
                    <div class="form-group">
                        <label for="nickname">密码：</label>
                        <input type="text" name="nickname" class="form-control" id="nickname" placeholder="请输入昵称"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"  data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" id="btn-updateNickname">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<script>
    function submitImage() {
        alert("提交图片到后台");
        var options = {
            type:'POST',
            data:{
                username:"${user.username}"
            },
            dataType:'json',
            url:'${pageContext.request.contextPath}/upload/userAvatar.do',
            success:function (respData) {
                $('#imgAvatar').attr('src',respData.imgUrl);
                $('#avatar').val(respData.imgUrl)
            }
        }
        //提交表单
        $('#imgForm').ajaxSubmit(options)
    }


    $(function () {
        $("#btn-uploadAvatar").click(function () {
            $.ajax({
                type:"POST",
                data:$("#imgForm").serialize(),
                url:"${pageContext.request.contextPath}/user/updateAvatar.do",
                dataType:"text",
                success:function (data) {
                    alert("保存成功");
                    location.reload();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.readyState);
                    alert(textStatus);
                    alert(errorThrown)
                }
            })
        });
        return false;
    });

    $(function () {

        $("#updateNickname").click(function () {
            $("#nicknameForm")[0].reset();// 每次关闭表单后重新打开表单需要清空表单的数据
            $("#btn-updateNickname").click(function () {
                updateNickname()
            });
        });
    });

    function updateNickname() {
        $.ajax({
            type:"POST",
            data:$("#nicknameForm").serialize(),
            url:"${pageContext.request.contextPath}/user/updateNickname.do",
            dataType:"text",
            success:function (data) {
                alert("保存成功");
                location.reload();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.readyState);
                alert(textStatus);
                alert(errorThrown)
            }
        })
    }
</script>

<script type="text/javascript" src="../../layui/layui.all.js"></script>


</body>
</html>
