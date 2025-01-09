package com.jtechmind.librarymanagement.catalog.repositories;

import com.jtechmind.librarymanagement.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Book,Long> {
    // Search books by title
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Filter books by genre and minimum quantity
    List<Book> findByGenreAndQuantityGreaterThanEqual(String genre, Integer minQuantity);
}
