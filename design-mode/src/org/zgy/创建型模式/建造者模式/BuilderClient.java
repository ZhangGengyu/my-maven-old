package org.zgy.创建型模式.建造者模式;

public class BuilderClient {
    public static void main(String[] args) {
        ConcreteBuilder1 builder = new ConcreteBuilder1();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}

/**
 * 产品
 */
class Product {
    private String partA;
    private String partB;
    private String partC;
    public void setPartA(String partA) {
        this.partA = partA;
    }
    public void setPartB(String partB) {
        this.partB = partB;
    }
    public void setPartC(String partC) {
        this.partC = partC;
    }
    public void show() {
        System.out.println("Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}');
    }
}

/**
 * 抽象建造者
 */
abstract class Builder {
    protected Product product = new Product();
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    public Product getResult() {
        return product;
    }
}

/**
 * 具体建造者1
 */
class ConcreteBuilder1 extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("构建partA");
    }
    @Override
    public void buildPartB() {
        product.setPartB("构建partB");
    }
    @Override
    public void buildPartC() {
        product.setPartC("构建partC");
    }
}

/**
 * 指挥者
 */
class Director {
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
