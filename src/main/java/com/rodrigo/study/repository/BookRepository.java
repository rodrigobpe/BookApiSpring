package com.rodrigo.study.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.study.model.Book;

public interface BookRepository extends JpaRepository<Book,UUID> { }
