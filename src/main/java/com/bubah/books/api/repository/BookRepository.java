package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;

import java.util.List;


public interface BookRepository {
    Long createBook(Book book);

    Book findByBookId(Long bookId);

    List<Book> getBooks();
}
