package com.bookreviewplatform.TheNextChapter.Data.repository;
import com.bookreviewplatform.TheNextChapter.Data.entity.ReviewEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ReviewRepository extends CrudRepository<ReviewEntity, Long> {
    @Query("SELECT r.users FROM ReviewEntity r WHERE r.reviewId = :reviewId")
    Set<UserEntity> findUsersByReviewId(@Param("reviewId") Long reviewId);
}