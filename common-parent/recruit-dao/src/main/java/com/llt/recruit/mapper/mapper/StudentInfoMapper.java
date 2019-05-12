package com.llt.recruit.mapper.mapper;

import com.llt.recruit.model.StudentInfo;
import com.llt.recruit.model.StudentInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentInfoMapper {

    StudentInfo findByEmail(String email);

    int toActive(String uuid);


    StudentInfo findByUserId(Long userId);


    long countByExample(StudentInfoExample example);

    int deleteByExample(StudentInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    List<StudentInfo> selectByExample(StudentInfoExample example);

    StudentInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByExample(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);

    void updateStatus(Long userId);

    void deleteByUserId(Long userId);

    StudentInfo findByCode(String code);
}