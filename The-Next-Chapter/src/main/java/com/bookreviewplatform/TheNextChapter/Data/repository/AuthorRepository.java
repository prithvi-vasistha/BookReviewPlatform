package com.bookreviewplatform.TheNextChapter.Data.repository;

import com.bookreviewplatform.TheNextChapter.Data.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    AuthorEntity findByAuthorName(String authorName);
}