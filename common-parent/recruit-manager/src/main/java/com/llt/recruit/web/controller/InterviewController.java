package com.llt.recruit.web.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llt.recruit.model.EntryForm;
import com.llt.recruit.model.Examinee;
import com.llt.recruit.model.StudentInfo;
import com.llt.recruit.model.User;
import com.llt.recruit.service.*;
import com.llt.recruit.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("interview")
public class InterviewController {


    @Autowired
    private IInterviewService interviewService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IStudentInfoService studentInfoService;
    @Autowired
    private IEntryFormService entryFormService;
    @Autowired
    private IAllResultService allResultService;

    /**
     * 获取通过面试的考生列表
     * @param page
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("findInterviewList")
    public String findInterviewList(@RequestParam(required=true,defaultValue="1")Integer page , Model model,HttpServletRequest request){
        Map<String, String[]> condition = request.getParameterMap();
        PageHelper.startPage(page, 5);
        List<Examinee> interviewList =  interviewService.findInterviewList(condition);
        PageInfo<Examinee> p = new PageInfo<Examinee>(interviewList);
        model.addAttribute("page", p);
        model.addAttribute("interviewList",interviewList);
        model.addAttribute("condition",condition);
        return "interviewList";
    }


    @RequestMapping("updateInterviewResult")
    public String updateInterviewResult(HttpServletRequest request , Model model){
        Long userId = Long.parseLong(request.getParameter("userId"));
        EntryForm entryForm = entryFormService.findByUserId(userId);
        StudentInfo studentInfo = studentInfoService.findByUserId(userId);
        User user = userService.findByUserId(userId);
        model.addAttribute("findUser" , user);
        model.addAttribute("findStudentInfo" , studentInfo);
        model.addAttribute("findEntryForm" , entryForm);
        model.addAttribute("userId" ,userId);
        return "interviewResult";
    }

    @RequestMapping("updateAndInform")
    public String updateAndInform(HttpServletRequest request){
        Integer interviewResult = Integer.valueOf(request.getParameter("interviewResult"));
        Long userId = Long.parseLong(request.getParameter("userId"));
        StudentInfo studentInfo = studentInfoService.findByUserId(userId);
        //更新面试成绩
        allResultService.updateInterviewResult(userId , interviewResult);
        //更新状态,面试完成状态为7
        studentInfoService.updateStatus(userId);
        //邮箱通知
        String content="您的面试成绩为"+interviewResult+"-------来自【灵魂IT公司】";
        MailUtil.sendMail(studentInfo.getEmail(),content,"成绩通知");
        return "forward:findInterviewList.do";
    }

    @RequestMapping("getInterview")
    public String getInterview(){
        return "getInterview";
    }

}
