package com.negrete.challenge_literatura.repository;

import com.negrete.challenge_literatura.model.Book;
import com.negrete.challenge_literatura.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguage(Language language);
}
