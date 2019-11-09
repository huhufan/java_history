package com.imooc.utils;

import java.util.*;

public class FoodDaoImpl {
    private static  List<Map<String,Food>> db=new ArrayList<>();
    //添加菜品
    public static void addFood(Map<String, Food> foodMap){
        db.add(foodMap);

    }
    //查询所有菜品信息
    public static List<Map<String, Food>> getAllFood(){
        return db;
    }
    //根据菜品名称查询菜品信息
    public static List<Map<String,Food>> getFoodByName(String foodName){
        for (Map<String,Food> foodMap:db){
            for (Food food:foodMap.values()){
                if (foodName!=null&&foodName.equals(food.getFoodName())){
                    Map<String,Food> map1=new HashMap();
                    List<Map<String,Food>> list1=new ArrayList();
                        map1.put(food.getId(),food);
                        list1.add(map1);
                        return list1;
                    }
                }
            }
        return new ArrayList<>();
        }
    public static Food getFoodById(String id) {
        for (Map<String, Food> foodMap : db) {
            for (Food food : foodMap.values()) {
                if (id != null && id.equals(food.getId())) {
                    return food;
                }
            }
        }
        return null;
    }

    //菜品修改
        public static void updateFood(Map<String, Food> foodMap) {
            for (Food food :foodMap.values()) {
                deleteFoodById(food.getId());
            }
             addFood(foodMap);
        }
        //根据菜品ID进行删除
        public static boolean deleteFoodById (String id){
        Iterator<Map<String, Food>> it=db.iterator();
             while(it.hasNext()){
                 Map<String,Food> map=it.next();
                 if (map.containsKey(id)){
                     it.remove();
                     return true;
                 }
             }
             return false;
                }
            }


