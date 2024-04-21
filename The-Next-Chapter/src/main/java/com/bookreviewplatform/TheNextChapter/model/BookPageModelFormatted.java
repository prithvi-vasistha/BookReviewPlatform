package com.bookreviewplatform.TheNextChapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookPageModelFormatted {
    @JsonProperty("bookId")
    private Long bookId;
    @JsonProperty("bookName")
    private String bookName;
    @JsonProperty("genre")
    private List<String> genre;
    @JsonProperty("authorName")
    private List<String> authorName;
    @JsonProperty("pages")
    private Integer pages;
    @JsonProperty("review")
    private List<String> review;
    @JsonProperty("rating")
    private List<Double> rating;
    @JsonProperty("users")
    private List<String> users;
    @JsonProperty("reviewId")
    private List<Long> reviewId;
}
