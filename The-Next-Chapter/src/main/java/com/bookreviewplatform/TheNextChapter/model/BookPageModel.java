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
public class BookPageModel {
    @JsonProperty("bookId")
    private Long bookId;
    @JsonProperty("bookName")
    private String bookName;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("authorName")
    private String authorName;
    @JsonProperty("pages")
    private Integer pages;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("reviewId")
    private Long reviewId;
}
