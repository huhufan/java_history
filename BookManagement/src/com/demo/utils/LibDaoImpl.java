package com.demo.utils;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibDaoImpl {
    /**
     * 类型描述：能够描述用户表、图书分类和图书表等
     * 用户表：private static final List<User> userDb
     * 图书分类：private static final List<Map<String, Object>>
     * 图书表：private static final List<Book> books
     * 注意：此处图书分类并没有单独定义一个类，而是把分类的id、名称、描述存放到了Map中，然后把每个分类，
     * 也就是一个HashMap的对象存储到List
     * 此处的List建议使用ArrayList，Map建议使用HashMap
     * 方法：
     * 用户注册：public void regist(User user) {}
     * 用户登录: public int login(String username, String password) {}.
     * 判断指定的用户名在数据库是否存在: public int isUserExist(String username) {}
     * 添加图书分类：public void addBookCatgory(Long id, String catgoryName, String description) {}
     * 根据条件来查询书籍信息：public List<Book> getBooksByCondition(String bookID, String bookName, String catgoryName) {}
     */
    private static final List<User> userDb = new ArrayList<>();
    private static final List<Map<String, Object>> bookClassDb = new ArrayList<>();
    private static final List<Book> books = new ArrayList<>();

    public static List<User> getUserDb() {
        return userDb;
    }

    public static List<Map<String, Object>> getBookClassDb() {
        return bookClassDb;
    }

    public static List<Book> getBooks() {
        return books;
    }

    public void regist(User user) {
        userDb.add(user);
        }
    public int login(String username, String password) {
        for (User user : userDb) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return 1;
            }
        }
        return 0;
    }
    public int isUserExist(String username) {
        for (User user : userDb) {
            if (user.getUsername().equals(username)){
                return 1;
            }
        }
        return 0;
    }
    public void addBookCatgory(Long id, String bookClass, String des) {
        Map map = new HashMap();
        map.put("id",id);
        map.put("bookClass",bookClass);
        map.put("des",des);
        bookClassDb.add(map);
    }
    public List<Book> getBooksByCondition(String bookID, String bookName, String catgoryName) {
        List<Book> list = new ArrayList();
        for (Book book:books){
           if( book.getBookClass()!=null){
            if (book.getBookId().contains(bookID) && book.getBookName().contains(bookName) && book.getBookClass().contains(catgoryName)) {
                list.add(book);
            }
        }else{
               if (book.getBookId().contains(bookID) && book.getBookName().contains(bookName)) {
                   list.add(book);
               }
           }
        }
        return list;
    }
    public void addBook(Book book){
        books.add(book);
    }
}




