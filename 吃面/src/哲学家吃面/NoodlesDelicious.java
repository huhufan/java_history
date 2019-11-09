package 哲学家吃面;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoodlesDelicious {

 static Semaphore[] PV= new Semaphore[5];
 static Semaphore pv4= new Semaphore(4,true);

 public static void main(String[] args) {
  ExecutorService philosopher = Executors.newFixedThreadPool(5);
  for(int i=0 ;i<5;i++) {
   PV[i]=new Semaphore(1,true);	//利用循环创建五个available=1的信号量
  }
  for(int i=0;i<5;i++) {
   philosopher.execute(new Mythread(i));
   //利用循环创建五个进程在进程池中，ActionRunable是继承了Runnable的类
  }
 }
}


class Mythread implements Runnable{
 private int i=0;

 Mythread(int i){
  this.i=i;

 }

 public void run() {
  NoodlesDelicious Noodles =new NoodlesDelicious();
  synchronized(this) {

   try {
    if(i!=4)
     this.wait(1000);	//线程开启后，先加入阻塞队列
    else
     this.wait(1000);//线程开启后，先加入阻塞队列
    notifyAll();
					/*上面阻塞的时间是一秒，一秒之内，线程看到全部开启了，
					 然后notifyAll()唤醒所有，实现多线程同时并发*/
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
  }
  while(!Thread.interrupted()) {
   try {
    Noodles.pv4.acquire();
    Noodles.PV[i].acquire();			//左边叉子
    Noodles.PV[(1+i)%5].acquire();		//右边叉子

    System.out.println((i+1)+"号哲学家开始吃面");

    Noodles.PV[i].release();			//放下左边叉子
    Noodles.pv4.release();
    Noodles.PV[(i+1)%5].release();		//放下右边叉子
    System.out.println((i+1)+"号哲学家吃饱了，开始思考");
    Thread.yield();
    //Thread.sleep(10);
    /*Java线程中的Thread.yield( )方法，译为线程让步。顾名思义，就是说当一个线程使用了这个方法之后，它就会把自己CPU执行的时间让掉，让自己或者其它的线程运行，注意是让自己或者其他线程运行，并不是单纯的让给其他线程。*/
   }
   catch(InterruptedException e){
    e.printStackTrace();
   }
  }
 }
}

