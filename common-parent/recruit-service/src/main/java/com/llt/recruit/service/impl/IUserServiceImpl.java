package com.llt.recruit.service.impl;


import com.llt.recruit.mapper.mapper.EntryFormMapper;
import com.llt.recruit.mapper.mapper.StudentInfoMapper;
import com.llt.recruit.mapper.mapper.TimeMapper;
import com.llt.recruit.mapper.mapper.UserMapper;
import com.llt.recruit.model.*;
import com.llt.recruit.service.IUserService;
import com.llt.recruit.util.MD5Util;
import com.llt.recruit.util.MailUtil;
import com.llt.recruit.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentInfoMapper studentInfoMapper;


    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userMapper.login(user.getUsername() , user.getPassword());
    }

    /**
     * 用户注册
     * @param user
     * @param studentInfo
     * @return
     */
    @Override
    public boolean toRegister(User user, StudentInfo studentInfo) {
        //1.根据用户名查询用户对象
        User regUser = userMapper.findByUsername(user.getUsername());
        //判断regUser是否为null
        if(regUser != null){
            //用户名存在，注册失败
            return false;
        }

        //2.保存用户信息
        user.setNickname(user.getUsername());
        user.setRole("用户");
        user.setAvatar("http://localhost:8080/upload/2f34fde20a564e0c9785f80070e6b5c9.jpg");
        //2.1设置激活码，唯一字符串
        studentInfo.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        studentInfo.setStatus("0");

        userMapper.insertUser(user);
        studentInfo.setUserId(userMapper.findByUsername(user.getUsername()).getId());
        studentInfoMapper.insertSelective(studentInfo);
        //3.激活邮件发送，邮件正文？
        String content="<a href='http://localhost:8080/studentInfo/toActive.do?code="+studentInfo.getCode()+"'>点击激活【灵魂IT报名网】</a>";
        MailUtil.sendMail(studentInfo.getEmail(),content,"激活邮件");

        return true;
    }

    /**
     * 修改密码
     * @param originalPassword
     * @param newPassword
     * @param id
     * @return
     */
    @Override
    public boolean toUpdatePassword(String originalPassword , String newPassword , Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(user.getPassword().equals(MD5Util.MD5(originalPassword))){
            userMapper.updatePassword(newPassword , id);
            return true;
        }
        return false;
    }

    /**
     * 修改昵称
     * @param userId
     * @param nickname
     */
    @Override
    public void updateNickname(Long userId , String nickname) {
        userMapper.updateNickname(userId , nickname);
    }

    /**
     * 修改头像
     * @param user
     */
    @Override
    public void updateAvatar(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User findByUserId(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Examinee> findAllExaminee(Map<String, String[]> condition) {
        return userMapper.findAllExaminee(condition);
    }

    @Override
    public List<User> findAllAdmin(Map<String, String[]> condition) {
        return userMapper.findAllAdmin(condition);
    }

    @Override
    public List<Examinee> findAllCommonUser(Map<String, String[]> condition) {
        return userMapper.findAllCommonUser(condition);
    }

    @Override
    public void delete(Long userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void addAdmin(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User checkAdminUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void findPassword(Long userId, String newPassword) {
        userMapper.findPassword(userId , newPassword);
    }

    @Override
    public void updateAdmin(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }


}
