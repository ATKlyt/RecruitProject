package com.llt.recruit.service.impl;

import com.llt.recruit.mapper.mapper.AnswerMapper;
import com.llt.recruit.mapper.mapper.PaperQuestionMapper;
import com.llt.recruit.mapper.mapper.QuestionMapper;
import com.llt.recruit.mapper.mapper.TestPaperMapper;
import com.llt.recruit.model.PaperQuestion;
import com.llt.recruit.model.Question;
import com.llt.recruit.model.Subject;
import com.llt.recruit.model.TestPaper;
import com.llt.recruit.service.ITestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ITestPaperServiceImpl implements ITestPaperService {


    @Autowired
    private TestPaperMapper testPaperMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private PaperQuestionMapper paperQuestionMapper;

    @Override
    public List<TestPaper> findALL(Map<String, String[]> condition) {
        return testPaperMapper.findAll(condition);
    }

    @Override
    public void deleteTestPaper(Long testPaperId) {
        testPaperMapper.deleteByPrimaryKey(testPaperId);
    }

    @Override
    public List<Subject> findTestPaperSubjectById(Long testPaperId) {
        //找到试卷所属题目
        List<Question> questions = questionMapper.findQuestion(testPaperId);
        //将每一道题目信息封装在subject对象里（包括题目名字，题目选项，题目正确答案），再装载集合
        List<Subject> subjects = new ArrayList<Subject>();

        Subject subject;
        for (Question question:questions ) {
            //通过题目id找到题目所属选项及正确答案
            List<String> allOptions = answerMapper.findAllOption(question.getId());
            List<String> rightOptions = answerMapper.findAllRightOption(question.getId());
            //封装subject
            subject = new Subject();
            subject.setQuestionId(question.getId());
            subject.setOptions(allOptions);
            subject.setRightOptions(rightOptions);
            subject.setQuestionName(question.getQuestionName());
            subject.setType(question.getType());
            subjects.add(subject);
        }
        return subjects;
    }

    @Override
    public TestPaper findTestPaperById(Long testPaperId) {
        return testPaperMapper.selectByPrimaryKey(testPaperId);
    }

    @Override
    public void deleteSubject(Long testPaperId, Long questionId) {

        paperQuestionMapper.deleteSubject(testPaperId , questionId);
    }

    @Override
    public void deleteRelationQuestion(Long testPaperId) {
        paperQuestionMapper.deleteRelationQuestion(testPaperId);
    }

    @Override
    public void addTestPaper(TestPaper testPaper) {
        testPaperMapper.insertSelective(testPaper);
    }

    @Override
    public TestPaper findByPaperName(String paperName) {
        return testPaperMapper.findByPaperName(paperName);
    }

    @Override
    public void relation(PaperQuestion paperQuestion) {
        paperQuestionMapper.insertSelective(paperQuestion);
    }

    @Override
    public TestPaper findRand() {
        return testPaperMapper.findRand();
    }


}
