package com.llt.recruit.util;


import com.llt.recruit.model.ResultInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ValidateUtil {

    public static Boolean ValidateCode(HttpServletRequest request ){
        String code = request.getParameter("code");
        //从sesion中获取验证码
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");//为了保证验证码只能使用一次

        System.out.println(code+"              "+checkCode);
        //比较
        if(checkCode == null || !checkCode.equalsIgnoreCase(code)){
            return false;
        }
        return true;
    }
}
