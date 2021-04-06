package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MongodbBookRepository  implements BookRepository {

    @Autowired
    BookMongoRepository bookMongoRepository;

    @Override
    public int createBook(Book book) {
        bookMongoRepository.save(book);
        return book.getId();
    }

    @Override
    public Book findById(int bookId) {
        Optional<Book> maybeBook = bookMongoRepository.findById(bookId);
        if(maybeBook.isPresent()) {
            return maybeBook.get();
        }
        return null;
    }
}
