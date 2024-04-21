package com.bookreviewplatform.TheNextChapter.service;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.ReviewEntity;
import com.bookreviewplatform.TheNextChapter.Data.repository.BookRepository;
import com.bookreviewplatform.TheNextChapter.Data.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ReviewEntity> getAllBooks() {
        return (List<ReviewEntity>) reviewRepository.findAll();
    }
}
