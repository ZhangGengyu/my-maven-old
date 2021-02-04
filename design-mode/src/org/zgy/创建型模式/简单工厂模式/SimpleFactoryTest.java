package org.zgy.创建型模式.简单工厂模式;


public class SimpleFactoryTest {
    public static void main(String[] args) {
        Product productA = SimpleFactory.makeProduct(Const.A);
        Product productB = SimpleFactory.makeProduct(Const.B);
        System.out.println("A:" + productA.getClass());
        System.out.println("B:" + productB.getClass());
    }
}

/**
 * 简单工厂
 */
class SimpleFactory {
    public static Product makeProduct(Const kind) {
        switch (kind) {
            case A:
                return new ConcreteProductA();
            case B:
                return new ConcreteProductB();
            default:
                return null;
        }
    }
}

/**
 * 抽象产品（父类引用）
 */
interface Product {
    void show();
}

/**
 * 具体产品 A（子类对象）
 */
class ConcreteProductA implements Product {
    @Override
    public void show() {
        System.out.println("====>>ConcreteProductA被创建<<====");
    }
}

/**
 * 具体产品 B（子类对象）
 */
class ConcreteProductB implements Product {
    @Override
    public void show() {
        System.out.println("====>>ConcreteProductB被创建<<====");
    }
}

enum Const {
    A, B
}
