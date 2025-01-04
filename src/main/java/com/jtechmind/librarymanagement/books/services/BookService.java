package com.jtechmind.librarymanagement.books.services;

import com.jtechmind.librarymanagement.books.models.Book;

import java.util.List;
public interface BookService {
    Book createBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBook();
    Book updateBook(Long id,Book updatedBook);
    void deleteBook(Long id);
    List<Book> findBooksByAuthor(String author);
    List<Book> findBooksByTitle(String title);
}
