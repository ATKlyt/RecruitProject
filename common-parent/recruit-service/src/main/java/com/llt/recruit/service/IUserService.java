package com.llt.recruit.service;

import com.llt.recruit.model.StudentInfo;
import com.llt.recruit.model.User;
import com.llt.recruit.model.Examinee;

import java.util.List;
import java.util.Map;


public interface IUserService {

    User login(User user);

    boolean toRegister(User user, StudentInfo studentInfo);

    boolean toUpdatePassword(String originalPassword , String newPassword , Long id);

    void updateNickname(Long userId , String nickname);

    void updateAvatar(User user);

    User findByUserId(Long id);

    List<Examinee> findAllExaminee(Map<String, String[]> condition);

    List<User> findAllAdmin(Map<String, String[]> condition);

    List<Examinee> findAllCommonUser(Map<String, String[]> condition);

    void delete(Long userId);

    void addAdmin(User user);

    User checkAdminUsername(String username);

    void findPassword(Long userId, String newPassword);

    void updateAdmin(User user);
}
