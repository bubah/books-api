package com.bubah.books.api.graphql;

import com.bubah.books.api.repository.BookRepository;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphQLDataFetchers {

    @Autowired
    BookRepository bookRepository;

    public DataFetcher getBookByTitleDataFetcher() {
        return dataFetchingEnvironment -> {
            String title = dataFetchingEnvironment.getArgument("title");
            return bookRepository.getBooks()
                    .stream()
                    .filter(book -> book.getTitle().equals(title))
                    .findFirst()
                    .orElse(null);
        };
    }

}
