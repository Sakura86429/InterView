package com.序列化;
import java.io.*;
/**
 * Topic
 * Description
 * @author zhouh
 * @version 1.0
 * Create by 2022/3/14 14:16
 */
public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        try
        {
            FileOutputStream fileOut =
//                    new FileOutputStream("/employee.obj");
                    new FileOutputStream("employee.ser");   //D盘目录下
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in employee.obj");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}
