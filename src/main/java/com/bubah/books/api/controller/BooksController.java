package com.bubah.books.api.controller;

import com.bubah.books.api.domain.Book;
import com.bubah.books.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<Void> getBooks() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok().build();
    }

}
