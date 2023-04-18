package com.rodrigo.study.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false, length = 100)
    @NotEmpty(message = "Title don't be empty")
    private String title;

    @Column(name = "author", nullable = false, length = 70)
    @NotEmpty(message = "Author don't be empty")
    private String author;

    @Column(name = "pages", nullable = false)
    @Positive(message = "Pages must be greater than zero")
    @NotNull(message = "Pages don't be null")
    private Integer pages;

    @Column(name = "genre", nullable = false, length = 30)
    @NotEmpty(message = "Genre don't be empty")
    private String genre;
}
