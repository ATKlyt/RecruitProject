
/*
    表单校验：
        1.用户名：匹配字母或数字或下划线或汉字，长度8到20位
        2.密码：匹配字母或数字或下划线，长度8到20位
        3.email：邮件格式
        4.姓名：匹配汉字或字母(不能混搭)，长度至少为2，考虑到外国人名字，非空
        5.学校：匹配至少三位汉字，非空
        6.学号：匹配至少一位数字，非空
        7.年级：匹配四位数字和级字，非空
        7.验证码：非空
 */

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

//校验密码
function checkOriginalPassword() {
    //1.获取密码值
    var originalPassword = $("#originalPassword").val();
    //2.定义正则
    var reg_originalPassword = /^[A-Za-z0-9_]{1,20}$/;
    //3.判断，给出提示信息
    var flag = reg_originalPassword.test(originalPassword);
    if (flag) {
        //密码合法
        $("#originalPassword").css("border", "1px solid green");
    } else {
        //密码非法,加一个红色边框
        $("#originalPassword").css("border", "1px solid red");
    }
    return flag;
}
//校验密码
function checkNewPassword() {
    //1.获取密码值
    var newPassword = $("#newPassword").val();
    //2.定义正则
    var reg_newPassword = /^[A-Za-z0-9_]{1,20}$/;
    //3.判断，给出提示信息
    var flag = reg_newPassword.test(newPassword);
    if (flag) {
        //密码合法
        $("#newPassword").css("border", "1px solid green");
    } else {
        //密码非法,加一个红色边框
        $("#newPassword").css("border", "1px solid red");
    }
    return flag;
}
//校验密码
function checkConfirmationPassword() {
    //1.获取密码值
    var confirmationPassword = $("#confirmationPassword").val();
    //2.定义正则
    var reg_confirmationPassword = /^[A-Za-z0-9_]{1,20}$/;
    //3.判断，给出提示信息
    var flag = reg_confirmationPassword.test(confirmationPassword);
    if (flag) {
        //密码合法
        $("#confirmationPassword").css("border", "1px solid green");
    } else {
        //密码非法,加一个红色边框
        $("#confirmationPassword").css("border", "1px solid red");
    }
    return flag;
}



//校验邮箱
function checkEmail() {
    //1.获取邮箱
    var email = $("#email").val();
    //2.定义正则		itcast@163.com
    var reg_email = /^\w+@\w+\.\w+$/;
    //3.判断
    var flag = reg_email.test(email);
    if (flag) {
        $("#email").css("border", "1px solid green");
    } else {
        $("#email").css("border", "1px solid red");
    }
    return flag;
}

//校验姓名
function checkName() {
    //1.获取姓名
    var name = $("#name").val();
    //2.定义正则
    var reg_name = /^([\u4e00-\u9fa5·]|[A-Za-z]){2,}$/;
    //3.判断，给出提示信息
    var flag = reg_name.test(name);
    if (flag) {
        //姓名合法
        $("#name").css("border", "1px solid green");
    } else {
        //姓名非法,加一个红色边框
        $("#name").css("border", "1px solid red");
    }
    return flag;
}

//校验学校
function checkSchool() {
    //1.获取学校
    var school = $("#school").val();
    //2.定义正则
    var reg_school = /^[\u4e00-\u9fa5]{3,}$/;
    //3.判断，给出提示信息
    var flag = reg_school.test(school);
    if (flag) {
        //学校合法
        $("#school").css("border", "1px solid green");
    } else {
        //学校非法,加一个红色边框
        $("#school").css("border", "1px solid red");
    }
    return flag;
}

//校验学号
function checkNumber() {
    //1.获取学号
    var number = $("#number").val();
    //2.定义正则
    var reg_number = /^\d+$/;
    //3.判断，给出提示信息
    var flag = reg_number.test(number);
    if (flag) {
        //学号合法
        $("#number").css("border", "1px solid green");
    } else {
        //学号非法,加一个红色边框
        $("#number").css("border", "1px solid red");
    }
    return flag;
}

