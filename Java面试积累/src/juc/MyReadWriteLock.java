package juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyData{
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    volatile Map<String,Object> map = new HashMap<>();

    public void put(String key,Object value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入： "+key);
            //TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.writeLock().unlock();
        }
    }
    public void get(String key){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在读取： ");
            //TimeUnit.MILLISECONDS.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成： "+result);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.writeLock().lock();
        }

    }
}

public class MyReadWriteLock {
    public static void main(String[] args) {
        MyData data = new MyData();
        for (int i = 0; i <=5; i++) {
            final int te = i;
            new Thread(()->{
                data.put(te+"",te+"");
            },String.valueOf(i)).start();
        }
        for (int i = 0; i <=5; i++) {
            final int te = i;
            new Thread(()->{
                data.get(te+"");
            },String.valueOf(i)).start();
        }



    }


}
