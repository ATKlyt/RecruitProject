package com.llt.recruit.service.impl;

import com.llt.recruit.mapper.mapper.EntryFormMapper;
import com.llt.recruit.mapper.mapper.StudentInfoMapper;
import com.llt.recruit.model.EntryForm;
import com.llt.recruit.service.IEntryFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IEntryFormServiceImpl implements IEntryFormService {


    @Autowired
    private EntryFormMapper entryFormMapper;

    @Autowired
    private StudentInfoMapper studentInfoMapper;


    @Override
    public EntryForm findByUserId(Long userId) {
        return entryFormMapper.findByUserId(userId);
    }

    /**
     * 用户报名
     * @param entryForm
     */
    @Override
    public void toEntry(EntryForm entryForm) {
        entryFormMapper.insertSelective(entryForm);
    }

    /**
     * 修改报名信息
     * @param entryForm
     */
    @Override
    public void updateEntry(EntryForm entryForm) {
        entryFormMapper.updateByPrimaryKeySelective(entryForm);
    }

    @Override
    public void deleteByUserId(Long userId) {
        entryFormMapper.deleteByUserId(userId);
    }
}
