package com.xing;

/**
 * @Description 接口的demo
 * @Author
 * @Date 2019-10-11 15:30
 * @Version 1.0
 *
 * 函数时接口
 * lambda表达式
 */
public interface JieKou {
    static int get(){
        System.out.println("hahaha");
        return 123;
    }
    default int set(){
        //default修饰的方法必须是实现类的对象调用
        return 456;
    }

}
