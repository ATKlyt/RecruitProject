package com.llt.recruit.web.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llt.recruit.mapper.mapper.EntryFormMapper;
import com.llt.recruit.model.*;
import com.llt.recruit.service.IStudentInfoService;
import com.llt.recruit.service.ITimeService;
import com.llt.recruit.service.IUserService;
import com.llt.recruit.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("time")
public class TimeController {

    ResultInfo resultInfo = null;

    @Autowired
    public ITimeService timeService;
    @Autowired
    public EntryFormMapper entryFormMapper;
    @Autowired
    public IStudentInfoService studentInfoService;
    @Autowired
    public IUserService userService;

    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        CustomDateEditor cust = new CustomDateEditor(sdf, true);
        bin.registerCustomEditor(Date.class, cust);
    }

    /**
     * 添加时间段
     * @param model
     * @param type
     * @return
     */
    @RequestMapping("addTime")
    public String addTime(Model model , String type){
        model.addAttribute("type" , type);
        return "addTime";
    }

    /**
     * 选择时间段
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("toChooseTime")
    public String toChooseTime(HttpServletRequest request , HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        Long dateId = Long.parseLong(request.getParameter("id"));
        EntryForm entryForm = (EntryForm) session.getAttribute("entryForm");
        Long userId = entryForm.getUserId();
        Time time = timeService.findByDateId(dateId);
        if(timeService.toChooseTime(entryForm , dateId)){
            //预约成功
            //时间段人数加1
            timeService.updateAmount(dateId);

            resultInfo = new ResultInfo( true );
            entryForm.setDateId(dateId);
            session.setAttribute("entryForm" , entryForm);

            studentInfoService.updateStatus(userId);
            StudentInfo studentInfo = studentInfoService.findByUserId(userId);
            session.setAttribute("studentInfo" , studentInfo);
        }else{
            EntryForm newEntryForm = entryFormMapper.findByUserId(userId);
            session.setAttribute("entryForm" , newEntryForm);
            resultInfo = new ResultInfo(false , "该时段人数已满");
        }
        session.setAttribute("time" , time);
        JsonUtil.setJson(resultInfo , response);
        return "home";
    }

    /**
     * 获取所有类型时间
     * @param page
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("getTypeTime")
    public String getTypeTime(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request, Model model){
        String type = request.getParameter("type");
        PageHelper.startPage(page, 5);
        List<Time>  times = timeService.getTypeTime(type);
        PageInfo<Time> p = new PageInfo<Time>(times);
        model.addAttribute("page", p);
        model.addAttribute("times" , times);
        model.addAttribute("type" ,type);
        return "chooseTime";
    }

    /**
     * 管理员设置时间
     * @param time
     */
    @RequestMapping("toSetTime")
    public String toSetTime(Time time){

        time.setAmount(0);
        timeService.toSetTime(time);
        String type = time.getType();
        if(type.equals("0")){
            return "forward:getTypeTime.do?type=0";
        }else {
            return "forward:getTypeTime.do?type=1";
        }
    }

    /**
     * 删除时间
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("deleteTime")
    public String deleteTime(HttpServletRequest request , Long id){
        Time time = timeService.findByDateId(id);
        String type = time.getType();
        timeService.deleteTime(id);
        if(type.equals("0")){
            return "forward:getTypeTime.do?type=0";
        }else {
            return "forward:getTypeTime.do?type=1";
        }

    }


}
