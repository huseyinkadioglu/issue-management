package com.huseyink.issuemanagement.service.impl;

import com.huseyink.issuemanagement.entity.User;
import com.huseyink.issuemanagement.repository.UserRepository;
import com.huseyink.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {

        if(user.getEmail()==null)
        {
            throw new IllegalArgumentException("Email cannot be null!");
        }

        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
