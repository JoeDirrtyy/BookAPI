package com.BookApi.BookApI.controller;

import com.BookApi.BookApI.domain.Category;
import com.BookApi.BookApI.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CategoryController {

    static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@Valid @RequestBody Category category) {
       logger.info("This is a log");
        return categoryService.createCategory(category);
    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        return categoryService.updateCategory(category, categoryId);
    }

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }
}
