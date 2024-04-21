package com.bookreviewplatform.TheNextChapter.Data.repository;

import com.bookreviewplatform.TheNextChapter.Data.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    GenreEntity findByGenreName(String genreName);
}