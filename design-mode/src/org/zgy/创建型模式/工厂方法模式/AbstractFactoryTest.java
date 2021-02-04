package org.zgy.创建型模式.工厂方法模式;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        Product a;
        AbstractFactory af;
        af = (AbstractFactory) ReadXML.getObject();
        a = af.newProduct();
        a.show();
    }
}

interface Product {
    void show();
}

class ConcreteProduct1 implements Product {
    @Override
    public void show() {
        System.out.println("========>> 具体产品1被创建");
    }
}

class ConcreteProduct2 implements Product {
    @Override
    public void show() {
        System.out.println("========>> 具体产品2被创建");
    }
}

abstract class AbstractFactory {
    protected abstract Product newProduct();
}

class ConcreteFactory1 extends AbstractFactory {
    @Override
    protected Product newProduct() {
        System.out.println("====>> 具体工厂1正在创建具体产品1");
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 extends AbstractFactory {
    @Override
    protected Product newProduct() {
        System.out.println("====>> 具体工厂2正在创建具体产品2");
        return new ConcreteProduct2();
    }
}

class ReadXML {
    public static Object getObject() {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("design-mode/src/org/zgy/工厂方法模式/config/config1.xml"));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = "org.zgy.工厂方法模式." + classNode.getNodeValue();
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