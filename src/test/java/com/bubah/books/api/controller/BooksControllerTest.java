package com.bubah.books.api.controller;

import com.bubah.books.api.domain.Book;
import com.bubah.books.api.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void getBooks() throws Exception {
        // Given
        Book myBook = new Book();
        List<Book> books = Collections.singletonList(myBook);

        when(bookService.getBooks()).thenReturn(books);

        // When
        mockMvc.perform(get("/books")).andExpect(status().isOk());

        // Then
        verify(bookService).getBooks();
    }
}
