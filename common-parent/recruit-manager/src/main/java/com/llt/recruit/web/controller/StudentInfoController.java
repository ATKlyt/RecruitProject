package com.llt.recruit.web.controller;

import com.llt.recruit.model.ResultInfo;
import com.llt.recruit.model.StudentInfo;
import com.llt.recruit.service.IStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("studentInfo")
public class StudentInfoController {

    @Autowired
    private IStudentInfoService studentInfoService;

    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor cust = new CustomDateEditor(sdf, true);
        bin.registerCustomEditor(Date.class, cust);
    }


    /**
     * 修改信息的跳转路径
     * @return
     */
    @RequestMapping("update")
    public String update(){
        return "update";
    }

    /**
     * 激活邮箱
     * @param request
     * @return
     */
    @RequestMapping("toActive")
    public String toActive(HttpServletRequest request , Model model){
        String uuid = request.getParameter("code");

        if(studentInfoService.toActive(uuid)){
            model.addAttribute("activeMsg" , new ResultInfo(true , "激活成功，请登录"));
        }else{
            model.addAttribute("activeMsg" , new ResultInfo(false , "激活失败"));
        }
        return "active";
    }

    /**
     * 用户更新个人信息
     * @param studentInfo
     */
    @RequestMapping("toUpdate")
    @ResponseBody
    public void toUpdate(StudentInfo studentInfo){
        studentInfoService.toUpdate(studentInfo);
    }

    /**
     * 查看个人面板
     * @return
     */
    @RequestMapping("findDetail")
    public String findDetail(HttpServletRequest request){
        Long userId = Long.parseLong(request.getParameter("id"));
        StudentInfo studentInfo = studentInfoService.findByUserId(userId);
        HttpSession session = request.getSession();
        session.setAttribute("studentInfo" ,studentInfo);
        return "userDetail";
    }

}
