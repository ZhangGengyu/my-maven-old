package org.zgy.原则.依赖倒置原则;

/**
 * 依赖倒置原则：
 *    要面向接口编程，不要面向实现编程。
 */
public class DIPTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.shopping(new ShaoguanShop());
    }
}

// 商店
interface Shop {
    String sell();
}

// 韶关网店
class ShaoguanShop implements Shop {
    @Override
    public String sell() {
        return "韶关土特产：香菇、木耳……";
    }
}

// 婺源网店
class WuyuanShop implements Shop {
    @Override
    public String sell() {
        return "婺源土特产：绿茶、酒糟鱼……";
    }
}

// 顾客
class Customer {
    public void shopping (Shop shop) {
        System.out.println(shop.sell());
    }
}

