package com.语法基础;

/**
 * Topic
 * Description
 *
 * @author zhouh
 * @version 1.0
 * Create by 2022/8/25 10:59
 */
public class GlobalVariable {
    public static int id;
    public static int name;

    public static int getId() {
        return id;
    }
//    public static void setId(int id) {   //
    public void setId(int id) {   // 非静态方法也可以给静态变量赋值
        GlobalVariable.id = id;
    }
    public static int getName() {
        return name;
    }
    public static void setName(int name) {
        GlobalVariable.name = name;
    }

    public static void main(String[] args) {
        GlobalVariable test1 = new GlobalVariable();
        GlobalVariable test2 = new GlobalVariable();
        test1.setId(1);
        System.out.println(test1.getId());   // 不赋值，int类型的默认为0
        System.out.println(test2.getId());
    }
}
