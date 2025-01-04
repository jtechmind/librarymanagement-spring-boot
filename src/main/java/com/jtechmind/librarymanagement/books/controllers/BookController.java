package com.jtechmind.librarymanagement.books.controllers;

import com.jtechmind.librarymanagement.books.models.Book;
import com.jtechmind.librarymanagement.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // Save new book
    @PostMapping("/")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    // Get All Books
    @GetMapping
    public ResponseEntity<List<Book>> retrieveAllBooks(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

    // Get All Books Of An Author
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBookByAuthorName(@PathVariable String author){
        return ResponseEntity.ok(bookService.findBooksByAuthor(author));
    }
    // Get Book By Title
    @GetMapping("/search")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title){
        return ResponseEntity.ok(bookService.findBooksByTitle(title));
    }

    // Update Existing Book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateExistingBook(@PathVariable Long id, @RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(id,book));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
