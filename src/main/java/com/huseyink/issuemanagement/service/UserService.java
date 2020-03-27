package com.huseyink.issuemanagement.service;

import com.huseyink.issuemanagement.entity.IssueHistory;
import com.huseyink.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User User);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUsername(String username);

}
