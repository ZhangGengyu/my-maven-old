package org.zgy.创建型模式.抽象工厂模式;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class AbstractFactoryClient {
    public static void main(String[] args) {
        AbstractFactory af = (AbstractFactory) ReadXML.getObject();
        Product1 p11 = af.newProduct1();
        Product2 p12 = af.newProduct2();
        p11.show1();
        p12.show2();
    }
}

/**
 * 抽象工厂
 */
interface AbstractFactory {
    Product1 newProduct1();
    Product2 newProduct2();
}

/**
 * 具体工厂1
 */
class ConcreteProduct1 implements AbstractFactory {
    @Override
    public Product1 newProduct1() {
        System.out.println("具体工厂1 创建产品 具体产品1");
        return new ConcreteProduct11();
    }
    @Override
    public Product2 newProduct2() {
        System.out.println("具体工厂1 创建产品 具体产品2");
        return new ConcreteProduct12();
    }
}

/**
 * 具体工厂2
 */
class ConcreteProduct2 implements AbstractFactory {
    @Override
    public Product1 newProduct1() {
        System.out.println("具体工厂2 创建产品 具体产品1");
        return new ConcreteProduct21();
    }
    @Override
    public Product2 newProduct2() {
        System.out.println("具体工厂 创建产品 具体产品2");
        return new ConcreteProduct22();
    }
}

/**
 * 抽象产品1
 */
interface Product1 {
    void show1();
}

/**
 * 抽象产品2
 */
interface Product2 {
    void show2();
}

/**
 * 具体产品11
 */
class ConcreteProduct11 implements Product1 {
    @Override
    public void show1() {
        System.out.println("具体产品11");
    }
}

/**
 * 具体产品12
 */
class ConcreteProduct12 implements Product2 {
    @Override
    public void show2() {
        System.out.println("具体产品12");
    }
}

/**
 * 具体产品21
 */
class ConcreteProduct21 implements Product1 {
    @Override
    public void show1() {
        System.out.println("具体产品21");
    }
}

/**
 * 具体产品22
 */
class ConcreteProduct22 implements Product2 {
    @Override
    public void show2() {
        System.out.println("具体产品22");
    }
}

class ReadXML {
    public static Object getObject() {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("design-mode/src/org/zgy/抽象工厂模式/config/config1.xml"));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "org.zgy.抽象工厂模式." + classNode.getNodeValue();
            //System.out.println("新类名："+cName);
            //通过类名生成实例对象并将其返回
            Class<?> c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
