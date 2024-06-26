package com.library.digitallibrary.service;

import com.library.digitallibrary.domain.Book;
import com.library.digitallibrary.domain.BookRequest;
import com.library.digitallibrary.domain.BookResponse;
import com.library.digitallibrary.domain.Review;
import com.library.digitallibrary.repository.BookRepository;
import com.library.digitallibrary.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class LibraryServiceImpl implements  LibraryService{

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<BookResponse> getAllBooks() {

        List<BookResponse> bookResponses=new ArrayList<>();
        List<Book> books=bookRepository.findAll();

        books.stream().forEach(book -> {
            Double avgRating=averageRating(book);
            bookResponses.add(new BookResponse(book.getBookId(),book.getName(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getCost(),avgRating,book.getYear(),book.getAuthorEmail()));
        });
        return bookResponses;
    }

    @Override
    public Book getBookById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            throw new NoSuchElementException("No data found for the given Id "+id);
        }
        Double averageRating=averageRating(book.get());
        book.get().setRating(averageRating);
        return book.get();
    }

    @Override
    public List<Book> getBookByAuthor(String authorName) {
        List<Book> bookList=new ArrayList<>();
        List<Book> byAuthor = bookRepository.findByAuthor(authorName);
        if(byAuthor.isEmpty()){
            throw new NoSuchElementException("No data found for the given author name "+authorName);
        }
        byAuthor.stream().forEach(book->{
            Double averageRating=averageRating(book);
            book.setRating(averageRating);
            bookList.add(book);
        });

        return bookList;
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {

        Book book= bookRepository.save(bookRequest.getBook());
        return new BookResponse(book.getBookId(),book.getName(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getCost(),book.getRating(),book.getYear(),book.getAuthorEmail());


    }


    @Override
    public BookResponse updateBook(Integer bookId, Book book) {
       Optional<Book> retrievedBook = bookRepository.findById(bookId);
       if(retrievedBook.isPresent()){
           book.setBookId(retrievedBook.get().getBookId());
           bookRepository.save(book);

       }

        return new BookResponse(book.getBookId(),book.getName(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getCost(),book.getRating(),book.getYear(),book.getAuthorEmail());

    }

    @Override
    public void deleteBook(Integer bookId) {
        Optional<Book> book=bookRepository.findById(bookId);
        if(book.isPresent()){
            bookRepository.deleteById(bookId);
        }

    }

    private Double averageRating( Book book){

        Double avgRating=0.0;
        List<Optional<Review>>  reviews= reviewRepository.findByBookId(book.getBookId());
        if(reviews.size()>0) {
            OptionalDouble avg = reviews.stream().map(review -> review.get()).mapToDouble((Review::getRating)).average();
            if (avg.isPresent())
                avgRating = Math.round(avg.getAsDouble()*100.0)/100.0;

            System.out.println("average " + avg.getAsDouble());
        }

        return  avgRating;

    }
}
