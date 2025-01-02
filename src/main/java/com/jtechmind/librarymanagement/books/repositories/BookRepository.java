package com.jtechmind.librarymanagement.books.repositories;

import com.jtechmind.librarymanagement.books.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
