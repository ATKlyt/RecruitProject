package com.llt.recruit.mapper.mapper;

import com.llt.recruit.model.EntryForm;
import com.llt.recruit.model.EntryFormExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EntryFormMapper {

    EntryForm findByUserId(Long id);




    long countByExample(EntryFormExample example);

    int deleteByExample(EntryFormExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EntryForm record);

    int insertSelective(EntryForm record);

    List<EntryForm> selectByExample(EntryFormExample example);

    EntryForm selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EntryForm record, @Param("example") EntryFormExample example);

    int updateByExample(@Param("record") EntryForm record, @Param("example") EntryFormExample example);

    int updateByPrimaryKeySelective(EntryForm record);

    int updateByPrimaryKey(EntryForm record);

    void deleteByUserId(Long userId);
}