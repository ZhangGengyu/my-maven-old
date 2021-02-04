package org.zgy.结构型模式.桥接模式;

public class BridgeClient {
    public static void main(String[] args) {
        Implementor imple = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(imple);
        abs.operation();
    }
}

/**
 * 实现化（Implementor）角色：
 *      定义实现化角色的接口，供扩展抽象化角色调用。
 */
interface Implementor {
    void operationImpl();
}

/**
 * 具体实现化角色
 */
class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("具体实现化(Concrete Implementor)角色被访问");
    }
}

/**
 * 抽象化角色：
 *      定义抽象类，并包含一个对实现化对象的引用。
 */
abstract class Abstraction {
    protected Implementor implementor;
    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    public abstract void operation();
}

/**
 * 扩展抽象化角色：
 *      抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 */
class RefinedAbstraction extends Abstraction {
    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }
    @Override
    public void operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        implementor.operationImpl();
    }
}


