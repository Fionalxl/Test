package lxl.ThreadTest;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lanxiaoli on 2020/1/6.
 * 多线程三个不同的线程将会共用一个 Foo 实例。
 线程 A 将会调用 one() 方法
 线程 B 将会调用 two() 方法
 线程 C 将会调用 three() 方法
 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        Foo f = new Foo();

        Thread t1 = new Thread(() -> {
            f.one(() -> {
                System.out.println("One");
            });
        });
        Thread t2 = new Thread(() -> {
            try {
                f.two(() -> {
                    System.out.println("Two");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                f.three(() -> {
                    System.out.println("Three");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t1.start();
        t3.start();
    }
}

class Foo {
   private CountDownLatch l1;
   private CountDownLatch l2;

   public Foo() {
       l1 = new CountDownLatch(1);
       l2 = new CountDownLatch(1);
   }

   public void one(Runnable runnable) {
       runnable.run();
       l1.countDown();
   }

   public void two(Runnable runnable) throws InterruptedException {
       l1.await();
       runnable.run();
       l2.countDown();
   }

   public void three(Runnable runnable) throws InterruptedException {
       l2.await();
       runnable.run();
   }
}