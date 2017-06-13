package com.me.bookstore;

/**
 * Created by kiddynamo on 5/10/17.
 */
public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public Book() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
