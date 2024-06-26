package com.library.digitallibrary.repository;

import com.library.digitallibrary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Override
    Optional<Book> findById(Integer bookId);

    List<Book> findByAuthor(String authorName);
}
