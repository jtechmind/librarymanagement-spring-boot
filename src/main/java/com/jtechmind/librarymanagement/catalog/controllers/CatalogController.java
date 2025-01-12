package com.jtechmind.librarymanagement.catalog.controllers;

import com.jtechmind.librarymanagement.books.models.Book;
import com.jtechmind.librarymanagement.books.services.BookService;
import com.jtechmind.librarymanagement.catalog.models.BookResponse;
import com.jtechmind.librarymanagement.catalog.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/")
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return ResponseEntity.ok(catalogService.getAllBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(catalogService.getBookById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<List<BookResponse>> searchBooks(@RequestParam String query){
        return ResponseEntity.ok(catalogService.searchBooks(query));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<BookResponse>> filterBooks(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer minQuantity){
        return ResponseEntity.ok(catalogService.filterBooks(genre,minQuantity));
    }

}
