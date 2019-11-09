package com.imooc.cart.data;

public class Cart {
    private long id;
    private long productId;
    private  String name;
    private int price;
    private int count;
    private int totalPrice;

    public Cart(long id, long productId, String name, int price, int count) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.count = count;
        this.totalPrice=price*count;
    }
    public void incrCount(){
        count++;
        this.totalPrice=price*count;
    }
    public boolean decrCount(){
        count--;
        if (count!=0){
            this.totalPrice=price*count;
            return true;
        }else {
            return false;
        }


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
