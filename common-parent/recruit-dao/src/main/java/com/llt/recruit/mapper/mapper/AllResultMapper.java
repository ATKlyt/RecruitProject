package com.llt.recruit.mapper.mapper;

import com.llt.recruit.model.AllResult;
import com.llt.recruit.model.AllResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AllResultMapper {
    long countByExample(AllResultExample example);

    int deleteByExample(AllResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AllResult record);

    int insertSelective(AllResult record);

    List<AllResult> selectByExample(AllResultExample example);

    AllResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AllResult record, @Param("example") AllResultExample example);

    int updateByExample(@Param("record") AllResult record, @Param("example") AllResultExample example);

    int updateByPrimaryKeySelective(AllResult record);

    int updateByPrimaryKey(AllResult record);

    AllResult findByUserId(Long userId);

    void updateBlankResult(@Param("userId") Long userId, @Param("blankResult") Integer blankResult);

    void updateWriteResult(@Param("userId") Long userId, @Param("writeResult") Integer writeResult);

    void updateInterviewResult(@Param("userId")Long userId, @Param("interviewResult") Integer interviewResult);
}