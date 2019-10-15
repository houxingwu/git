package com.hou;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

public class DataConvert {

    private DataConvert() {
    }

    /**
     * 多个对象进行合并和聚合操作
     *
     * @param source 要进行 合并和聚合的对象
     * @param clazz  聚合结果类(对象)
     * @return 返回 聚合对象
     */
    public static <T> T assembler(Object[] source, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        T t = clazz.newInstance();
        for (Object s : source) {
            DataConvert.mergeNotNull(s, t);
        }
        return t;
    }

    /**
     * 多个对象进行合并和聚合操作
     *
     * @param source 要进行 合并和聚合的对象
     * @param target 聚合对象
     */
    public static void assembler(Object[] source, Object target) {
        for (Object s : source) {
            DataConvert.mergeNotNull(s, target);
        }
    }


    /**
     * Data To Object
     *
     * @param source the source bean
     * @param clazz  the target bean
     */
    public static <T> T mapping(Object source, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        if (Objects.nonNull(source)) BeanUtils.copyProperties(source, t);
        return t;
    }

    /**
     * Data To Object
     *
     * @param source the source bean
     * @param target the target bean
     */
    public static void mapping(Object source, Object target) {
        if (Objects.nonNull(source) && Objects.nonNull(target)) BeanUtils.copyProperties(source, target);
    }


    /**
     * 多个结果映射
     *
     * @param sourceList       映射原对象数组
     * @param destinationClass 映射目标结果类(对象)
     */
    public static <T> List<T> mappingList(Iterable<Object> sourceList, Class<T> destinationClass) throws InstantiationException, IllegalAccessException {
        List<T> destinationList = new ArrayList<>();
        for (Object source : sourceList) {
            destinationList.add(mapping(source, destinationClass));
        }
        return destinationList;
    }


    /**
     * 合并 将给定源bean的属性值(不为null)覆盖到给定目标bean中,只要属性匹配
     *
     * @param source 源bean
     * @param target 目标bean
     */
    public static void mergeNotNull(Object source, Object target) {
        if (Objects.nonNull(source) && Objects.nonNull(target)) {
            BeanWrapper wrapper = new BeanWrapperImpl(source);
            PropertyDescriptor[] pds = wrapper.getPropertyDescriptors();
            Set<String> properties = new HashSet<>();
            for (PropertyDescriptor propertyDescriptor : pds) {
                String propertyName = propertyDescriptor.getName();
                Object propertyValue = wrapper.getPropertyValue(propertyName);
                if (StringUtils.isEmpty(propertyValue)) {
                    wrapper.setPropertyValue(propertyName, null);
                    properties.add(propertyName);
                }
            }
            BeanUtils.copyProperties(source, target, properties.toArray(new String[0]));
        }
    }

    /**
     * 合并(基于反射) 将给定源bean的属性值(不为null)覆盖到给定目标bean中,只要属性匹配
     *
     * @param source 源bean
     * @param target 目标bean
     */
    public static void mergeNotNullReflect(Object source, Object target) {
        if (Objects.nonNull(source) && Objects.nonNull(target)) {
            Class oldClass = source.getClass();
            Class newClass = target.getClass();
            convert(oldClass, newClass, source, target);
        }

    }

    public static<T> T mergeNotNullReflect(Object source, Class<T> targetClazz) {
        if (Objects.nonNull(source)) {
            Class oldClass = source.getClass();
            try {
                T target = targetClazz.newInstance();
                Class newClass = target.getClass();
                convert(oldClass, newClass, source, target);
                return target;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static void convert(Class oldClass, Class newClass, Object source, Object target) {
        Field[] oldFields = oldClass.getDeclaredFields();
        Arrays.stream(oldFields).filter(field -> {
                    field.setAccessible(true);
                    try {
                        return Objects.nonNull(field.get(source));
                    } catch (IllegalAccessException e) {
                        return Boolean.FALSE;
                    }
                }
        ).forEach(field -> {
            try {
                Field newField = newClass.getDeclaredField(field.getName());
                if (Objects.nonNull(newField)) {
                    newField.setAccessible(true);
                    newField.set(target, field.get(source));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e){

            }
        });
    }
}