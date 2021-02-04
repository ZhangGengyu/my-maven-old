package org.zgy.创建型模式.建造者模式;

public class ParlourDecorator {
    public static void main(String[] args) {
        ConcreteDecorator builder = new ConcreteDecorator();
        ProjectManager manager = new ProjectManager(builder);
        Parlour parlour = manager.decorate();
        parlour.show();
    }
}

/**
 * 产品
 */
class Parlour {
    private String wall;
    private String tv;
    private String sofa;
    public void setWall(String wall) {
        this.wall = wall;
    }
    public void setTv(String tv) {
        this.tv = tv;
    }
    public void setSofa(String sofa) {
        this.sofa = sofa;
    }
    public void show() {
        System.out.println(toString());
    }
    @Override
    public String toString() {
        return "Parlour{" +
                "wall='" + wall + '\'' +
                ", tv='" + tv + '\'' +
                ", sofa='" + sofa + '\'' +
                '}';
    }
}

/**
 * 抽象建造者
 */
abstract class Decorator {
    protected Parlour parlour = new Parlour();
    public abstract void buildWall();
    public abstract void buildSofa();
    public abstract void buildTv();
    public Parlour getResult() {
        return parlour;
    }
}

/**
 * 具体装修
 */
class ConcreteDecorator extends Decorator {
    @Override
    public void buildWall() {
        parlour.setWall("大理石墙面");
    }
    @Override
    public void buildSofa() {
        parlour.setSofa("L型沙发");
    }
    @Override
    public void buildTv() {
        parlour.setTv("海信电视");
    }
}

/**
 * 指挥者
 */
class ProjectManager {
    private Decorator decorator;
    public ProjectManager(Decorator builder) {
        this.decorator = builder;
    }
    public Parlour decorate() {
        decorator.buildWall();
        decorator.buildTv();
        return decorator.getResult();
    }
}



