package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;


public interface BookRepository {
    int createBook(Book book);

    Book findById(int bookId);
}
