package com.llt.recruit.web.controller;

import com.llt.recruit.model.*;
import com.llt.recruit.service.*;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping("exam")
public class ExamController {


    @Autowired
    private IExamService examService;
    @Autowired
    private IEntryFormService entryFormService;
    @Autowired
    private IStudentInfoService studentInfoService;
    @Autowired
    private IBlankAnswerService blankAnswerService;
    @Autowired
    private IAllResultService allResultService;

    /**
     * 获取试卷
     * @param userId
     * @param session
     * @return
     */
    @RequestMapping("toExam")
    public String toExam(String userId , HttpSession session) {
        //获取试卷信息
        EntryForm entryForm = entryFormService.findByUserId(Long.parseLong(userId));
        Exam exam = examService.getExam(entryForm);
        session.setAttribute("exam", exam);
        return "exam";
    }

    /**
     * 获取考生答案并阅卷
     * @param request
     */
    @RequestMapping("checkAnswer")
    public String checkAnswer(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        HttpSession session = request.getSession();
        Exam exam = (Exam) session.getAttribute("exam");
        //答卷人
        Long userId = Long.parseLong(request.getParameter("userId"));
        //总分
        Integer choiceScore = 0;
        //题目数量
        int count = exam.getSubjects().size();
        //每一道题分数
        Integer avgScore = exam.getPaperCore()/count;

            //获取正确答案
            for (Subject subject : exam.getSubjects()) {
                //遍历每一道试题

                //该题是选择题
                if(subject.getType().equals("1")){
                    //迭代器迭代参数
                    for (Iterator iter = map.entrySet().iterator(); iter.hasNext(); ) {
                        Map.Entry element = (Map.Entry) iter.next();
                        //key值
                        Object key = element.getKey();
                        //value,数组形式
                        String[] value = (String[]) element.getValue();

                        //如果题目相同则比较两个数组是否相同
                        if(subject.getQuestionName().equals(key)){
                            //将list转换成数组
                            String[] arr = subject.getRightOptions().toArray(new String[]{});
                            //重排
                            Arrays.sort(value);
                            Arrays.sort(arr);
                            //答案相同就加分
                            if( Arrays.equals(value,arr)){
                                choiceScore = choiceScore + avgScore;
                            }
                        }
                    }
                }else{
                    //该题是填空题
                    for (Iterator iter = map.entrySet().iterator(); iter.hasNext(); ) {
                        Map.Entry element = (Map.Entry) iter.next();
                        //key值
                        Object key = element.getKey();
                        //value,数组形式
                        String[] value = (String[]) element.getValue();

                        //如果题目相同
                        if(subject.getQuestionName().equals(key)){
                            String blankValue = StringUtils.join(value);
                            //封装对象
                            BlankAnswer blankAnswer = new BlankAnswer();
                            blankAnswer.setBlankAnswer(blankValue);
                            blankAnswer.setUserId(userId);
                            blankAnswer.setQuestionId(subject.getQuestionId());
                            blankAnswer.setBlankScore(avgScore);
                            blankAnswer.setStatus("0");

                            blankAnswerService.saveBlankAnswer(blankAnswer);
                        }
                    }
                }
            }







//        //迭代器迭代参数
//        for (Iterator iter = map.entrySet().iterator(); iter.hasNext(); ) {
//            Map.Entry element = (Map.Entry) iter.next();
//            //key值
//            Object key = element.getKey();
//            //value,数组形式
//            String[] value = (String[]) element.getValue();
//
//
//            //获取正确答案
//            for (Subject subject : exam.getSubjects()) {
//                //如果题目相同则比较两个数组是否相同
//                if (key.equals(subject.getQuestionName())) {
//                    String[] arr = subject.getRightOptions().toArray(new String[]{});
//                    //重排答案
//                    Arrays.sort(value);
//                    Arrays.sort(arr);
//
//                    //答案相同就加分
//                    if( ! Arrays.equals(value,arr)){
//                        score = score + avgScore;
//                    }
//                }
//            }
        //分数
        session.setAttribute("choiceScore" , choiceScore);

        //封装笔试结果
        AllResult allResult = new AllResult();
        allResult.setUserId(userId);
        allResult.setChoiceResult(choiceScore);

        //存储分数，更改状态码
        allResultService.saveChoiceResult(allResult);
        studentInfoService.updateStatus(userId);

        session.setAttribute("allResult" , allResult);


    return "exam";

    }





}
