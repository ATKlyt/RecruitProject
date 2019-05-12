package com.llt.recruit.service;

import com.llt.recruit.model.AllResult;

public interface IAllResultService {

    void saveChoiceResult(AllResult allResult);

    AllResult findByUserId(Long userId);

    void updateBlankResult(Long userId, Integer blankResult);


    void updateWriteResult(Long userId, Integer writeResult);

    void updateInterviewResult(Long userId, Integer interviewResult);
}