//校验年级
function checkGrade() {
    //1.获取年级
    var grade = $("#grade").val();
    //2.定义正则
    var reg_grade = /^\d{4}[\u4e00-\u9fa5]$/;
    //3.判断，给出提示信息
    var flag = reg_grade.test(grade);
    if (flag) {
        //年级合法
        $("#grade").css("border", "1px solid green");
    } else {
        //年级非法,加一个红色边框
        $("#grade").css("border", "1px solid red");
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

//校验专业
function checkMajor(){
    //1.获取专业
    var major = $("#major").val();
    //2.定义正则
    var reg_major = /^[\u4e00-\u9fa5]{3,}$/;
    //3.判断，给出提示信息
    var flag = reg_major.test(major);
    if (flag) {
        //专业合法
        $("#major").css("border", "1px solid green");
    } else {
        //专业非法,加一个红色边框
        $("#major").css("border", "1px solid red");
    }
    return flag;
}

//校验年龄
function checkAge(){
    //1.获取年龄
    var age = $("#age").val();
    //2.定义正则
    var reg_age = /^\d{1,3}$/;
    //3.判断，给出提示信息
    var flag = reg_age.test(age);
    if (flag) {
        //年龄合法
        $("#age").css("border", "1px solid green");
    } else {
        //年龄非法,加一个红色边框
        $("#age").css("border", "1px solid red");
    }
    return flag;
}

//校验身份证
function checkIdentityCard(){
    //1.获取身份证
    var identityCard = $("#identityCard").val();
    //2.定义正则
    var reg_identityCard = /^\d{18}$/;
    //3.判断，给出提示信息
    var flag = reg_identityCard.test(identityCard);
    if (flag) {
        //身份证合法
        $("#identityCard").css("border", "1px solid green");
    } else {
        //身份证非法,加一个红色边框
        $("#identityCard").css("border", "1px solid red");
    }
    return flag;
}

$(function () {
    //当表单提交时，调用所有的校验方法
    $("#registerForm").submit(function () {
        //1.发送数据到服务器


        if (checkUsername()  && checkNumber() && checkPassword()  && checkEmail() &&
            checkSchool()  && checkGrade() && checkName()) {
            //校验通过,发送ajax请求，提交表单的数据
            $.ajax({
                type:"post",
                url:"../user/toRegister.do",
                data:$("#registerForm").serialize(),
                success:function (data) {
                    if(data.flag){
                        //注册成功，跳转成功页面
                        alert(data.tipMsg);
                        location.href="../user/index.do";
                    }else {
                        //注册失败,给errorMsg添加提示信息
                        alert(data.tipMsg);
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
    $("#email").blur(checkEmail);
    $("#name").blur(checkName);
    $("#school").blur(checkSchool);
    $("#number").blur(checkNumber);
    $("#grade").blur(checkGrade);
    $("#checkCode").blur(checkCode);
});


$(function () {
    //当表单提交时，调用所有的校验方法
    $("#entryForm").submit(function () {
        //1.发送数据到服务器
        if (checkSchool() && checkName() &&checkAge() &&checkEmail() &&checkMajor()) {
            //校验通过,发送ajax请求，提交表单的数据
            $.ajax({
                type:"post",
                url:"../entryForm/toEntry.do",
                data:$("#entryForm").serialize(),
                dataType:"json",
            })
            alert("报名成功");
            location.href="../user/home.do";
        }
        return false;
    });

    //当某一个组件失去焦点是，调用对应的校验方法
    $("#email").blur(checkEmail);
    $("#name").blur(checkName);
    $("#school").blur(checkSchool);
    $("#age").blur(checkAge);
    $("#major").blur(checkMajor);

});

$(function () {
    //当表单提交时，调用所有的校验方法
    $("#updateEntryForm").submit(function () {
        //1.发送数据到服务器
        if (checkSchool() && checkName() &&checkAge() &&checkEmail() &&checkMajor()) {
            //校验通过,发送ajax请求，提交表单的数据
            $.ajax({
                type:"post",
                url:"../entryForm/updateEntry.do",
                data:$("#updateEntryForm").serialize(),
                dataType:"json",
            })
            alert("修改成功");
            location.href="../user/home.do";
        }
        return false;
    });

    //当某一个组件失去焦点是，调用对应的校验方法
    $("#email").blur(checkEmail);
    $("#name").blur(checkName);
    $("#school").blur(checkSchool);
    $("#age").blur(checkAge);
    $("#major").blur(checkMajor);

});

$(function () {
    $("#updatePasswordForm").submit(function () {
        //1.发送数据到服务器
        if(checkOriginalPassword() && checkNewPassword() && checkConfirmationPassword()){
            $.ajax({
                type:"get",
                url:"../user/toUpdatePassword.do",
                data:$("#updatePasswordForm").serialize(),
                success:function (data) {
                    if(data.flag){
                        alert("修改成功，请重新登录");
                        location.href="../user/index.do";
                    }else {
                        alert(data.tipMsg);
                        location.href="../user/updatePassword.do";
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.readyState);
                    alert(textStatus);
                    alert(errorThrown)
                },
                dataType:"json"
            })
        }
        return false;
    });
    //2.不让页面跳转
    $("#originalPassword").blur(checkOriginalPassword);
    $("#newPassword").blur(checkNewPassword);
    $("#confirmationPassword").blur(checkConfirmationPassword);

});

$(function () {
    $("#updateForm").submit(function () {
        //1.发送数据到服务器
        if(checkEmail()&& checkIdentityCard()){
            $.ajax({
                type:"POST",
                url:"../studentInfo/toUpdate.do",
                data:$("#updateForm").serialize(),
                success:function (data) {
                    alert("修改成功");
                    location.href="../user/home.do";
                },
            })
        }
        return false;
    })
    //2.不让页面跳转

    $("#email").blur(checkEmail);
    $("#identityCard").blur(checkIdentityCard);


});
$(function () {
    $("#findPasswordForm").submit(function () {
        //1.发送数据到服务器
        if(checkNewPassword() && checkConfirmationPassword()){
            $.ajax({
                type:"get",
                url:"../user/toFindPassword.do",
                data:$("#findPasswordForm").serialize(),
                success:function (data) {
                    if(data.flag){
                        alert("修改成功，请重新登录");
                        location.href="../user/index.do";
                    }else {
                        alert(data.tipMsg);
                        location.href="../user/index.do";
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.readyState);
                    alert(textStatus);
                    alert(errorThrown)
                },
                dataType:"json"
            })
        }
        return false;
    });
    //2.不让页面跳转
    $("#newPassword").blur(checkNewPassword);
    $("#confirmationPassword").blur(checkConfirmationPassword);

});

$(function () {
    $("#findEmailForm").submit(function () {
        //1.发送数据到服务器
        if(checkEmail()){
            $.ajax({
                type:"get",
                url:"../user/sendFindPasswordEmail.do",
                data:$("#findEmailForm").serialize(),
                success:function (data) {
                    if(data.flag){
                        alert(data.tipMsg);
                        location.href="../user/index.do";
                    }else {
                        alert(data.tipMsg);
                        location.href="../user/find.do";
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.readyState);
                    alert(textStatus);
                    alert(errorThrown)
                },
                dataType:"json"
            })
        }
        return false;
    });
    //2.不让页面跳转
    $("#email").blur(checkEmail);
});