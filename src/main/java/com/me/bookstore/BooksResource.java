package com.me.bookstore;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kiddynamo on 5/10/17.
 */
@RestController
public class BooksResource {

    private static int numberOfBooks;

    public static void setNumberOfBooks(int numberOfBooks) {
        BooksResource.numberOfBooks = numberOfBooks;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Integer books() {
        return BooksResource.numberOfBooks;
    }

    public void addBook() {
        BooksResource.numberOfBooks++;
    }
}
