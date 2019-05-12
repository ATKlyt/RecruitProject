package com.llt.recruit.service;

import com.llt.recruit.model.Examinee;

import java.util.List;
import java.util.Map;

public interface IInterviewService {
    List<Examinee> findInterviewList(Map<String, String[]> condition);
}
