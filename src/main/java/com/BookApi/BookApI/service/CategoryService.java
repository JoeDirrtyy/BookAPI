package com.BookApi.BookApI.service;

import com.BookApi.BookApI.domain.Category;
import com.BookApi.BookApI.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<?> createCategory(Category category) {
        category = categoryRepository.save(category);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(category.getId()).toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<Iterable<Category>> getAllCategories(){
        Iterable<Category> allCategories = categoryRepository.findAll();
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<?> updateCategory(Category category, Long categoryId) {
        verifyCategory(categoryId);
        categoryRepository.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCategory( Long categoryId) {
        categoryRepository.deleteById(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> getCategoryById( Long categoryId) {
        Optional<Category> c = categoryRepository.findById(categoryId);
        return new ResponseEntity<> (c, HttpStatus.OK);
    }


    protected void verifyCategory(Long pollId){
        Optional<Category> c = categoryRepository.findById(pollId);
        }
}
