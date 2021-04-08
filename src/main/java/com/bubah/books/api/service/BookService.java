package com.bubah.books.api.service;

import com.bubah.books.api.domain.Book;
import com.bubah.books.api.domain.BookId;
import com.bubah.books.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }


    public BookId createBook(Book newBook) {
        Long id = bookRepository.createBook(newBook);
        BookId bookId = new BookId();
        bookId.setId(id);

        return bookId;
    }
}
