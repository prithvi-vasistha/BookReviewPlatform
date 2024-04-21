package com.bookreviewplatform.TheNextChapter.Data.dao;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BookDAO {
    private final BookRepository repository;
    public void saveBook (BookEntity recipeEntity){
        repository.save(recipeEntity);



    };

    public List<BookEntity> findAllBooks(){
        return (List<BookEntity>) repository.findAll();

    }
}
