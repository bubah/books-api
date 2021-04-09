package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Profile("local")
@Repository
public class InMemoryBookRepository implements BookRepository {

    private static Long ID_COUNTER = 0L;

    Map<Long, Book> booksById = new HashMap<Long, Book>();
    @Override
    public Long createBook(Book book) {
        ID_COUNTER += 1;
        booksById.put(ID_COUNTER, book);
        return ID_COUNTER;
    }

    @Override
    public Book findByBookId(Long bookId) {
        return booksById.get(bookId);
    }

    @Override
    public List<Book> getBooks() {
        throw new UnsupportedOperationException("not implemented yet!!");
    }
}
