package com.bookreviewplatform.TheNextChapter.Data.dao;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.GenreEntity;
import com.bookreviewplatform.TheNextChapter.Data.repository.BookRepository;
import com.bookreviewplatform.TheNextChapter.Data.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GenreDAO {
    private final GenreRepository repository;
    public void saveGenre (GenreEntity genreEntity){
        repository.save(genreEntity);



    };

    public List<GenreEntity> findAllGenre(){
        return (List<GenreEntity>) repository.findAll();

    }
}
