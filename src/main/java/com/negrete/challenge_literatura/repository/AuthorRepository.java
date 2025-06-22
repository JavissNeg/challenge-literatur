package com.negrete.challenge_literatura.repository;

import com.negrete.challenge_literatura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByDeathYearGreaterThan(Integer year);
}
