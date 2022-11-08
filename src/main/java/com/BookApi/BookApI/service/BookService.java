package com.BookApi.BookApI.service;

import com.BookApi.BookApI.domain.Book;
import com.BookApi.BookApI.repository.BookRepository;
import com.BookApi.BookApI.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;


    public Optional<Book> createBook(Long categoryId, Book book) {
        return categoryRepository.findById(categoryId).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);
        });
    }

    public void deleteBook(Long id) {
     Optional<Book> book = bookRepository.findById(id);
            bookRepository.deleteById(id);
    }

    public void getAllBooks() {
       bookRepository.findAll();
    }


    public Optional<Book> updateBook( Long bookId, Book bookRequest) {
        return bookRepository.findById(bookId).map(book -> {
            book.setName(bookRequest.getName());
            book.setSku(bookRequest.getSku());
            book.setDescription(bookRequest.getDescription());
            book.setImage(bookRequest.getImage());
            book.setPrice(bookRequest.getPrice());
            book.setStock(bookRequest.getStock());
            book.setCategory(bookRequest.getCategory());
            return bookRepository.save(book);
        });
    }
}
