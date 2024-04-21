package com.bookreviewplatform.TheNextChapter.service;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.UserEntity;
import com.bookreviewplatform.TheNextChapter.Data.repository.BookRepository;
import com.bookreviewplatform.TheNextChapter.Data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllBooks() {
        return (List<UserEntity>) userRepository.findAll();
    }
}
