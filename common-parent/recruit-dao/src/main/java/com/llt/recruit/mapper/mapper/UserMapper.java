package com.llt.recruit.mapper.mapper;

import com.llt.recruit.model.User;
import com.llt.recruit.model.UserExample;
import com.llt.recruit.model.Examinee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    void updatePassword(@Param("password") String password, @Param("id") Long id);


    User login(@Param("username") String username , @Param("password") String password);

    User findByUsername(String username);


    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<Examinee> findAllExaminee(@Param("params") Map<String, String[]> condition);

    List<User> findAllAdmin(@Param("params") Map<String, String[]> condition);

    List<Examinee> findAllCommonUser(@Param("params") Map<String, String[]> condition);

    List<Examinee> findInterviewList(@Param("params") Map<String, String[]> condition);

    void findPassword(@Param("userId") Long userId,@Param("password") String newPassword);

    void updateNickname(@Param("userId")Long userId, @Param("nickname")String nickname);

    void insertUser(User user);
}