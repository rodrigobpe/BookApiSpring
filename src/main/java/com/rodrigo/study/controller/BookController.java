package com.rodrigo.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.study.model.Book;
import com.rodrigo.study.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return this.bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable UUID id){
        return this.bookService.getById(id);
    }

    @PostMapping
    public Book createBook(@Valid @RequestBody Book book){
        return this.bookService.create(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable UUID id){
        this.bookService.delete(id);
        Map<String,Object> res = new HashMap<>();
        res.put("status", HttpStatus.OK);
        res.put("message","Book deleted");
        return new ResponseEntity<Object>(res,HttpStatus.OK);

    }
}
