package org.zgy.原则.里氏替换原则;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 里氏替换原则：它反映了基类与子类之间的关系，是对开闭原则的补充，是对实现抽象化的具体步骤的规范。
 *      子类可以扩展父类的功能，但不能改变父类原有的功能。
 *      也就是说：子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。
 */
public class LSPtest {
    public static void main(String[] args) {
        Bird a1 = new Swallow();
        Animal a2 = new BrownKiwi();
        a1.setRunSpeed(20);
        a2.setRunSpeed(40);
        System.out.println("如果行驶300公里：");
        try {
            Map map = new HashMap();
            Iterator iterator = map.entrySet().iterator();
            System.out.println("燕子将花费" + a1.getRunTime(300) + "小时.");
            System.out.println("几维鸟将花费" + a2.getRunTime(300) + "小时。");
        } catch (Exception err) {
            System.out.println("发生错误了!");
        }
    }
}
// 动物类
class Animal {
    protected double runSpeed;
    public void setRunSpeed(double speed) {
        this.runSpeed = speed;
    }
    public double getRunTime(double distance) {
        return runSpeed / distance;
    }
}
//鸟类
class Bird extends Animal {
    protected double flySpeed;
    public void setFlySpeed(double speed) {
        flySpeed = speed;
    }
    public double getFlyTime(double distance) {
        return (distance / flySpeed);
    }
}
//燕子类
class Swallow extends Bird {
}
//几维鸟类
class BrownKiwi extends Animal {
}
