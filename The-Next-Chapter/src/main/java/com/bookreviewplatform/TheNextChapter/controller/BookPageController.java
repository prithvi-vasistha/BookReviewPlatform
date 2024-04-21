package com.bookreviewplatform.TheNextChapter.controller;
import com.bookreviewplatform.TheNextChapter.Data.adapter.ReviewEntityConverter;
import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.ReviewEntity;
import com.bookreviewplatform.TheNextChapter.Data.repository.BookRepository;
import com.bookreviewplatform.TheNextChapter.model.BookPageModelFormatted;
import com.bookreviewplatform.TheNextChapter.model.ReviewModel;
import lombok.extern.slf4j.Slf4j;

import com.bookreviewplatform.TheNextChapter.model.BookPageModel;
import com.bookreviewplatform.TheNextChapter.service.BookPageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@Controller
@RequestMapping("api/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@Slf4j
public class BookPageController {
    private final BookPageService bookPageService;
    private  final BookRepository bookRepository;
    private  final ReviewEntityConverter reviewEntityConverter;
    @GetMapping("bookpage")
    public String all(Model model) {
        model.addAttribute("bookInfo", bookPageService.getBookPageModels());
        log.info(bookPageService.getBookPageModels().toString());
        return "bookpage";
    }


    @GetMapping("reviews/{id}")
    public String getReviewById(@PathVariable("id") Long id, Model model) {
        BookPageModelFormatted bookPageModelFormattedOptional = bookPageService.getBookPageModels().stream().filter(x->x.getBookId().compareTo(id)==0).findFirst().orElseGet(BookPageModelFormatted::new);
            model.addAttribute("reviews", bookPageModelFormattedOptional);
            return "reviews";
    }





    @GetMapping("addbooks")
    public String goToAddPage(){
        return "addbooks";
    }

    @PostMapping("addbooks")
    public String addBookInfo(Model model, BookPageModel newBookPageModel) {
        bookPageService.saveBookPageModels(Collections.singletonList(newBookPageModel));
        model.addAttribute("bookInfo", bookPageService.getBookPageModels());
        bookPageService.getBookPageModels();
        return "bookpage";
    }


}
