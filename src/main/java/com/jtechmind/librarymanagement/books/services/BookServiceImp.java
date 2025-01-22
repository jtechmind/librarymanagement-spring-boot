package com.jtechmind.librarymanagement.books.services;

import com.jtechmind.librarymanagement.books.models.Book;
import com.jtechmind.librarymanagement.books.repositories.BookRepository;
import com.jtechmind.librarymanagement.exceptions.BookNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookServiceImp implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private Validator validator;

    @Override
    public Book createBook(Book book) {
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if(!violations.isEmpty()){
            String errorMessage = violations.stream()
                    .map(v -> v.getPropertyPath()+" "+v.getMessage())
                    .reduce((m1, m2) -> m1 + ","+ m2)
                    .orElse("Validation Failed");
            throw new ConstraintViolationException(errorMessage,violations);
        }
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException("Book not found by id: "+id));
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id,Book updatedBook) {
        Book existingBook = getBookById(id);
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setGenre(updatedBook.getGenre());
        existingBook.setQuantity(updatedBook.getQuantity());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
