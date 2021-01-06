package org.zgy.接口隔离原则;

/**
 * 接口隔离原则：接口隔离原则主要约束接口，主要针对抽象和程序整体框架的构建。（对比单一职责原则）
 *   1、约束接口、降低类对接口的依赖性；
 *   2、接口隔离原则和单一职责都是为了提高类的内聚性、降低它们之间的耦合性，体现了封装的思想
 */
public class ISPTest {
    public static void main(String[] args) {
        PrintModule printModule = StuScoreList.getPrintModule();
        printModule.printStuInfo();
        printModule.queryStuInfo();
    }
}

// 实现类
class StuScoreList implements InputModule, CountModule, PrintModule {

    private StuScoreList() {
    }

    public static InputModule getInputModule() {
        return (InputModule) new StuScoreList();
    }

    public static CountModule getCountModule() {
        return (CountModule) new StuScoreList();
    }

    public static PrintModule getPrintModule() {
        return (PrintModule) new StuScoreList();
    }

    @Override
    public void insert() {
        System.out.println("输入模块的insert()方法被调用！");
    }

    @Override
    public void delete() {
        System.out.println("输入模块的delete()方法被调用！");
    }

    @Override
    public void modify() {
        System.out.println("输入模块的modify()方法被调用！");
    }

    @Override
    public void countTotalScore() {
        System.out.println("统计模块的countTotalScore()方法被调用！");
    }

    @Override
    public void countAverage() {
        System.out.println("统计模块的countAverage()方法被调用！");
    }

    @Override
    public void printStuInfo() {
        System.out.println("打印模块的printStuInfo()方法被调用！");
    }

    @Override
    public void queryStuInfo() {
        System.out.println("打印模块的queryStuInfo()方法被调用！");
    }
}

// 输入模块
interface InputModule {
    void insert();
    void delete();
    void modify();
}

// 统计模块
interface CountModule {
    void countTotalScore();
    void countAverage();
}

// 打印模块
interface PrintModule {
    void printStuInfo();
    void queryStuInfo();
}

