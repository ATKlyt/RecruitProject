package com.llt.recruit.mapper.mapper;

import com.llt.recruit.model.Answer;
import com.llt.recruit.model.AnswerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerMapper {
    long countByExample(AnswerExample example);

    int deleteByExample(AnswerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Answer record);

    int insertSelective(Answer record);

    List<Answer> selectByExample(AnswerExample example);

    Answer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);

    List<String> findAllOption(Long questionId);

    List<String> findAllRightOption(Long questionId);

    void deleteByQuestionId(Long questionId);

    List<Answer> findAnswerByQuestionId(Long questionId);
}