package com.bookreviewplatform.TheNextChapter.Data.adapter;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.ReviewEntity;
import com.bookreviewplatform.TheNextChapter.model.BookModel;
import com.bookreviewplatform.TheNextChapter.model.ReviewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewEntityConverter {
    public ReviewEntity convertToEntity(ReviewModel reviewModel) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setReviewId(reviewModel.getReviewId());
        reviewEntity.setReviewText(reviewModel.getReviewText());
        reviewEntity.setRating(reviewModel.getRating());
        return reviewEntity;
    }



    public ReviewModel convertToModel(ReviewEntity reviewEntity){
        ReviewModel reviewModel = new ReviewModel();
        reviewEntity.setReviewText(reviewModel.getReviewText());
        reviewEntity.setReviewId(reviewModel.getReviewId());
        reviewEntity.setRating(reviewModel.getRating());
        return reviewModel;
    }
}

