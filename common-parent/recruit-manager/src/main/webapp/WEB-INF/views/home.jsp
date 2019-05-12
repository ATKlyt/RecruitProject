<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/4/29
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>个人主页</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
    <script>
        //new Date出来的时间快14小时
        var nowDate = new Date().getTime()+50400000;
        //考试开始时间
        var beginDate = new Date("${time.beginTime}").getTime();
        var differ = nowDate - beginDate;
        document.cookie="differ="+differ;
    </script>
</head>
<hr/>
<div style="float: right">
    <ol class="nav nav-pills">
        <li role="presentation">
            <img id="userAvatar" src="${user.avatar}" width="40px" height="40px" border="1">
        </li>
        <li role="presentation" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
               aria-expanded="false">
                用户：${user.nickname} <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <a  data-toggle="modal" data-target="#myModal">修改头像</a><br/>
                <a  id="updateNickname" data-toggle="modal" data-target="#myModal1">修改昵称</a><br/>
                <a  href="${pageContext.request.contextPath}/user/exit.do">安全退出</a>
            </ul>
        </li>
    </ol>
</div>

<ol class="nav nav-pills">
    <li role="presentation" class="active dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
           aria-expanded="false">
            我的报名 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <a href="${pageContext.request.contextPath}/entryForm/entryForm.do">我要报名</a><br/>
            <a href="${pageContext.request.contextPath}/entryForm/updateEntryForm.do">修改信息</a>
        </ul>
    </li>

    <li role="presentation" class="active dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
           aria-expanded="false">
            我的应聘 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <c:if test="${studentInfo.status == 2 }">
                <a href="${pageContext.request.contextPath}/time/getTypeTime.do?type=0">笔试时间</a><br/>
            </c:if>

            <c:if test="${studentInfo.status == 3 || studentInfo.status == 4}">
                <a href="${pageContext.request.contextPath}/exam/toExam.do?userId=${user.id}">我的笔试</a><br/>
                <a href="${pageContext.request.contextPath}/time/getTypeTime.do?type=0">笔试时间</a>
            </c:if>

            <c:if test="${studentInfo.status == 5}">
                <a href="${pageContext.request.contextPath}/exam/toExam.do?userId=${user.id}">我的笔试</a><br/>
                <a href="${pageContext.request.contextPath}/time/getTypeTime.do?type=0">笔试时间</a><br/>
                <a href="${pageContext.request.contextPath}/time/getTypeTime.do?type=1">面试时间</a>
            </c:if>
            <c:if test="${studentInfo.status == 7}">
                <a href="${pageContext.request.contextPath}/exam/toExam.do?userId=${user.id}">我的笔试</a><br/>
                <a href="${pageContext.request.contextPath}/time/getTypeTime.do?type=0">笔试时间</a><br/>
                <a href="${pageContext.request.contextPath}/time/getTypeTime.do?type=1">面试时间</a><br/>
                <a href="${pageContext.request.contextPath}/interview/getInterview.do">面试成绩</a>
            </c:if>
            
            
        </ul>
    </li>

    <li role="presentation" class="active dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
           aria-expanded="false">
            我的面板 <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <a href="${pageContext.request.contextPath}/studentInfo/findDetail.do?id=${user.id}">个人信息</a><br/>
            <a href="${pageContext.request.contextPath}/studentInfo/update.do">修改信息</a><br/>
            <a href="${pageContext.request.contextPath}/user/updatePassword.do">修改密码</a>
        </ul>
    </li>
</ol>

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
        })
        return false;
    })

</script>
<body>

</body>
</html>
