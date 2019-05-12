package com.llt.recruit.service.impl;

import com.llt.recruit.mapper.mapper.EntryFormMapper;
import com.llt.recruit.mapper.mapper.TimeMapper;
import com.llt.recruit.model.EntryForm;
import com.llt.recruit.model.Time;
import com.llt.recruit.service.ITimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ITimeServiceImpl implements ITimeService {

    @Autowired
    private EntryFormMapper entryFormMapper;
    @Autowired
    private TimeMapper timeMapper;



    /**
     * 预约时间
     * @param entryForm
     * @return
     */
    @Override
    public boolean toChooseTime(EntryForm entryForm , Long dateId) {
        //判断该笔试时间段是否已经满人
        Time time = timeMapper.findExamTimeOrQueryAmount(dateId);

        entryForm.setDateId(dateId);
        System.out.println(time);
        if(time.getAmount() < time.getAmountLimit() ){
            timeMapper.toChooseTime(entryForm);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 查找面试的时间或笔试的时间
     * @return
     */
    @Override
    public List<Time> getTypeTime(String type) {
        List<Time> times = timeMapper.getTypeTime(type);
        return times;
    }

    /**
     * 更新选择的人数
     * @param id
     */
    @Override
    public void updateAmount(Long id) {
        timeMapper.updateAmount(id);
    }

    /**
     * 查找时间段
     * @param dateId
     * @return
     */
    @Override
    public Time findByDateId(Long dateId) {
        return timeMapper.selectByPrimaryKey(dateId);
    }

    @Override
    public void deleteTime(Long id) {
        timeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 管理员设置时间
     * @param time
     */
    @Override
    public void toSetTime(Time time) {
        timeMapper.insertSelective(time);
    }
}
