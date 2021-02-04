package org.zgy.创建型模式.原型模式;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 用一个已经创建的实例作为原型，
 * 通过复制该原型对象来创建一个和原型相同或相似的新对象。
 */
public class ProtoTypeManagerTest {
    public static void main(String[] args) {
        ProtoTypeManager manager = new ProtoTypeManager();
        manager.addShape("circle", new Circle());
        Shape circle = manager.getShape("circle");
        circle.countArea();
    }
}

class ProtoTypeManager {
    private Map<String, Shape> map = new HashMap<>();
    public void addShape(String key, Shape shape) {
        map.put(key, shape);
    }
    public Shape getShape(String key) {
        return map.get(key);
    }
}

interface Shape extends Cloneable {
    Object clone();
    void countArea();
}

class Circle implements Shape {
    @Override
    public Object clone() {
        Circle w = null;
        try {
            w = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return w;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("这是一个圆，请输入圆的半径：");
        Scanner input = new Scanner(System.in);
        r = input.nextInt();
        System.out.println("该圆的面积=" + Math.PI * r * r + "\n");
    }
}

