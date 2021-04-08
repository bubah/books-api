package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MongodbBookRepositoryTest {

    @Mock
    BookMongoRepository bookMongoRepository;

    @InjectMocks
    MongodbBookRepository mongodbBookRepository;

    @Test
    public void getBooks() {
        // Given
        Book harryPotter = new Book();
        harryPotter.setTitle("Harry Potter");
        harryPotter.setBookId(21L);
        List<Book> listOfBooks = Collections.singletonList(harryPotter);
        when(bookMongoRepository.findAll()).thenReturn(listOfBooks);
        // When
        List<Book> books = mongodbBookRepository.getBooks();

        // Then
        Assertions.assertThat(books).containsAll(listOfBooks);
    }
}
