package com.bookreviewplatform.TheNextChapter.Data.adapter;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.GenreEntity;
import com.bookreviewplatform.TheNextChapter.model.BookModel;
import com.bookreviewplatform.TheNextChapter.model.GenreModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenreEntityConverter {
    public GenreEntity convertToEntity(GenreModel genreModel) {
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setGenreName(genreModel.getGenreName());
        genreEntity.setGenreId(genreModel.getGenreId());
        return genreEntity;
    }



    public GenreModel convertToModel(GenreEntity genreEntity){
        GenreModel genreModel = new GenreModel();
        genreModel.setGenreId(genreEntity.getGenreId());
        genreModel.setGenreName(genreEntity.getGenreName());
        return genreModel;
    }
}

