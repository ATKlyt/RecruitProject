package com.llt.recruit.service.impl;


import com.llt.recruit.mapper.mapper.*;
import com.llt.recruit.model.*;
import com.llt.recruit.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class IExamServiceImpl implements IExamService {

    @Autowired
    private TestPaperMapper testPaperMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private TimeMapper timeMapper;


    @Override
    public Exam getExam(EntryForm entryForm) {
        Exam exam = new Exam();

        //找到试卷
        TestPaper testPaper = testPaperMapper.selectByPrimaryKey(entryForm.getTestPaperId());
        //找到试卷所属题目
        List<Question> questions = questionMapper.findQuestion(entryForm.getTestPaperId());
        //将每一道题目信息封装在subject对象里（包括题目名字，题目选项，题目正确答案），再装载集合
        List<Subject> subjects = new ArrayList<Subject>();

        Subject subject;
        for (Question question:questions ) {
            //通过题目id找到题目所属选项及正确答案
            List<String> allOptions = answerMapper.findAllOption(question.getId());
            List<String> rightOptions = answerMapper.findAllRightOption(question.getId());
            //将选项打乱顺序
            Collections.shuffle(allOptions);
            //封装subject
            subject = new Subject();
            subject.setQuestionId(question.getId());
            subject.setOptions(allOptions);
            subject.setRightOptions(rightOptions);
            subject.setQuestionName(question.getQuestionName());
            subject.setType(question.getType());
            subjects.add(subject);
        }

        //找到时间
        Time time = timeMapper.findExamTimeOrQueryAmount(entryForm.getDateId());

        exam.setBeginTime(time.getBeginTime());
        exam.setEndTime(time.getEndTime());
        exam.setSubjects(subjects);
        exam.setPaperName(testPaper.getPaperName());
        exam.setPaperCore(testPaper.getPaperScore());

        System.out.println(exam);

        return exam;
    }




}
