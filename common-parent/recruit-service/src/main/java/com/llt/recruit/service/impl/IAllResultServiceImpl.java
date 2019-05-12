package com.llt.recruit.service.impl;

import com.llt.recruit.mapper.mapper.AllResultMapper;
import com.llt.recruit.model.AllResult;
import com.llt.recruit.service.IAllResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IAllResultServiceImpl implements IAllResultService {

    @Autowired
    private AllResultMapper allResultMapper;

    /**
     * 储存选择题分数
     * @param allResult
     */
    @Override
    public void saveChoiceResult(AllResult allResult) {
        allResultMapper.insertSelective(allResult);
    }

    @Override
    public AllResult findByUserId(Long userId) {
        return allResultMapper.findByUserId(userId);
    }

    @Override
    public void updateBlankResult(Long userId, Integer blankResult) {
        allResultMapper.updateBlankResult(userId , blankResult);
    }

    @Override
    public void updateWriteResult(Long userId, Integer writeResult) {
        allResultMapper.updateWriteResult(userId , writeResult);
    }

    @Override
    public void updateInterviewResult(Long userId, Integer interviewResult) {
        allResultMapper.updateInterviewResult(userId , interviewResult);
    }


}
