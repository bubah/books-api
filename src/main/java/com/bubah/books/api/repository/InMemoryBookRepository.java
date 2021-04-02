package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookRepository implements BookRepository {

    // TODO: store books in a Map

    @Override
    public int createBook(Book book) {
        throw new UnsupportedOperationException("not implemented yet!!");
    }
}
