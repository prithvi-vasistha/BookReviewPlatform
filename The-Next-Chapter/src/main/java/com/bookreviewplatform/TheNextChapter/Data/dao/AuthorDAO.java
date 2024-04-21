package com.bookreviewplatform.TheNextChapter.Data.dao;

import com.bookreviewplatform.TheNextChapter.Data.entity.AuthorEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.repository.AuthorRepository;
import com.bookreviewplatform.TheNextChapter.Data.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AuthorDAO {
    private final AuthorRepository repository;
    public void saveAuthor (AuthorEntity authorEntity){
        repository.save(authorEntity);



    };

    public List<AuthorEntity> findAllAuthors(){
        return (List<AuthorEntity>) repository.findAll();

    }
}
