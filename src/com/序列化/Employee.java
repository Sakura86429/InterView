package com.序列化;

import java.io.Serializable;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/14 14:14
 */
public class Employee implements Serializable {
    public String name;
    public String address;
    public transient int SSN;   //其实这个关键字的作用很好理解：将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会被序列化。
    public int number;
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }

    public static void main(String[] args) {

    }
}
