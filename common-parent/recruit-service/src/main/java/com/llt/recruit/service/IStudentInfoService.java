package com.llt.recruit.service;

import com.llt.recruit.model.StudentInfo;
import com.llt.recruit.model.User;

public interface IStudentInfoService {

    void updateStatus(Long userId);

    StudentInfo findByUserId(Long userId);

    String vailActive(User user);

    boolean vailEmail(String email);

    boolean toActive(String uuid);
    
    void toUpdate(StudentInfo studentInfo);

    void deleteByUserId(Long userId);

    StudentInfo findByCode(String code);

    StudentInfo findByEmail(String email);
}
