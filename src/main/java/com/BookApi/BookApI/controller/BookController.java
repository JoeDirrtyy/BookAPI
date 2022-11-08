package com.BookApi.BookApI.controller;

import com.BookApi.BookApI.domain.Book;
import com.BookApi.BookApI.repository.BookRepository;
import com.BookApi.BookApI.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;



@RestController
public class BookController {

    static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private  BookRepository bookRepository;

    @PostMapping("/books/{categoryId}/books")
    public Optional<Book> createBook(@PathVariable (value = "categoryId") Long categoryId, @Valid @RequestBody Book book){
       logger.info("This is a log");
        return bookService.createBook(categoryId,book);
    }

    @GetMapping("/books{bookId}")
    public Optional<Book> getBooksById(@PathVariable Long bookId) {
        return bookRepository.findById(bookId);
    }

    @GetMapping("/books")
    public void getAllBooks() {
        bookService.getAllBooks();
    }

    @PutMapping("/books{id}")
    public Optional<Book> updateBook(@PathVariable Long id, Book bookRequest){
        return bookService.updateBook(id,bookRequest);
    }


    @DeleteMapping("/category/{categoryId}/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long Id) {
        bookService.deleteBook(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
