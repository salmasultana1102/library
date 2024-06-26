package com.library.digitallibrary.service;

import com.library.digitallibrary.domain.Review;
import com.library.digitallibrary.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl  implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review addReview(Review review) {

        return reviewRepository.save(review);
    }
}
