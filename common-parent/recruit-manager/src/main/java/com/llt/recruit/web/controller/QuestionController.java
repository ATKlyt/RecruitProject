package com.llt.recruit.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llt.recruit.model.Answer;
import com.llt.recruit.model.Question;
import com.llt.recruit.model.Subject;
import com.llt.recruit.model.User;
import com.llt.recruit.service.IQuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;


    /**
     * 选择题出题界面
     * @return
     */
    @RequestMapping("toAddChoiceQuestion")
    public String toAddChoiceQuestion(){
        return "addChoiceQuestion";
    }

    /**
     * 填空题出题界面
     * @return
     */
    @RequestMapping("toAddBlankQuestion")
    public String toAddBlankQuestion(){
        return "addBlankQuestion";
    }

    /**
     * 添加选择题
     * @return
     */
    @RequestMapping("addChoiceQuestion")
    public String addChoiceQuestion(HttpServletRequest request){
        String questionName = request.getParameter("newQuestionName");
        String optionA = request.getParameter("optionA");
        String optionAType = request.getParameter("optionAType");
        String optionB = request.getParameter("optionB");
        String optionBType = request.getParameter("optionBType");
        String optionC = request.getParameter("optionC");
        String optionCType = request.getParameter("optionCType");
        String optionD = request.getParameter("optionD");
        String optionDType = request.getParameter("optionDType");
        //选插入题目信息
        Question question = new Question();
        question.setQuestionName(questionName);
        question.setType("1");
        questionService.addChoiceQuestion(question);
        //获取所插入题目的Id
        Long questionId = questionService.findQuestionByQuestionName(questionName);

        Answer answerA = new Answer(questionId , optionA ,optionAType);
        Answer answerB = new Answer(questionId , optionB ,optionBType);
        Answer answerC = new Answer(questionId , optionC ,optionCType);
        Answer answerD = new Answer(questionId , optionD ,optionDType);
        questionService.addAnswer(answerA);
        questionService.addAnswer(answerB);
        questionService.addAnswer(answerC);
        questionService.addAnswer(answerD);
        return "forward:findAllQuestion.do";
    }

    /**
     * 添加填空题
     * @return
     */
    @RequestMapping("addBlankQuestion")
    public String addBlankQuestion(HttpServletRequest request){
        String questionName = request.getParameter("newQuestionName");
        Question question = new Question();
        question.setQuestionName(questionName);
        question.setType("0");
        questionService.addChoiceQuestion(question);
        return "forward:findAllQuestion.do";
    }


    /**
     * 通过题目Id找到所有答案
     * @param questionId
     * @param model
     * @return
     */
    @RequestMapping("findQuestionByQuestionId")
    public String findQuestionByQuestionId(Long questionId , Model model){
        Question question = questionService.findQuestionByQuestionId(questionId);
        List<Answer> answers = questionService.findAnswerByQuestionId(questionId);
        model.addAttribute("answers", answers);
        model.addAttribute("question" , question);
        return "updateQuestion";
    }


    /**
     * 找到所有题目
     * @param model
     * @return
     */
    @RequestMapping("findAllQuestion")
    public String findAllQuestion(Model model,HttpServletRequest request){
        Map<String, String[]> condition = request.getParameterMap();
        List<Subject> subjectList = questionService.findAllQuestionByCondition(condition);
        model.addAttribute("subjectList" , subjectList);
        model.addAttribute("condition" ,condition);
        return "allQuestion";
    }

    /**
     * 删除题目
     * @param questionId
     * @return
     */
    @RequestMapping("delete")
    public String delete(Long questionId){
        questionService.delete(questionId);
        return "forward:findAllQuestion.do";
    }

    /**
     * 修改题目
     * @param request
     * @return
     */
    @RequestMapping("updateQuestion")
    public String updateQuestion(HttpServletRequest request){
        Long questionId = Long.parseLong(request.getParameter("questionId"));
        String questionType = request.getParameter("questionType");
        String questionName = request.getParameter("newQuestionName");
        if(questionType.equals("1")){
            String optionA = request.getParameter("option1");
            String optionAType = request.getParameter("option1Type");
            String optionB = request.getParameter("option2");
            String optionBType = request.getParameter("option2Type");
            String optionC = request.getParameter("option3");
            String optionCType = request.getParameter("option3Type");
            String optionD = request.getParameter("option4");
            String optionDType = request.getParameter("option4Type");

            Answer answerA = new Answer(questionId , optionA ,optionAType);
            Answer answerB = new Answer(questionId , optionB ,optionBType);
            Answer answerC = new Answer(questionId , optionC ,optionCType);
            Answer answerD = new Answer(questionId , optionD ,optionDType);
            questionService.updateQuestion(questionId , questionName ,answerA , answerB ,answerC ,answerD);
        }else{
            questionService.updateQuestion(questionId , questionName ,null,null,null,null);
        }

        return "forward:findAllQuestion.do";
    }


}
