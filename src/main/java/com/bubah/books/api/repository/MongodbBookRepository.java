package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongodbBookRepository  implements BookRepository {

    // TODO: this should be something persistent
    private static Long ID_COUNTER = 0L;

    @Autowired
    BookMongoRepository bookMongoRepository;

    @Override
    public Long createBook(Book book) {
        ID_COUNTER++;
        book.setBookId(ID_COUNTER);
        bookMongoRepository.save(book);
        return book.getBookId();
    }

    @Override
    public Book findByBookId(Long bookId) {
        return bookMongoRepository.findByBookId(bookId);
    }

    @Override
    public List<Book> getBooks() {
        return bookMongoRepository.findAll();
    }
}
