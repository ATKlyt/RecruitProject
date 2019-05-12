package com.llt.recruit.service;


import com.llt.recruit.model.EntryForm;

public interface IEntryFormService {

    EntryForm findByUserId(Long userId);

    void toEntry(EntryForm entryForm);

    void updateEntry(EntryForm entryForm);

    void deleteByUserId(Long userId);
}
