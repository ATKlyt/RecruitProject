package com.llt.recruit.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llt.recruit.model.AllResult;
import com.llt.recruit.model.BlankAnswer;
import com.llt.recruit.model.EntryForm;
import com.llt.recruit.model.TestPaper;
import com.llt.recruit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("blank")
public class BlankController {
    @Autowired
    private IBlankAnswerService blankAnswerService;
    @Autowired
    private IAllResultService allResultService;
    @Autowired
    private IEntryFormService entryFormService;
    @Autowired
    private ITestPaperService testPaperService;
    @Autowired
    private IStudentInfoService studentInfoService;



    /**
     * 查询所有考生填空题的答案且状态为0
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("findBlankAnswerList")
    public String findBlankAnswerList(@RequestParam(required=true,defaultValue="1")Integer page, Model model){
        PageHelper.startPage(page, 5);
        List<BlankAnswer> blankAnswerList = blankAnswerService.findBlankAnswerList();
        PageInfo<BlankAnswer> p = new PageInfo<BlankAnswer>(blankAnswerList);
        model.addAttribute("blankAnswerList",blankAnswerList);
        model.addAttribute("page" ,p);
        return "blankList";
    }

    /**
     * 找到特定的填空题
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("examination")
    public String examination(Long id , Model model){
        BlankAnswer blankAnswer = blankAnswerService.examination(id);
        model.addAttribute("blankAnswer",blankAnswer);
        return "examination";
    }

    /**
     * 为考生的填空题分数打分，每打一次就看看是否该考生所有填空都已经打分完毕
     * @param userId
     * @param questionId
     * @param request
     */
    @RequestMapping("scoring")
    public String scoring(Long userId , Long questionId , HttpServletRequest request){
        EntryForm entryForm = entryFormService.findByUserId(userId);
        TestPaper testPaper = testPaperService.findTestPaperById(entryForm.getTestPaperId());
        //修改答案状态为1，表示已经批改过
        blankAnswerService.updateBlankStatus(userId,questionId);
        //更新考生填空题分数
        Integer blankResult = Integer.valueOf(request.getParameter("blankResult"));
        allResultService.updateBlankResult(userId , blankResult);
        //检查该考试是否还有填空题题没有批改
        List<BlankAnswer> blankAnswers = blankAnswerService.findByUserId(userId);
        System.out.println(blankResult);
        System.out.println(blankAnswers.size());
        if(blankAnswers.size() == 0){
            //更新考生笔试总成绩
            System.out.println("更新考生笔试总成绩");
            AllResult allResult = allResultService.findByUserId(userId);
            Integer writeResult = allResult.getBlankResult()+allResult.getChoiceResult();
            System.out.println(writeResult+"====================================");
            allResultService.updateWriteResult(userId , writeResult);
            if(writeResult >= testPaper.getPaperScore()*0.6){
                studentInfoService.updateStatus(userId);
            }
        }
        return "forward:findBlankAnswerList.do";
    }
}
