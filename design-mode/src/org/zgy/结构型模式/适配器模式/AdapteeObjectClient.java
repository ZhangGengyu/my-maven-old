package org.zgy.结构型模式.适配器模式;

public class AdapteeObjectClient {
    public static void main(String[] args) {
        System.out.println("对象适配器模式测试：");
        Adapter2 adapter2 = new Adapter2();
        Target2 target2 = new ObjectAdapter(adapter2);
        target2.request();
    }
}

interface Target2 {
    void request();
}

class Adapter2 {
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用");
    }
}

class ObjectAdapter implements Target2 {
    private Adapter2 adapter2;
    public ObjectAdapter(Adapter2 adapter2) {
        this.adapter2 = adapter2;
    }
    @Override
    public void request() {
        adapter2.specificRequest();
    }
}
