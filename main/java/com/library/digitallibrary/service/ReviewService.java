package com.library.digitallibrary.service;

import com.library.digitallibrary.domain.Review;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {

    public Review addReview(Review review);
}
