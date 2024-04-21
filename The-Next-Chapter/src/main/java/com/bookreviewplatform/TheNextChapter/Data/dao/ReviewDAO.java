package com.bookreviewplatform.TheNextChapter.Data.dao;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.ReviewEntity;
import com.bookreviewplatform.TheNextChapter.Data.repository.BookRepository;
import com.bookreviewplatform.TheNextChapter.Data.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ReviewDAO {
    private final ReviewRepository repository;
    public void saveReview (ReviewEntity reviewEntity){
        repository.save(reviewEntity);



    };

    public List<ReviewEntity> findAllReviews(){
        return (List<ReviewEntity>) repository.findAll();

    }
}
