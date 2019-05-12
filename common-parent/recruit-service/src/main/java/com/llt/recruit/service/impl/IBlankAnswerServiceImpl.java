package com.llt.recruit.service.impl;

import com.llt.recruit.mapper.mapper.BlankAnswerMapper;
import com.llt.recruit.model.BlankAnswer;
import com.llt.recruit.service.IBlankAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IBlankAnswerServiceImpl implements IBlankAnswerService {
    @Autowired
    private BlankAnswerMapper blankAnswerMapper;

    /**
     * 储存学生填空题答案信息
     * @param blankAnswer
     */
    @Override
    public void saveBlankAnswer(BlankAnswer blankAnswer) {
        blankAnswerMapper.insertSelective(blankAnswer);
    }


    @Override
    public List<BlankAnswer> findBlankAnswerList() {
        return blankAnswerMapper.findBlankAnswerList();
    }

    @Override
    public BlankAnswer examination(Long id) {
        return blankAnswerMapper.findBlankAnswer(id);
    }

    @Override
    public void updateBlankStatus(Long userId, Long questionId) {
        blankAnswerMapper.updateBlankStatus(userId,questionId);
    }

    @Override
    public List<BlankAnswer> findByUserId(Long userId) {
        return blankAnswerMapper.findByUserId(userId);
    }

}
