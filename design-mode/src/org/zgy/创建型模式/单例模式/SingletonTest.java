package org.zgy.创建型模式.单例模式;

public class SingletonTest {
    public static void main(String[] args) {
        /*President president = President.getInstance();
        president.getName();
        President president1 = President.getInstance();
        president1.getName();
        if (president == president1) {
            System.out.println("同一人！");
        } else {
            System.out.println("不是同一人！");
        }*/
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance == instance1);
    }
}

/**
 * 懒汉式单例
 */
class LazySingleton {
    // 保证 instance在所有线程中同步
    private static volatile LazySingleton instance = null;
    // 避免在外部被实例化
    private LazySingleton() {
    }
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 * 饿汉式单例
 */
class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {
    }
    public static HungrySingleton getInstance() {
        return instance;
    }
}

/**
 * 总统
 */
class President {
    private static volatile President instance = null;
    public void getName() {
        System.out.println("我是美国总统：拜登。");
    }
    private President(){
        System.out.println("产生一个总统！");
    }
    public static synchronized President getInstance() {
        if (instance == null) {
            instance = new President();
        } else {
            System.out.println("已经有一个总统，不能再产生新总统！");
        }
        return instance;
    }
}











