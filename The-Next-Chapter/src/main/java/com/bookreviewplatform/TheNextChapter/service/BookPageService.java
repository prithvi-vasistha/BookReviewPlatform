package com.bookreviewplatform.TheNextChapter.service;

import com.bookreviewplatform.TheNextChapter.Data.entity.*;
import com.bookreviewplatform.TheNextChapter.Data.repository.AuthorRepository;
import com.bookreviewplatform.TheNextChapter.Data.repository.BookRepository;
import com.bookreviewplatform.TheNextChapter.Data.repository.GenreRepository;
import com.bookreviewplatform.TheNextChapter.Data.repository.ReviewRepository;
import com.bookreviewplatform.TheNextChapter.model.BookPageModel;
import com.bookreviewplatform.TheNextChapter.model.BookPageModelFormatted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BookPageService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final ReviewRepository reviewRepository;

    public List<BookPageModelFormatted> getBookPageModels() {
        List<BookPageModel> bookPageModels = bookRepository.findBookDetails();
        return bookPageModels.stream()
                .collect(Collectors.toMap(BookPageModel::getBookId, x ->
                                BookPageModelFormatted.builder()
                                        .bookId(x.getBookId())
                                        .bookName(x.getBookName())
                                        .genre(Arrays.asList(x.getGenre()))
                                        .authorName(Arrays.asList(x.getAuthorName()))
                                        .pages(x.getPages())
                                        .rating(Arrays.asList(x.getRating()))
                                        .reviewId(Arrays.asList(x.getReviewId()))
                                        .build()
                        , (existing, replacement) -> {
                            if (existing.getReviewId().stream().noneMatch(x -> replacement.getReviewId().stream().findFirst().orElse(0L).compareTo(x) == 0)) {
                                existing.setReviewId(Stream.concat(existing.getReviewId().stream(), replacement.getReviewId().stream()).collect(Collectors.toList()));

                            }
                            if (existing.getAuthorName().stream().noneMatch(x -> replacement.getAuthorName().stream().findFirst().orElse("").equalsIgnoreCase(x))) {
                                existing.setAuthorName(Stream.concat(existing.getAuthorName().stream(), replacement.getAuthorName().stream()).collect(Collectors.toList()));

                            }

                            if (existing.getGenre().stream().noneMatch(x -> replacement.getGenre().stream().findFirst().orElse("").equalsIgnoreCase(x))) {
                                existing.setGenre(Stream.concat(existing.getGenre().stream(), replacement.getGenre().stream()).collect(Collectors.toList()));
                            }
                            if (existing.getRating().stream().noneMatch(x -> replacement.getRating().stream().findFirst().orElse(0.0).compareTo(x) == 0)) {
                                existing.setRating(Stream.concat(existing.getRating().stream(), replacement.getRating().stream()).collect(Collectors.toList()));
                            }

                            return existing;
                        }))
                .values()
                .stream()
                .peek(x-> x.setReview(getReviewsFromReviewId(x.getReviewId())))
                .peek(x-> x.setRating(getRatingsFromReviewId(x.getReviewId())))
                .peek(x-> x.setUsers(getUserNamesByReviewIDs(x.getReviewId())))
                .collect(Collectors.toList());
    }

    private List<String> getReviewsFromReviewId(List<Long> reviewIds) {
        return reviewIds.stream()
                .sorted()
                .filter(Objects::nonNull)
                .map(reviewRepository::findById)
                .map(x -> x
                        .map(ReviewEntity::getReviewText)
                        .orElse("")
                )
                .collect(Collectors.toList());
    }

    private List<Double> getRatingsFromReviewId(List<Long> reviewIds) {
        return reviewIds.stream()
                .sorted()
                .filter(Objects::nonNull)
                .map(reviewRepository::findById)
                .map(x -> x
                        .map(ReviewEntity::getRating)
                        .orElse(0.0)
                )
                .collect(Collectors.toList());
    }

    private List<String> getUserNamesByReviewIDs(List<Long> reviewIds) {
        return reviewIds.stream()
                .sorted()
                .filter(Objects::nonNull)
                .map(reviewRepository::findUsersByReviewId)
                .map(x -> x
                        .stream()
                        .findFirst()
                        .map(UserEntity::getUsername)
                        .orElse("")
                ).collect(Collectors.toList());
    }

    public void saveBookPageModels(List<BookPageModel> bookPageModels) {

        bookPageModels.forEach(bookPageModel -> {
            BookEntity bookEntity = new BookEntity();
            bookEntity.setBookName(bookPageModel.getBookName());
            bookEntity.setNumberOfPages(bookPageModel.getPages());

            AuthorEntity authorEntity = authorRepository.findByAuthorName(bookPageModel.getAuthorName());
            GenreEntity genreEntity = genreRepository.findByGenreName(bookPageModel.getGenre());

            if (authorEntity == null) {
                AuthorEntity newAuthorEntity = new AuthorEntity();
                newAuthorEntity.setAuthorName(bookPageModel.getAuthorName());
                authorRepository.save(newAuthorEntity);
                bookEntity.getAuthors().add(authorRepository.findByAuthorName(bookPageModel.getAuthorName()));
            }
            if (genreEntity == null) {
                GenreEntity newGenreEntity = new GenreEntity();
                newGenreEntity.setGenreName(bookPageModel.getGenre());
                genreRepository.save(newGenreEntity);
                bookEntity.getGenres().add(genreRepository.findByGenreName(bookPageModel.getGenre()));
            }
            if (authorEntity != null) {
                bookEntity.getAuthors().add(authorEntity);
            }
            if (genreEntity != null) {
                bookEntity.getGenres().add(genreEntity);
            }

            bookRepository.save(bookEntity);
        });
    }
}