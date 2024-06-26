package com.library.digitallibrary.repository;

import com.library.digitallibrary.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    public List<Optional<Review>> findByBookId(Integer bookId);
}
