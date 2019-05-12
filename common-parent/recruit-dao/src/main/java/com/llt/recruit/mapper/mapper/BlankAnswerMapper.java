package com.llt.recruit.mapper.mapper;

import com.llt.recruit.model.BlankAnswer;
import com.llt.recruit.model.BlankAnswerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlankAnswerMapper {
    long countByExample(BlankAnswerExample example);

    int deleteByExample(BlankAnswerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlankAnswer record);

    int insertSelective(BlankAnswer record);

    List<BlankAnswer> selectByExample(BlankAnswerExample example);

    BlankAnswer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlankAnswer record, @Param("example") BlankAnswerExample example);

    int updateByExample(@Param("record") BlankAnswer record, @Param("example") BlankAnswerExample example);

    int updateByPrimaryKeySelective(BlankAnswer record);

    int updateByPrimaryKey(BlankAnswer record);

    List<BlankAnswer> findBlankAnswerList();

    BlankAnswer findBlankAnswer(Long id);


    void updateBlankStatus(@Param("userId") Long userId, @Param(("questionId")) Long questionId);

    List<BlankAnswer> findByUserId(Long userId);
}