package com.bookreviewplatform.TheNextChapter.Data.adapter;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.model.BookModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookEntityConverter {
    public BookEntity convertToEntity(BookModel bookModel) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookId(bookModel.getBookId());
        bookEntity.setBookName(bookModel.getBookName());
        bookEntity.setNumberOfPages(bookModel.getNumberOfPages());
        return bookEntity;
    }



    public BookModel convertToModel(BookEntity bookEntity){
        BookModel bookModel= new BookModel();
        bookModel.setBookId(bookEntity.getBookId());
        bookModel.setBookName(bookEntity.getBookName());
        bookModel.setNumberOfPages(bookEntity.getNumberOfPages());
        return bookModel;
    }
}

