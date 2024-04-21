package com.bookreviewplatform.TheNextChapter.Data.dao;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.UserEntity;
import com.bookreviewplatform.TheNextChapter.Data.repository.BookRepository;
import com.bookreviewplatform.TheNextChapter.Data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserDAO {
    private final UserRepository repository;
    public void saveUser (UserEntity userEntity){
        repository.save(userEntity);



    };

    public List<UserEntity> findAllUsers(){
        return (List<UserEntity>) repository.findAll();

    }
}
