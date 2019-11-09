package com.imooc.cart.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalCache {
    private static Map<Long, Product> productMap = new HashMap<>();
    private static Map<Long, Cart> cartMap = new HashMap<>();
    private static Map<Long, Product> favoriteMap = new HashMap<>();

    static {
        productMap.put(1L, new Product(1L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(2L, new Product(2L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(3L, new Product(3L, "HTML/CSS", "java基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(4L, new Product(4L, "HTML/CSS", "java基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(5L, new Product(5L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(6L, new Product(6L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(7L, new Product(7L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(8L, new Product(8L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(9L, new Product(9L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(10L, new Product(10L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(11L, new Product(11L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(12L, new Product(12L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(13L, new Product(13L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(14L, new Product(14L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(15L, new Product(15L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(16L, new Product(16L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(17L, new Product(17L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(18L, new Product(18L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(19L, new Product(19L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(20L, new Product(20L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(21L, new Product(21L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(22L, new Product(22L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));
        productMap.put(23L, new Product(23L, "HTML/CSS", "HTML+CSS基础课程", "学习标签用法和意义", "初级", 219));

    }

    public static List<Product> getProducts() {
        return new ArrayList<Product>(productMap.values());
    }

    public static List<Cart> getCarts() {
        return new ArrayList<Cart>(cartMap.values());
    }

    public static void delCart(long id) {
        cartMap.remove(id);
    }

    public static Product getProduct(long id) {
        return productMap.get(id);
    }

    public static void addCard(Product product) {
        if (!cartMap.containsKey(product.getId())) {
            cartMap.put(product.getId(), new Cart(product.getId(), product.getId(), product.getName(), product.getPrice(), 1));
        } else {
            incrCart(product.getId());
        }

    }

    public static Cart getCart(Long id) {
        return cartMap.get(id);
    }

    public static void incrCart(Long productId) {
        cartMap.get(productId).incrCount();
    }

    public static void decrCart(Long productId) {
        boolean result = cartMap.get(productId).decrCount();
        if (result == false) {
            cartMap.remove(productId);
        }
    }

    public static List<Product> getFavorites() {
        return new ArrayList<Product>(favoriteMap.values());
    }

    public static void delFavorite(Long id) {
        favoriteMap.remove(id);
    }

    public static void addFavorite(Long id) {
        favoriteMap.put(id, getProduct(id));
    }

    public static List getProducts(int page, int size) {
        List<Product> products = new ArrayList<>(productMap.values());
        int start = (page - 1) * size;
        int end = page * size > products.size() ? products.size() : page * size;
        return new ArrayList(products.subList(start, end));
    }

    public static List getProducts(int page, int size, String name) {
        List<Product> products = new ArrayList<>();
        if (name != null && !"".equals(name)) {
            productMap.values().forEach(product -> {
                if (product.getName().contains(name)) {
                    products.add(product);
                }
            });
        } else {
            products.addAll(productMap.values());
        }
        int start = (page - 1) * size;
        int end = page * size > products.size() ? products.size() : page * size;
        return new ArrayList(products.subList(start, end));
    }

    public static int getProductsCount(String name) {
        List<Product> products = new ArrayList<>();
        if (name != null && !"".equals(name)) {
            productMap.values().forEach(product -> {
                if (product.getName().contains(name)) {
                    products.add(product);
                }
            });
        } else {
            products.addAll(productMap.values());
        }
        return products.size();

    }
}
