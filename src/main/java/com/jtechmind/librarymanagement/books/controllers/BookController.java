package com.jtechmind.librarymanagement.books.controllers;

import com.jtechmind.librarymanagement.books.models.Book;
import com.jtechmind.librarymanagement.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to the books api";
    }

    // Save new book
    @PostMapping("/save")
    public Book saveBook(@RequestBody Book book){
       return bookService.createBook(book);
    }
    @PostMapping("/")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public Book getById(@RequestParam Long id){
        return bookService.getBookById(id);
    }
}
