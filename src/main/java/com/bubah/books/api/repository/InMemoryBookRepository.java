package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryBookRepository implements BookRepository {

    // TODO: store books in a Map
    Map<Integer, Book> booksById = new HashMap<>();

    @Override
    public int createBook(Book book) {
        booksById.put(1, book);
        return 1;
    }

    @Override
    public Book findById(int bookId) {
        return booksById.get(bookId);
    }
}
