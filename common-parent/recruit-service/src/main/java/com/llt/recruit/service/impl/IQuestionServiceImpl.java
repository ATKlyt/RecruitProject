package com.llt.recruit.service.impl;

import com.llt.recruit.mapper.mapper.AnswerMapper;
import com.llt.recruit.mapper.mapper.PaperQuestionMapper;
import com.llt.recruit.mapper.mapper.QuestionMapper;
import com.llt.recruit.model.Answer;
import com.llt.recruit.model.Question;
import com.llt.recruit.model.Subject;
import com.llt.recruit.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class IQuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private PaperQuestionMapper paperQuestionMapper;

    @Override
    public List<Subject> findAllQuestionByCondition(Map<String, String[]> condition) {
        List<Question> questions = questionMapper.findAllQuestionByCondition(condition);
        List<Subject> subjects = new ArrayList<Subject>();
        Subject subject;
        for (Question question:questions ) {
            //通过题目id找到题目所属选项及正确答案
            if(question.getType().equals("1")){
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
            }else{
                subject = new Subject();
                subject.setQuestionId(question.getId());
                subject.setQuestionName(question.getQuestionName());
                subject.setType(question.getType());
                subjects.add(subject);
            }

        }
        return subjects;
    }

    @Override
    public void delete(Long questionId) {
        //删除关系表
        paperQuestionMapper.deleteRelationByQuestionId(questionId);
        //删除题目所属答案
        answerMapper.deleteByQuestionId(questionId);
        questionMapper.deleteByPrimaryKey(questionId);
    }

    @Override
    public void updateQuestion(Long questionId, String questionName, Answer answerA, Answer answerB, Answer answerC, Answer answerD) {
        //先删除该题所有答案，在进行插入答案
        if(answerA!=null && answerB!=null && answerC!=null && answerD!=null){
            answerMapper.deleteByQuestionId(questionId);
            answerMapper.insertSelective(answerA);
            answerMapper.insertSelective(answerB);
            answerMapper.insertSelective(answerC);
            answerMapper.insertSelective(answerD);
        }
        questionMapper.updateQuestionName(questionId ,questionName);
    }

    @Override
    public Question findQuestionByQuestionId(Long questionId) {
        return questionMapper.selectByPrimaryKey(questionId);
    }

    @Override
    public List<Answer> findAnswerByQuestionId(Long questionId) {
        return answerMapper.findAnswerByQuestionId(questionId);
    }

    @Override
    public void addChoiceQuestion(Question question) {
        questionMapper.insertSelective(question);
    }

    @Override
    public Long findQuestionByQuestionName(String questionName) {
        return questionMapper.findQuestionByQuestionName(questionName).getId();
    }

    @Override
    public void addAnswer(Answer answer) {
        answerMapper.insertSelective(answer);
    }

    @Override
    public List<Subject> findAllQuestion() {
        List<Question> questions = questionMapper.findAllQuestion();
        List<Subject> subjects = new ArrayList<Subject>();
        Subject subject;
        for (Question question:questions ) {
            //通过题目id找到题目所属选项及正确答案
            if(question.getType().equals("1")){
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
            }else{
                subject = new Subject();
                subject.setQuestionId(question.getId());
                subject.setQuestionName(question.getQuestionName());
                subject.setType(question.getType());
                subjects.add(subject);
            }

        }
        return subjects;
    }


}
