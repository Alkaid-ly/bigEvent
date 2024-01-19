package com.itcast;

import org.junit.jupiter.api.Test;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/17 17:46
 * @Version: 1.0
 * @Description:
 */
public class ThreadLocalTest {
    @Test
    public void testThreadLocalSetAndGet(){
//        提供一个ThreadLocal对象
        ThreadLocal tl=new ThreadLocal();
//        开启两个线程
        new Thread(()->{
            tl.set("小蓝");
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
        },"蓝色").start();

        new Thread(()->{
            tl.set("小绿");
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
        },"绿色").start();

    }
}
