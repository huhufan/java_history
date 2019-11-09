package com.demo.utils;

public class Book {
//    图书类Book：
//    类型描述：能够描述图书ID、图书名、图书分类名、价格、描述等
//    方法：构造方法、get和set方法，toString()方法
    private String bookId,bookName,bookClass,price,des;

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookClass='" + bookClass + '\'' +
                ", price='" + price + '\'' +
                ", des='" + des + '\'' +
                '}';
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookClass() {
        return bookClass;
    }

    public void setBookClass(String bookClass) {
        this.bookClass = bookClass;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Book(String bookId, String bookName, String bookClass, String price, String des) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookClass = bookClass;
        this.price = price;
        this.des = des;
    }
}
