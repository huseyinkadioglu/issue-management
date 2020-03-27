package com.huseyink.issuemanagement.service.impl;

import com.huseyink.issuemanagement.entity.IssueHistory;
import com.huseyink.issuemanagement.repository.IssueHistoryRepository;
import com.huseyink.issuemanagement.service.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {


    private IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if (issueHistory.getDate() == null) {
            throw new IllegalArgumentException("Issue date cannot be null!");
        }

        issueHistory = issueHistoryRepository.save(issueHistory);
        return issueHistory;

    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {

        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
