package com.xing;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 接口的测试
 * @Author
 * @Date 2019-10-11 15:32
 * @Version 1.0
 */
public class JieKouTest {
    public static void main(String[] args) {
        //JieKou.get();
        List list = new ArrayList<Long>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.forEach(e-> System.out.println(e));

    }
}
