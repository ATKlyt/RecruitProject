package com.llt.recruit.service;

import com.llt.recruit.model.Answer;
import com.llt.recruit.model.Question;
import com.llt.recruit.model.Subject;

import java.util.List;
import java.util.Map;

public interface IQuestionService {
    List<Subject> findAllQuestionByCondition(Map<String, String[]> condition);

    void delete(Long questionId);


    void updateQuestion(Long questionId, String questionName, Answer answerA, Answer answerB, Answer answerC, Answer answerD);

    Question findQuestionByQuestionId(Long questionId);

    List<Answer> findAnswerByQuestionId(Long questionId);

    void addChoiceQuestion(Question question);

    Long findQuestionByQuestionName(String questionName);

    void addAnswer(Answer answer);

    List<Subject> findAllQuestion();
}
