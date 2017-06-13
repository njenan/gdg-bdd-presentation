package com.me.bookstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiddynamo on 5/10/17.
 */
public class Books extends ArrayList<Book> {
    public Books() {
        
    }
    
    public Books(List<Book> collect) {
        super(collect);
    }
}
