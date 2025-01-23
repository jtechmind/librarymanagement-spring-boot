package com.jtechmind.librarymanagement.books.controllers;

import com.jtechmind.librarymanagement.books.models.Book;
import com.jtechmind.librarymanagement.books.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // Save new book
    @PostMapping("/")
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book, BindingResult result){
        if (result.hasErrors()) {
            String errors = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(errors);
        }
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
    public ResponseEntity<Book> updateExistingBook(@PathVariable Long id, @Valid @RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(id,book));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
