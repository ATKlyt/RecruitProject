package com.llt.recruit.service;

import com.llt.recruit.model.PaperQuestion;
import com.llt.recruit.model.Subject;
import com.llt.recruit.model.TestPaper;

import java.util.List;
import java.util.Map;

public interface ITestPaperService {
    List<TestPaper> findALL(Map<String, String[]> condition);

    void deleteTestPaper(Long testPaperId);

    List<Subject> findTestPaperSubjectById(Long testPaperId);

    TestPaper findTestPaperById(Long testPaperId);

    void deleteSubject(Long testPaperId, Long questionId);

    void deleteRelationQuestion(Long testPaperId);

    void addTestPaper(TestPaper testPaper);

    TestPaper findByPaperName(String paperName);


    void relation(PaperQuestion paperQuestion);

    TestPaper findRand();
}
