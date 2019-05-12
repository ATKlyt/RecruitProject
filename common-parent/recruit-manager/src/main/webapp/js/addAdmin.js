$(function() {
    $("#addAdmin").click(function () {
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
        url :  "../user/toSave.do",
        type : "POST",
        data : $("#adminForm").serialize(),
        success : function(resultInfo) {
            if (resultInfo.flag) {
                alert(resultInfo.tipMsg);
                $('#myModal').modal('hide');// 关闭模态框
            } else {
                alert(resultInfo.tipMsg);
            }
        }
    });
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
    }

    var adminNickname = $("#adminNickname").val();
    var regNickname = /^([\u4e00-\u9fa5·]|[A-Za-z]){2,}$/;
    if (!regNickname.test(adminNickname)) {
        // alert("邮箱格式不对");
        show_validate_message($("#adminNickname"), false, "昵称格式不正确")
        return false;
    } else {
        show_validate_message($("#adminNickname"), true, "")
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
            url : "../user/checkAdminUsername.do",
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