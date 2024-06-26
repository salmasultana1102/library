package com.library.digitallibrary.controller;

import com.library.digitallibrary.domain.Review;
import com.library.digitallibrary.domain.ReviewRequest;
import com.library.digitallibrary.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/addReview")
    public Review addReview(@Valid @RequestBody ReviewRequest reviewRequest){
        return  reviewService.addReview(reviewRequest.getReview());

    }
}
