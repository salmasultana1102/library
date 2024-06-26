package com.library.digitallibrary.controller;

import com.library.digitallibrary.domain.Book;
import com.library.digitallibrary.domain.BookResponse;
import com.library.digitallibrary.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    LibraryService libraryService;

    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>> getAllBooks(){

        List<BookResponse> books=libraryService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/byId")
    public  ResponseEntity<Book> getBookById(@RequestParam("bookId") Integer bookId){
         Book book= libraryService.getBookById(bookId);
         return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @GetMapping("/books/byAuthor")
    public  ResponseEntity<List<Book>> getBookByAuthor(@RequestParam("author") String authorName){
        List<Book> books= libraryService.getBookByAuthor(authorName);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }
}
