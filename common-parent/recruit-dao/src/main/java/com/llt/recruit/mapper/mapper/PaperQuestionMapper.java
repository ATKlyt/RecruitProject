package com.llt.recruit.mapper.mapper;

import com.llt.recruit.model.PaperQuestion;
import com.llt.recruit.model.PaperQuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperQuestionMapper {
    long countByExample(PaperQuestionExample example);

    int deleteByExample(PaperQuestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaperQuestion record);

    int insertSelective(PaperQuestion record);

    List<PaperQuestion> selectByExample(PaperQuestionExample example);

    PaperQuestion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaperQuestion record, @Param("example") PaperQuestionExample example);

    int updateByExample(@Param("record") PaperQuestion record, @Param("example") PaperQuestionExample example);

    int updateByPrimaryKeySelective(PaperQuestion record);

    int updateByPrimaryKey(PaperQuestion record);

    void deleteSubject(@Param("testPaperId") Long testPaperId, @Param("questionId") Long questionId);

    void deleteRelationQuestion(Long testPaperId);


    void deleteRelationByQuestionId(Long questionId);
}