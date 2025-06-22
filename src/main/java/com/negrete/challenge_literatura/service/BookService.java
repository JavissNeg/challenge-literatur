package com.negrete.challenge_literatura.service;

import com.negrete.challenge_literatura.model.*;
import com.negrete.challenge_literatura.repository.AuthorRepository;
import com.negrete.challenge_literatura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public Book addBook(BookData bookData) {
        List<Author> authors = bookData.authors().stream()
                .map(ad -> authorRepository.save(new Author(ad)))
                .toList();

        Book book = new Book(bookData, authors);
        return bookRepository.save(book);
    }

    public Optional<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.isEmpty() ? Optional.empty() : Optional.of(books);
    }

    public Optional<List<Book>> getBooksByLanguage(Language language) {
        List<Book> books = bookRepository.findByLanguage(language);
        return books.isEmpty() ? Optional.empty() : Optional.of(books);
    }


}
