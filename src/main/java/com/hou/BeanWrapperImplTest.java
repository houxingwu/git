package com.hou;

import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;

/**
 * @Description Spring 的类测试
 * @Author
 * @Date 2019-09-26 10:32
 * @Version 1.0
 */
public class BeanWrapperImplTest {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(13);
        user.setName("小明");
        BeanWrapperImpl wrapper = new BeanWrapperImpl(user);
        PropertyDescriptor[] propertyDescriptors = wrapper.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor+">>>>>>>>>>");
            System.out.println(propertyDescriptor.getName()+"------------------------");
            System.out.println(wrapper.getPropertyValue(propertyDescriptor.getName()));
        }
    }


}
