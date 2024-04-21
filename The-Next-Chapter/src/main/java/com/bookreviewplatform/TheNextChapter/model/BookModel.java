package com.bookreviewplatform.TheNextChapter.model;
import com.bookreviewplatform.TheNextChapter.Data.entity.AuthorEntity;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

    private Long bookId;

    private String bookName;

    private Integer numberOfPages;

    private Double averageRating;

    private AuthorEntity authorEntity;

}
