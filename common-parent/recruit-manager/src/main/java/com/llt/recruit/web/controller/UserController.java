package com.llt.recruit.web.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llt.recruit.model.*;
import com.llt.recruit.service.*;
import com.llt.recruit.util.MailUtil;
import com.llt.recruit.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IStudentInfoService studentInfoService;
    @Autowired
    private IAllResultService allResultService;
    @Autowired
    private IEntryFormService entryFormService;
    @Autowired
    private ITimeService timeService;

    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor cust = new CustomDateEditor(sdf, true);
        bin.registerCustomEditor(Date.class, cust);
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("register")
    public String register(){
        return "register";
    }

    @RequestMapping("manager")
    public String manager(HttpSession session){
        Long userId = ((User) session.getAttribute("user")).getId();
        User user = userService.findByUserId(userId);
        session.setAttribute("user" , user);
        return "manager";
    }

    /**
     * 到达用户主页，更新session中的user
     * @param session
     * @return
     */
    @RequestMapping("home")
    public String home(HttpSession session){
        Long userId = ((User) session.getAttribute("user")).getId();
        User user = userService.findByUserId(userId);
        session.setAttribute("user" , user);
        return "home";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("updatePassword")
    public String updatePassword(){
        return "updatePassword";
    }

    /**
     * 修改头像
     * @param user
     */
    @RequestMapping("updateAvatar")
    @ResponseBody
    public void updateAvatar(User user){
        userService.updateAvatar(user);
    }

    /**
     * 管理员登录进入到后台
     * 学生登录进入到个人主页
     * @return
     */
    @RequestMapping("login")
    public @ResponseBody ResultInfo login(HttpServletRequest request, User user){
        //校验验证码
        ResultInfo resultInfo = null;
        if( ! ValidateUtil.ValidateCode(request)){
            resultInfo = new ResultInfo(false , "验证码错误");
            return resultInfo;
        }

        User loginUser = userService.login(user);
        //判断账号密码是否有误
        if (loginUser != null){
            //账号密码正确
            HttpSession session = request.getSession();
            session.setAttribute("user" , loginUser);
            //区别用户管理员
            if(loginUser.getRole().equals("用户")){
                //验证是否激活
                if(studentInfoService.vailActive(loginUser).equals("0")){
                    resultInfo = new ResultInfo(false ,"您尚未激活，请登陆邮箱激活!");
                }else{
                    //已经激活，查询用户关联数据（报名表，信息，成绩）
                    EntryForm entryForm = entryFormService.findByUserId(loginUser.getId());
                    StudentInfo studentInfo = studentInfoService.findByUserId(loginUser.getId());
                    AllResult allResult = allResultService.findByUserId(loginUser.getId());
                    resultInfo = new ResultInfo(true ,loginUser.getRole());
                    session.setAttribute("entryForm" , entryForm);
                    session.setAttribute("studentInfo" ,studentInfo);
                    session.setAttribute("allResult" , allResult);
                    if(entryForm != null && entryForm.getDateId()!=null){
                        Time time = timeService.findByDateId(entryForm.getDateId());
                        session.setAttribute("time" , time);
                    }
                }
            }else{
                //管理员
                resultInfo = new ResultInfo(true , loginUser.getRole());
            }
        }else{
            //用户名或密码错误
            resultInfo = new ResultInfo(false ,"用户名或密码错误!");
        }
        return resultInfo;
    }

    /**
     * 修改昵称
     * @param userId
     * @param nickname
     */
    @ResponseBody
    @RequestMapping("updateNickname")
    public void updateNickname(Long userId , String nickname){
        userService.updateNickname(userId , nickname);
    }

    /**
     * 找到所有有报名的用户
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("examineeList")
    public String examineeList(@RequestParam(required=true,defaultValue="1")Integer page , Model model,HttpServletRequest request) {
        //PageHelper.startPage(page, pageSize);这段代码表示，程序开始分页了，page默认值是1，pageSize默认是10，意思是从第1页开始，每页显示10条记录。
        Map<String, String[]> condition = request.getParameterMap();
        PageHelper.startPage(page, 5);
        List<Examinee> examineeList = userService.findAllExaminee(condition);
        PageInfo<Examinee> p = new PageInfo<Examinee>(examineeList);
        model.addAttribute("page", p);
        model.addAttribute("examineeList",examineeList);
        model.addAttribute("condition",condition);
        return "examineeList";
    }

    /**
     * 找到所有管理员
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("adminList")
    public String adminList(@RequestParam(required=true,defaultValue="1")Integer page , Model model ,HttpServletRequest request) {
        //PageHelper.startPage(page, pageSize);这段代码表示，程序开始分页了，page默认值是1，pageSize默认是10，意思是从第1页开始，每页显示10条记录。
        Map<String, String[]> condition = request.getParameterMap();
        PageHelper.startPage(page, 5);
        List<User> adminList = userService.findAllAdmin(condition);
        PageInfo<User> p = new PageInfo<User>(adminList);
        model.addAttribute("page", p);
        model.addAttribute("adminList",adminList);
        model.addAttribute("condition",condition);
        return "adminList";
    }

    /**
     * 找到所有普通用户
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("commonUserList")
    public String commonUserList(@RequestParam(required=true,defaultValue="1")Integer page , Model model,HttpServletRequest request) {
        //PageHelper.startPage(page, pageSize);这段代码表示，程序开始分页了，page默认值是1，pageSize默认是10，意思是从第1页开始，每页显示10条记录。
        Map<String, String[]> condition = request.getParameterMap();
        PageHelper.startPage(page, 5);
        List<Examinee> commonUserList = userService.findAllCommonUser(condition);
        PageInfo<Examinee> p = new PageInfo<Examinee>(commonUserList);
        model.addAttribute("page", p);
        model.addAttribute("commonUserList",commonUserList);
        model.addAttribute("condition",condition);
        return "commonUserList";
    }

    /**
     * 修改密码
     * @param request
     */
    @RequestMapping("toUpdatePassword")
    public @ResponseBody ResultInfo toUpdatePassword(HttpServletRequest request ){
        String originalPassword = request.getParameter("originalPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmationPassword = request.getParameter("confirmationPassword");
        Long id = Long.parseLong(request.getParameter("id"));
        ResultInfo resultInfo = null;
        //两次密码是否相同
        if (newPassword.equals(confirmationPassword)){
            if (userService.toUpdatePassword(originalPassword , newPassword , id)){
                resultInfo = new ResultInfo(true);
                request.getSession().removeAttribute("user");
            }else{
                resultInfo = new ResultInfo(false , "原密码错误");
            }
        }else {
            //输出错误信息
            resultInfo = new ResultInfo(false , "两次密码不同");
        }
        return resultInfo;
    }

    /**
     * 用户注册
     * @param request
     * @param user
     * @param studentInfo
     * @return
     */
    @RequestMapping("toRegister")
    public @ResponseBody ResultInfo toRegister(HttpServletRequest request ,User user , StudentInfo studentInfo){
        ResultInfo resultInfo = null;
        //校验验证码
        if( ! ValidateUtil.ValidateCode(request)){
            resultInfo = new ResultInfo(false , "验证码错误");
            //将info对象序列化为json
            return resultInfo;
        }
        //检验邮箱是否已经被注册
        if(studentInfoService.vailEmail(studentInfo.getEmail())){
            //检验用户名是否唯一
            if(userService.toRegister(user , studentInfo)){
                resultInfo = new ResultInfo(true , "注册成功,请登陆邮箱激活账号");
            }else{
                resultInfo = new ResultInfo(false , "用户名已被注册");
            }
        }else{
            resultInfo = new ResultInfo(false , "邮箱已被注册");
        }
        return resultInfo;
    }

    /**
     * 删除用户
     * @param userId
     */
    @RequestMapping("delete")
    public String delete(Long userId){
        StudentInfo studentInfo = studentInfoService.findByUserId(userId);
        EntryForm entryForm = entryFormService.findByUserId(userId);
        if (studentInfo != null){
            studentInfoService.deleteByUserId(userId);
        }
        if (entryForm != null){
            entryFormService.deleteByUserId(userId);
        }
        userService.delete(userId);
        if(entryForm != null){
            return "forward:examineeList.do";
        }else if (studentInfo != null){
            return "forward:commonUserList.do";
        }else{
            return "forward:adminList.do";
        }

    }

    /**
     * 查找信息
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("adminFind")
    public String adminFind(Long userId , Model model){
        StudentInfo findStudentInfo = studentInfoService.findByUserId(userId);
        EntryForm findEntryForm = entryFormService.findByUserId(userId);
        User findUser = userService.findByUserId(userId);
        if (findStudentInfo != null){
            model.addAttribute("findStudentInfo" , findStudentInfo);
        }
        if (findEntryForm != null){
            model.addAttribute("findEntryForm" , findEntryForm);
        }
        model.addAttribute("findUser" ,findUser);
        return "adminFind";
    }

    /**
     * 添加管理员
     * @param request
     */
    @ResponseBody
    @RequestMapping("addAdmin")
    public void addAdmin(HttpServletRequest request){
        System.out.println("===============================================================");
        User user = new User();
        user.setUsername(request.getParameter("adminUsername"));
        user.setRole(request.getParameter("adminRole"));
        user.setPassword(request.getParameter("adminPassword"));
        user.setName(request.getParameter("adminName"));
        user.setNickname(user.getUsername());
        System.out.println(user);
        userService.addAdmin(user);
    }

    /**
     * 检验用户名是否重复
     * @param adminUsername
     */
    @RequestMapping("checkAdminUsername")
    public @ResponseBody ResultInfo checkAdminUsername(String adminUsername){
        if(userService.checkAdminUsername(adminUsername)!= null){
            return new ResultInfo(false);
        }else{
            return new ResultInfo(true);
        }
    }


    /**
     * 回显数据
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("updateAdmin")
    public String updateUser(Long userId ,Model model){
        User user = userService.findByUserId(userId);
        model.addAttribute("user",user);
        return "updateAdmin";
    }

    /**
     * 进行更新
     * @param request
     * @return
     */
    @RequestMapping("toUpdateAdmin")
    public String toUpdateUser(HttpServletRequest request){
        User user = new User();
        user.setId(Long.parseLong(request.getParameter("id")));
        user.setName(request.getParameter("updateName"));
        user.setNickname(request.getParameter("updateNickname"));
        user.setRole(request.getParameter("updateRole"));
        userService.updateAdmin(user);
        return "forward:adminList.do";


    }

    /**
     * 安全退出
     * @param session
     * @return
     */
    @RequestMapping("exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "index";
    }

    /**
     * 找回密码--发送邮件页面跳转
     * @return
     */
    @RequestMapping("find")
    public String find(){
        return "sendFindPasswordEmail";
    }

    /**
     * 找回密码--发送邮箱
     * @param request
     * @param email
     * @return
     */
    @RequestMapping("sendFindPasswordEmail")
    public  @ResponseBody ResultInfo sendFindPasswordEmail(HttpServletRequest request , String email){

        if( ! ValidateUtil.ValidateCode(request)){
            return new ResultInfo(false , "验证码错误");
        }
        StudentInfo studentInfo = studentInfoService.findByEmail(email);
        if(studentInfo != null){
            String content="<a href='http://localhost:8080/user/findPassword.do?code="+studentInfo.getCode()+"'>找回密码【灵魂IT报名网】</a>";
            MailUtil.sendMail(studentInfo.getEmail(),content,"找回密码");
            return new ResultInfo(true , "发送成功");
        }else{
            return new ResultInfo(false , "该邮箱不存在");
        }
    }

    /**
     * 找回密码
     * @param code
     * @param model
     * @return
     */
    @RequestMapping("findPassword")
    public String findPassword(String code ,Model model){
        StudentInfo studentInfo = studentInfoService.findByCode(code);
        if(studentInfo != null){
            model.addAttribute("userId" ,studentInfo.getUserId());
            return "findPassword";
        }else {
            return "404";
        }
    }

    /**
     * 通过id找到user并修改密码
     * @param request
     * @return
     */
    @RequestMapping("toFindPassword")
    public @ResponseBody ResultInfo toFindPassword(HttpServletRequest request){
        Long userId = Long.parseLong(request.getParameter("userId"));
        String newPassword = request.getParameter("newPassword");
        String confirmationPassword = request.getParameter("confirmationPassword");
        ResultInfo resultInfo = null;
        //两次密码是否相同
        if (newPassword.equals(confirmationPassword)){
            userService.findPassword(userId , newPassword);
            resultInfo = new ResultInfo(true);
        }else {
            //输出错误信息
            resultInfo = new ResultInfo(false , "两次密码不同");
        }
        return resultInfo;
    }


}

