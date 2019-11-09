package com.atguigu.springbootelasticsearch;

import com.atguigu.springbootelasticsearch.bean.Article;
import com.atguigu.springbootelasticsearch.bean.Book;
import com.atguigu.springbootelasticsearch.bean.respository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticsearchApplicationTests {
    @Autowired
    JestClient jestClient;
    @Autowired
    BookRepository bookRepository;



    @Test
    public void test02(){
        Book book = new Book();
        book.setId(1);
        book.setAuthor("虎虎樊");
        book.setBookName("哈哈哈");
        bookRepository.index(book);
    }
    @Test
    public void contextLoads() {
        Article article = new Article();
        article.setId("1");
        article.setAuthor("哈哈");
        article.setName("哈还昂has发");
        article.setContent("sdada大赛阿飞sad扎堆阿宅");
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void search(){
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"author\" : \"哈哈\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        try {
            SearchResult execute = jestClient.execute(search);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
