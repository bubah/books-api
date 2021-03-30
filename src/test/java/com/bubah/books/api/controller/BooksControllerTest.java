package com.bubah.books.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BooksControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getBooks() throws Exception {
        // Given

        // When
        mockMvc.perform(get("/books")).andExpect(status().isOk());

        // Then
    }
}
