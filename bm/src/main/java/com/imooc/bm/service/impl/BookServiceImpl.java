package com.imooc.bm.service.impl;

import com.imooc.bm.dao.BookMapper;
import com.imooc.bm.entity.Book;
import com.imooc.bm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public void add(Book book) {
        bookMapper.insert(book);
    }

    public List<Book> getAll() {

        List<Book> all = bookMapper.getAll();
        System.out.println();
        return all;
    }
}
