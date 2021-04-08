package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;


public interface BookRepository {
    Long createBook(Book book);

    Book findByBookId(Long bookId);
}
