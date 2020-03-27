package com.huseyink.issuemanagement.service;

import com.huseyink.issuemanagement.dto.IssueDto;
import com.huseyink.issuemanagement.entity.Issue;
import com.huseyink.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

     IssueDto save(IssueDto issue);

     IssueDto getById(Long id);

     TPage<IssueDto> getAllPageable(Pageable pageable);

     Boolean delete(IssueDto issue);




}
