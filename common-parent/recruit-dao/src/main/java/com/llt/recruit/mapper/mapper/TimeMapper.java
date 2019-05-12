package com.llt.recruit.mapper.mapper;

import com.llt.recruit.model.EntryForm;
import com.llt.recruit.model.Time;
import com.llt.recruit.model.TimeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TimeMapper {

    List<Time> getTypeTime(String type);

    void toChooseTime(EntryForm entryForm);

    Time findExamTimeOrQueryAmount(Long dateId);

    void updateAmount(Long id);


    long countByExample(TimeExample example);

    int deleteByExample(TimeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Time record);

    int insertSelective(Time record);

    List<Time> selectByExample(TimeExample example);

    Time selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Time record, @Param("example") TimeExample example);

    int updateByExample(@Param("record") Time record, @Param("example") TimeExample example);

    int updateByPrimaryKeySelective(Time record);

    int updateByPrimaryKey(Time record);
}