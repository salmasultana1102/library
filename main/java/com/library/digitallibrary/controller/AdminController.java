package com.library.digitallibrary.controller;

import com.library.digitallibrary.domain.Book;
import com.library.digitallibrary.domain.BookRequest;
import com.library.digitallibrary.domain.BookResponse;
import com.library.digitallibrary.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    LibraryService libraryService;

    @PostMapping("/addBook")
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookRequest bookRequest){

        BookResponse bookResponse=  libraryService.createBook(bookRequest);
        return new ResponseEntity<>(bookResponse,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<BookResponse> updateBook(@RequestParam("id") Integer bookId, @RequestBody Book book){

        BookResponse bookResponse= libraryService.updateBook(bookId,book);
        return  new ResponseEntity<>(bookResponse,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteBook(@RequestParam("bookId") Integer bookId){

        libraryService.deleteBook(bookId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
