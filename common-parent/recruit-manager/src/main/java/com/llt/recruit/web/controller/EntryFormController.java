package com.llt.recruit.web.controller;

import com.llt.recruit.model.EntryForm;
import com.llt.recruit.model.StudentInfo;
import com.llt.recruit.model.TestPaper;
import com.llt.recruit.service.IEntryFormService;
import com.llt.recruit.service.IStudentInfoService;
import com.llt.recruit.service.ITestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@RequestMapping("entryForm")
public class EntryFormController {

    @Autowired
    private IEntryFormService entryFormService;
    @Autowired
    private IStudentInfoService studentInfoService;
    @Autowired
    private ITestPaperService testPaperService;

    @RequestMapping("entryForm")
    public String entryForm(){
        return "entryForm";
    }

    @RequestMapping("updateEntryForm")
    public String updateEntryForm(){
        return "updateEntryForm";
    }

    /**
     * 用户报名
     * @param entryForm
     * @param userId
     */
    @RequestMapping("toEntry")
    public void toEntry(HttpServletRequest request , EntryForm entryForm , Long userId){
        //设置学生试卷编号信息，写死

        TestPaper testPaper = testPaperService.findRand();
        entryForm.setTestPaperId(testPaper.getId());
        entryFormService.toEntry(entryForm);
        EntryForm findEntryForm = entryFormService.findByUserId(userId);
        HttpSession session = request.getSession();
        session.setAttribute("entryForm" , findEntryForm);
        studentInfoService.updateStatus(userId);
        StudentInfo studentInfo = studentInfoService.findByUserId(userId);
        session.setAttribute("studentInfo" , studentInfo);
    }

    /**
     * 更新报名信息，传进来的entryForm有主键
     * @param entryForm
     */
    @RequestMapping("updateEntry")
    public void updateEntry(HttpSession session , EntryForm entryForm){
        session.setAttribute("entryForm" , entryForm);
        entryFormService.updateEntry(entryForm);
    }
}
