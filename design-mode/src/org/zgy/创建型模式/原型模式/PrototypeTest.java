package org.zgy.创建型模式.原型模式;

/**
 * 用一个已经创建的实例作为原型，
 * 通过复制该原型对象来创建一个和原型相同或相似的新对象。
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype obj1 = new Realizetype();
        obj1.setVar1("var1");
        obj1.setVar2(222);
        obj1.setVar3(3);
        Realizetype obj2 = (Realizetype) obj1.clone();
        System.out.println("obj1 ==>> " + obj1.toString());
        System.out.println("obj2 ==>> " + obj2.toString());
        System.out.println(obj1 == obj2);
    }
}

/**
 * 具体原型类
 */
class Realizetype implements Cloneable {
    private String var1;
    private Integer var2;
    private int var3;
    Realizetype() {
        System.out.println("具体原型创建成功！");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return super.clone();
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public void setVar2(Integer var2) {
        this.var2 = var2;
    }

    public void setVar3(int var3) {
        this.var3 = var3;
    }

    @Override
    public String toString() {
        return "Realizetype{" +
                "var1='" + var1 + '\'' +
                ", var2=" + var2 +
                ", var3=" + var3 +
                '}';
    }
}

class PrototypeCitation {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation c = new Citation("张三", "同学：评为三好学生", "南庄村幼儿园");
        System.out.println("c --> " + c.toString());
        Citation c1 = c.clone();
        c1.setName("李四");
        System.out.println("c1 --> " + c1.toString());
        Citation c2 = c1.clone();
        c2.setName("王五");
        System.out.println("c2 --> " + c2.toString());
    }
}

class Citation implements Cloneable {
    String name;
    String info;
    String college;
    public Citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("奖状创建成功");
    }
    @Override
    protected Citation clone() throws CloneNotSupportedException {
        System.out.println("拷贝奖状成功");
        return (Citation) super.clone();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    @Override
    public String toString() {
        return "Citation{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", college='" + college + '\'' +
                '}';
    }
}

