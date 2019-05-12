package com.llt.recruit.mapper.mapper;

import com.llt.recruit.model.TestPaper;
import com.llt.recruit.model.TestPaperExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TestPaperMapper {
    long countByExample(TestPaperExample example);

    int deleteByExample(TestPaperExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    List<TestPaper> selectByExample(TestPaperExample example);

    TestPaper selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TestPaper record, @Param("example") TestPaperExample example);

    int updateByExample(@Param("record") TestPaper record, @Param("example") TestPaperExample example);

    int updateByPrimaryKeySelective(TestPaper record);

    int updateByPrimaryKey(TestPaper record);

    List<TestPaper> findAll(@Param("params") Map<String, String[]> condition);

    TestPaper findByPaperName(String paperName);

    TestPaper findRand();
}