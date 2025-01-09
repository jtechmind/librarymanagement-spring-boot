package com.jtechmind.librarymanagement.catalog.services;

import com.jtechmind.librarymanagement.catalog.models.BookResponse;

import java.util.List;

public interface CatalogService {
    List<BookResponse> getAllBooks();
    BookResponse getBookById(Long id);
    List<BookResponse> searchBooks(String query);
    List<BookResponse> filterBooks(String genre, Integer minQuantity);
}
