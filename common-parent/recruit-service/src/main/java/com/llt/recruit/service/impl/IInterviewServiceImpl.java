package com.llt.recruit.service.impl;

import com.llt.recruit.mapper.mapper.UserMapper;
import com.llt.recruit.model.Examinee;
import com.llt.recruit.service.IInterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
@Transactional
public class IInterviewServiceImpl implements IInterviewService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<Examinee> findInterviewList(Map<String, String[]> condition) {
        return userMapper.findInterviewList(condition);
    }
}
