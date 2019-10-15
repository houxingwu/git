package com.xing;

import com.google.common.base.Function;
import com.google.common.base.Supplier;

import javax.sound.midi.Soundbank;

/**
 * @Description
 * @Author
 * @Date 2019-10-11 16:12
 * @Version 1.0
 */
public class PersonTest {
    public static void main(String[] args) {
        /*String str = "abcde";
        PersonFactory personFactory = new PersonFactory() {
            @Override
            public Person creatPerson(String name, String age) {
                return new Person(name, age);
            }
        };

        Function<String, Boolean> function = new Function<String, Boolean>() {
            @Override
            public Boolean apply(String s) {

                return str.endsWith(s);
            }
        };
        Boolean aaaa = function.apply("aaaa");
        System.out.println(aaaa);
        Person ss = personFactory.creatPerson("33", "ss");

        PersonFactory personFactory1 = Person::new;
        Person person = personFactory1.creatPerson("1", "2");*/
        Function<String, String> get = PersonTest::get;
        System.out.println(get.apply("name hahah"));
    }


    private static String get(String name){
        return name;
    }
}
