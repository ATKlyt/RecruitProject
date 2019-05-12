package com.llt.recruit.service;


import com.llt.recruit.model.BlankAnswer;

import java.util.List;

public interface IBlankAnswerService {


    void saveBlankAnswer(BlankAnswer blankAnswer);

    List<BlankAnswer> findBlankAnswerList();

    BlankAnswer examination(Long id);

    void updateBlankStatus(Long userId, Long questionId);

    List<BlankAnswer> findByUserId(Long userId);
}
