package com.bubah.books.api.service;

import com.bubah.books.api.domain.Book;
import com.bubah.books.api.domain.BookId;
import com.bubah.books.api.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Test
    public void createABook() {
        // Given
        Book book = new Book();
        book.setTitle("DevOps Handbook");

        when(bookRepository.createBook(book)).thenReturn(25L);

        // When
        BookId bookId = bookService.createBook(book);

        // Then
        verify(bookRepository).createBook(book);
        assertEquals(bookId.getId(), 25L);

    }
}
