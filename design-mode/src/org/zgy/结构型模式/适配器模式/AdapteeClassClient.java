package org.zgy.结构型模式.适配器模式;

public class AdapteeClassClient {
    public static void main(String[] args) {
        Target adapter = new ClassAdapter();
        adapter.request();
    }
}

/**
 * 目标接口
 */
interface Target {
    void request();
}

/**
 * 适配者
 */
class Adaptee {
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用！");
    }
}

/**
 * 适配器
 */
class ClassAdapter extends Adaptee implements Target {
    private Adaptee adaptee;
    @Override
    public void request() {
        specificRequest();
    }
}

