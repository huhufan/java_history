package com.imooc.bm.dao;
import com.imooc.bm.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    void insert(Category category);

    List<Category> getAll();

    Category getCategory(int a);

}
