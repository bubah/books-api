package com.bubah.books.api.repository;
import com.bubah.books.api.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface BookMongoRepository extends MongoRepository<Book, String> {
    Book findByBookId(Long bookId);
}
