package com.策略模式.Stratrgy;

/**
 * Topic
 * Description 定义具体策略角色（ConcreteStrategy）
 * 定义减法实现类
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/15 22:20
 */
public class operationSub implements operation{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
