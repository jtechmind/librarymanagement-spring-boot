package com.jtechmind.librarymanagement.books.services;

import com.jtechmind.librarymanagement.books.models.Book;
import com.jtechmind.librarymanagement.books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImp implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Book not found by id: "+id));
    }

    @Override
    public List<Book> getAllBook() {
        return null;
    }

    @Override
    public Book updateBook(Long id) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return null;
    }
}
