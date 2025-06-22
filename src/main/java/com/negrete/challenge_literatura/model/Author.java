package com.negrete.challenge_literatura.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    private String name;

    private Integer birthYear;
    private Integer deathYear;
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;


    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Author() {}

    public Author(AuthorData data) {
        this.name = data.name();
        this.birthYear = data.birthYear();
        this.deathYear = data.deathYear();
        this.createdAt = LocalDateTime.now();
    }


    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
