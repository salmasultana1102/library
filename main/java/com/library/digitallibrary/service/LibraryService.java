package com.library.digitallibrary.service;

import com.library.digitallibrary.domain.Book;
import com.library.digitallibrary.domain.BookRequest;
import com.library.digitallibrary.domain.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryService {

    public List<BookResponse> getAllBooks();

    public Book getBookById(Integer bookId);

    public List<Book> getBookByAuthor(String authorName);

    public BookResponse createBook(BookRequest book);

    public BookResponse updateBook( Integer bookId, Book book);

    public void deleteBook(Integer bookId);


}
