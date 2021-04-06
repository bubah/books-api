package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {

    private static int ID_COUNTER = 0;

    Map<Integer, Book> booksById = new HashMap<>();
    @Override
    public int createBook(Book book) {
        ID_COUNTER += 1;
        booksById.put(ID_COUNTER, book);
        return ID_COUNTER;
    }

    @Override
    public Book findById(int bookId) {
        return booksById.get(bookId);
    }
}
