package com.bookreviewplatform.TheNextChapter.Data.repository;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.model.BookPageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query("SELECT new com.bookreviewplatform.TheNextChapter.model.BookPageModel(" +
            "b.bookId, " + // Include bookId in the SELECT statement
            "b.bookName, " +
            "g.genreName, " +
            "a.authorName, " +
            "b.numberOfPages, " +
            "b.averageRating, " +
            "r.reviewId) " +
            "FROM BookEntity b " +
            "JOIN b.genres g " +
            "JOIN b.authors a " +
            "LEFT JOIN b.reviews r " +
            "ORDER BY b.bookId" // Add an ORDER BY clause if needed
    )
    List<BookPageModel> findBookDetails();
}