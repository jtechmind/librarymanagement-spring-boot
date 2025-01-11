package com.jtechmind.librarymanagement.catalog.services;

import com.jtechmind.librarymanagement.books.models.Book;
import com.jtechmind.librarymanagement.catalog.models.BookResponse;
import com.jtechmind.librarymanagement.catalog.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CatalogServiceImp implements CatalogService{

    @Autowired
    private CatalogRepository catalogRepository;

    // Private helper method to map Book to BookResponse
    private BookResponse mapToResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getQuantity()
        );
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> books = catalogRepository.findAll();
        return books.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse getBookById(Long id) {
        return catalogRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(()-> new RuntimeException("Book not found"));
    }

    @Override
    public List<BookResponse> searchBooks(String query) {
        return catalogRepository.findByTitleContainingIgnoreCase(query)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<BookResponse> filterBooks(String genre, Integer minQuantity) {
        return catalogRepository.findByGenreAndQuantityGreaterThanEqual(genre,minQuantity)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
}
