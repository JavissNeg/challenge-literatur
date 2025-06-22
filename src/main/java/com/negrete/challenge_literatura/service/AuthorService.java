package com.negrete.challenge_literatura.service;

import com.negrete.challenge_literatura.model.Author;
import com.negrete.challenge_literatura.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Optional<List<Author>> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.isEmpty() ? Optional.empty() : Optional.of(authors);
    }

    public Optional<List<Author>> getLivingAuthorsBeforeYear(int year) {
        List<Author> authors = authorRepository.findByDeathYearGreaterThan(year);
        return authors.isEmpty() ? Optional.empty() : Optional.of(authors);
    }
}
