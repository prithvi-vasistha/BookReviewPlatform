package com.bookreviewplatform.TheNextChapter.Data.adapter;

import com.bookreviewplatform.TheNextChapter.Data.entity.AuthorEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.model.AuthorModel;
import com.bookreviewplatform.TheNextChapter.model.BookModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorEntityConverter {
    public AuthorEntity convertToEntity(AuthorModel authorModel) {
        AuthorEntity authorEntity=new AuthorEntity();
        authorEntity.setAuthorId(authorModel.getAuthorId());
        authorEntity.setAuthorName(authorModel.getAuthorName());
        return authorEntity;
    }



    public AuthorModel convertToModel(AuthorEntity authorEntity){
        AuthorModel authorModel=new AuthorModel();
        authorModel.setAuthorId(authorEntity.getAuthorId());
        authorModel.setAuthorName(authorEntity.getAuthorName());
        return authorModel;
    }
}

