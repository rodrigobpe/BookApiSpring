package com.rodrigo.study.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.rodrigo.study.exception.RecordNotFoundException;
import com.rodrigo.study.model.Book;
import com.rodrigo.study.repository.BookRepository;
import com.rodrigo.study.service.BookService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getById(@PathVariable @NotNull UUID id) {
        return this.bookRepository.findById(id).orElseThrow(()-> new RecordNotFoundException("Book not found with id "+id));
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book create(@Valid Book book) {
        return this.bookRepository.save(book);
    }
    
}
