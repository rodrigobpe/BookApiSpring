package com.rodrigo.study.service;

import java.util.List;
import java.util.UUID;

import com.rodrigo.study.model.Book;

public interface BookService {
    Book getById(UUID id);
    List<Book> getAll();
    Book create(Book book);
    void delete(UUID id);
}
