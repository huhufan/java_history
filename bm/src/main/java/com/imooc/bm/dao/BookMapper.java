package com.imooc.bm.dao;

import com.imooc.bm.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    void insert(Book book);

    List<Book> getAll();
}
