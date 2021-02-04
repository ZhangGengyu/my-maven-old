package org.zgy.结构型模式.桥接模式;

public class BagManage {
    public static void main(String[] args) {
        Color color = new Gray();
        Bag bag = new HandBag();
        bag.setColor(color);
        bag.getName();
    }
}

interface Color {
    String getColor();
}

class Gray implements Color {
    @Override
    public String getColor() {
        return "灰色";
    }
}

abstract class Bag {
    protected Color color;
    public void setColor(Color color) {
        this.color = color;
    }
    public abstract void getName();
}

class HandBag extends Bag {
    @Override
    public void getName() {
        System.out.println(color.getColor() + "挎包");
    }
}


