package com.bubah.books.api.controller;

import com.bubah.books.api.domain.Book;
import com.bubah.books.api.domain.BookId;
import com.bubah.books.api.service.BookService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        myBook.setTitle("Harry Potter");
        myBook.setBookId(20L);
        List<Book> books = Collections.singletonList(myBook);

        when(bookService.getBooks()).thenReturn(books);
//        String result = "/"
        String booksAsJson = new Gson().toJson(books);


        // When
        mockMvc.perform(get("/books"))
                .andExpect(content().json(booksAsJson))
                .andExpect(status().isOk());

        // Then
        verify(bookService).getBooks();
    }

    @Test
    public void createABook() throws Exception {
        // Given
        Gson gson = new Gson();
        Book newBook = new Book();
        newBook.setTitle("The DevOps Handbook");
        String newBookAsJson = gson.toJson(newBook);

        BookId bookId = new BookId();
        bookId.setId(25L);
        String bookIdAsJson = gson.toJson(bookId);

        when(bookService.createBook(newBook)).thenReturn(bookId);

        // When
        mockMvc.perform(post("/books").content(newBookAsJson).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(bookIdAsJson))
                .andExpect(status().isCreated());
        // Then
        verify(bookService).createBook(newBook);
    }
}
