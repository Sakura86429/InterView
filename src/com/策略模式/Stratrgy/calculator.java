package com.策略模式.Stratrgy;

/**
 * Topic
 * Description 定义环境角色（Context）
 * 计算器类，承上启下
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/15 22:21
 */
public class calculator {

//    public calculator(String s) {
//        System.out.println("有参构造器：");
//    }

    //定义一个operation变量
    private operation operation;

    //operation变量的set方法
    public void setOperation(operation op){
        this.operation = op;
    }

    //抛出一个计算方法
    public int doOperation(int num1,int num2){
        return this.operation.doOperation(num1,num2);
    }

    //测试使用
    public static void main (String[] args) {
        calculator calcul = new calculator();

        //做加法
        calcul.setOperation (new operationAdd());
        int result = calcul.doOperation(1,2);
        System.out.println ("result1 = " + result);

        //做减法
        calcul.setOperation (new operationSub ());
        int result2 = calcul.doOperation (1,2);
        System.out.println ("result2 = " + result2);
    }

}
