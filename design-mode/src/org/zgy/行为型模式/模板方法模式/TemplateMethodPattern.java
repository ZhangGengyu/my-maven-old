package org.zgy.行为型模式.模板方法模式;

public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass ac = new ConcreteClass();
        ac.templateMethod();
    }
}

abstract class AbstractClass {
    // 模板方法
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }
    // 具体方法
    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用");
    }
    protected abstract void abstractMethod1();
    protected abstract void abstractMethod2();
}

class ConcreteClass extends AbstractClass {
    @Override
    protected void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用");
    }
    @Override
    protected void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用");
    }
}


