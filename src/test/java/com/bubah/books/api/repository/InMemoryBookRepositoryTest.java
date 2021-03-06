package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryBookRepositoryTest {
    @Test
    public void createAndRetrieveBook() {
        // Given
        BookRepository bookRepository = new InMemoryBookRepository();
        Book book = new Book();
        book.setTitle("DevOps Handbook");

        // When
        Long bookId = bookRepository.createBook(book);
        Book retrievedBook = bookRepository.findByBookId(bookId);

        // Then
        assertEquals(book, retrievedBook);
    }

    @Test
    public void createBookReturnsAnId() {
        // Given
        BookRepository bookRepository = new InMemoryBookRepository();
        Book firstBook = new Book();
        firstBook.setTitle("DevOps Handbook");

        Book secondBook = new Book();
        secondBook.setTitle("Second Book");

        // When
        Long bookId = bookRepository.createBook(firstBook);
        Long bookIdTwo = bookRepository.createBook(secondBook);

        // Then
        Assertions.assertThat(bookId).isLessThan(bookIdTwo);
    }
}