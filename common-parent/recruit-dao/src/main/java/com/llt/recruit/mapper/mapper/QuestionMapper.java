package com.llt.recruit.mapper.mapper;

import com.llt.recruit.model.Question;
import com.llt.recruit.model.QuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface QuestionMapper {
    long countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> findQuestion(Long testPaperId);

    List<Question> findAllQuestionByCondition(@Param("params")Map<String, String[]> condition);

    List<Question> findAllQuestion();

    void updateQuestionName(@Param("questionId") Long questionId, @Param("questionName") String questionName);

    Question findQuestionByQuestionName(String questionName);
}