package com.bubah.books.api.repository;

import com.bubah.books.api.domain.Book;
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
        int bookId = bookRepository.createBook(book);
        Book retrievedBook = bookRepository.findById(bookId);

        // Then
        assertEquals(book, retrievedBook);
    }
}