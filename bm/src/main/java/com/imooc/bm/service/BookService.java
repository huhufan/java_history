package com.imooc.bm.service;

import com.imooc.bm.entity.Book;

import java.util.List;

public interface BookService {
    void add(Book book);
    List<Book> getAll();
}
