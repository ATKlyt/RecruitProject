package com.llt.recruit.service;

import com.llt.recruit.model.EntryForm;
import com.llt.recruit.model.Time;

import java.util.List;

public interface ITimeService {

    boolean toChooseTime(EntryForm entryForm , Long dateId);

    List<Time> getTypeTime(String type);

    void toSetTime(Time time);
    void updateAmount(Long id);


    Time findByDateId(Long dateId);

    void deleteTime(Long id);
}
