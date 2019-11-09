package com.atguigu.springbootelasticsearch.bean.respository;

import com.atguigu.springbootelasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
}
