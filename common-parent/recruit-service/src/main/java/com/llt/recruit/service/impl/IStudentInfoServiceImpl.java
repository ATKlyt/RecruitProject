package com.llt.recruit.service.impl;

import com.llt.recruit.mapper.mapper.StudentInfoMapper;
import com.llt.recruit.model.StudentInfo;
import com.llt.recruit.model.User;
import com.llt.recruit.service.IStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IStudentInfoServiceImpl implements IStudentInfoService {

    @Autowired
    protected StudentInfoMapper studentInfoMapper;

    @Override
    public void updateStatus(Long userId) {
        studentInfoMapper.updateStatus(userId);
    }

    @Override
    public StudentInfo findByUserId(Long userId) {
        return studentInfoMapper.findByUserId(userId);
    }

    /**
     * 验证激活
     * @param user
     * @return
     */
    @Override
    public String vailActive(User user) {
        return studentInfoMapper.findByUserId(user.getId()).getStatus();
    }

    /**
     * 检验邮箱是否唯一
     * @param email
     * @return
     */
    @Override
    public boolean vailEmail(String email) {
        StudentInfo studentInfo = studentInfoMapper.findByEmail(email);
        if(studentInfo != null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 用户激活
     * @param uuid
     * @return
     */
    @Override
    public boolean toActive(String uuid) {
        int count = studentInfoMapper.toActive(uuid);
        if(count > 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 修改个人信息
     * @param studentInfo
     */
    @Override
    public void toUpdate(StudentInfo studentInfo) {
        studentInfoMapper.updateByPrimaryKeySelective(studentInfo);
    }

    @Override
    public void deleteByUserId(Long userId) {
        studentInfoMapper.deleteByUserId(userId);
    }

    @Override
    public StudentInfo findByCode(String code) {
        return studentInfoMapper.findByCode(code);
    }

    @Override
    public StudentInfo findByEmail(String email) {
        return studentInfoMapper.findByEmail(email);
    }
}
