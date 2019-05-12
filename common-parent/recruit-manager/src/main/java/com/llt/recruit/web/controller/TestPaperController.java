package com.llt.recruit.web.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llt.recruit.model.PaperQuestion;
import com.llt.recruit.model.Subject;
import com.llt.recruit.model.TestPaper;
import com.llt.recruit.service.IQuestionService;
import com.llt.recruit.service.ITestPaperService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("testPaper")
public class TestPaperController {

    @Autowired
    private ITestPaperService testPaperService;
    @Autowired
    private IQuestionService questionService;

    /**
     * 试卷列表
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("testPaperList")
    public String testPaperList(@RequestParam(required=true,defaultValue="1")Integer page , Model model ,HttpServletRequest request){
        Map<String, String[]> condition = request.getParameterMap();
        PageHelper.startPage(page , 5);
        List<TestPaper> testPaperList = testPaperService.findALL(condition);
        PageInfo<TestPaper> p = new PageInfo<TestPaper>(testPaperList);
        model.addAttribute("page" ,p);
        model.addAttribute("testPaperList" , testPaperList);
        model.addAttribute("condition" ,condition);
        return "testPaperList";
    }

    /**
     * 删除试卷
     * @param testPaperId
     * @return
     */
    @RequestMapping("deleteTestPaper")
    public String deleteTestPaper(Long testPaperId){
        //先删除试卷关联题目
        testPaperService.deleteRelationQuestion(testPaperId);
        //再删除试卷
        testPaperService.deleteTestPaper(testPaperId);
        return "forward:testPaperList.do";
    }

    /**
     * 查看试卷
     * @param testPaperId
     * @param model
     * @return
     */
    @RequestMapping("seeTestPaper")
    public String seeTestPaper(Long testPaperId , Model model) {
        TestPaper testPaper = testPaperService.findTestPaperById(testPaperId);
        List<Subject> subjects = testPaperService.findTestPaperSubjectById(testPaperId);
        model.addAttribute("subjects",subjects);
        model.addAttribute("testPaper",testPaper);
        return "seeTestPaper";
    }

    /**
     *  删除试卷上的题目
     * @param request
     * @return
     */
    @RequestMapping("deleteSubject")
    public String deleteSubject(HttpServletRequest request){
        Long testPaperId = Long.parseLong(request.getParameter("testPaperId"));
        Long questionId = Long.parseLong(request.getParameter("questionId"));
        testPaperService.deleteSubject(testPaperId , questionId);
        request.setAttribute("testPaperId", testPaperId);
        return "forward:seeTestPaper.do";
    }

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("newTestPaper")
    public String newTestPaper(){
        return "newTestPaper";
    }

    /**
     * 添加试卷，提取试卷信息
     * @param paperName
     * @param paperScore
     * @param session
     * @return
     */
    @RequestMapping("addTestPaper")
    public String addTestPaper(String paperName , Integer paperScore, HttpSession session ,Model model){
        session.setAttribute("paperName",paperName);
        session.setAttribute("paperScore",paperScore);
        //获取题目
        List<Subject> subjects = questionService.findAllQuestion();
        session.setAttribute("subjects" , subjects);

        return "addSubject";
    }

    /**
     * 新增试卷所属题目
     * @param request
     * @return
     */
    @RequestMapping("addSubject")
    public String addSubject(HttpServletRequest request){
        String paperName = (String) request.getSession().getAttribute("paperName");
        Integer paperScore = (Integer) request.getSession().getAttribute("paperScore");
        //存取试卷
        TestPaper testPaper = new TestPaper();
        testPaper.setPaperName(paperName);
        testPaper.setPaperScore(paperScore);
        testPaperService.addTestPaper(testPaper);
        //取出所存试卷Id
        TestPaper newTestPaper = testPaperService.findByPaperName(paperName);
        Long testPaperId = newTestPaper.getId();

        Map<String, String[]> questionIds = request.getParameterMap();
        for (Iterator iter = questionIds.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry element = (Map.Entry) iter.next();
            //key值
            Object key = element.getKey();
            //value,数组形式
            String[] value = (String[]) element.getValue();

            Long questionId  = Long.parseLong(StringUtils.join(value));
            PaperQuestion paperQuestion = new PaperQuestion();
            paperQuestion.setQuestionId(questionId);
            paperQuestion.setTestPaperId(testPaperId);
            testPaperService.relation(paperQuestion);
        }
        //进行迭代，取出所有题目Id，进行关联
        return "forward:testPaperList.do";
    }



}
