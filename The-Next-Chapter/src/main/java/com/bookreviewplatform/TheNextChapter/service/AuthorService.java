package com.bookreviewplatform.TheNextChapter.service;

import com.bookreviewplatform.TheNextChapter.Data.entity.AuthorEntity;
import com.bookreviewplatform.TheNextChapter.Data.repository.AuthorRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorEntity> getAllAuthors() {
        return (List<AuthorEntity>) authorRepository.findAll();
    }
}
