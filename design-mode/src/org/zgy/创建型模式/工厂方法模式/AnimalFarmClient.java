package org.zgy.创建型模式.工厂方法模式;

public class AnimalFarmClient {
    public static void main(String[] args) {
        AnimalFarm af;
        Animal a;
        af = (AnimalFarm) ReadXML.getObject();
        a = af.newAnimal();
        a.show();
    }
}

/**
 * 抽象产品
 */
interface Animal {
    void show();
}

/**
 * 具体产品：马
 */
class Horse implements Animal {
    @Override
    public void show() {
        System.out.println("马");
    }
}

/**
 * 具体产品：牛
 */
class Cattle implements Animal {
    @Override
    public void show() {
        System.out.println("牛");
    }
}

/**
 * 抽象工厂
 */
interface AnimalFarm {
    Animal newAnimal();
}

/**
 * 具体工厂：养马场
 */
class HorseFarm implements AnimalFarm {
    @Override
    public Animal newAnimal() {
        System.out.println("养马场被创建");
        return new Horse();
    }
}

/**
 * 具体工厂：养牛场
 */
class CattleFarm implements AnimalFarm {
    @Override
    public Animal newAnimal() {
        System.out.println("养牛场被创建");
        return new Cattle();
    }
}
