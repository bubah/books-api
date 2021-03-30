package com.bubah.books.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksController {
    @GetMapping("/books")
    public ResponseEntity<Void> getBooks() {
        return ResponseEntity.ok().build();
    }

}
