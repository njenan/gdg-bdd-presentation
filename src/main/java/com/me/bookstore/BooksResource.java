package com.me.bookstore;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by kiddynamo on 5/10/17.
 */
@RestController
public class BooksResource {
    private static Map<String, Book> books = new HashMap<>();

    public void setNumberOfBooks(int numberOfBooks) {
        for (Integer i = 0; i < numberOfBooks; i++) {
            String name = ((Integer) i.hashCode()).toString();
            this.books.put(name, new Book(name));
        }
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Books books() {
        return new Books(books.entrySet().stream().map(Map.Entry<String, Book>::getValue).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book) {
        if (this.books.containsKey(book.getName())) {
            throw new BookNameConflictException();
        }

        this.books.put(book.getName(), book);

        return book;
    }

    public void removeBook(Book book) {
        books.remove(book.getName());
    }

    public void clear() {
        this.books = new HashMap<>();
    }
}
