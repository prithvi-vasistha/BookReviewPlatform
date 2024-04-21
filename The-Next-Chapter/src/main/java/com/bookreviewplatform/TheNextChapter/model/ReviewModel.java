package com.bookreviewplatform.TheNextChapter.model;
import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.UserEntity;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewModel {

    private Long reviewId;

    private String reviewText;

    private Double rating;

}
