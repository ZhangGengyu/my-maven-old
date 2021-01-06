package org.zgy.迪米特法则;

/**
 * 迪米特法则：
 *     只与你的直接朋友交谈，不跟“陌生人”说话（Talk only to your immediate friends and not to strangers）。
 *     其含义是：如果两个软件实体无须直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用。
 *     其目的是降低类之间的耦合度，提高模块的相对独立性。
 */
public class LKPTest {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setStart(new Star("谭晶"));
        agent.setCompany(new Company("天娱传媒"));
        agent.business();
    }
}

// 明星
class Star {
    private String name;
    public Star(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name = name;
    }
}

// 经纪人
class Agent {
    private Star star;
    private Fans fans;
    private Company company;
    public void setStart(Star myStar) {
        this.star = myStar;
    }
    public void setFans(Fans myFans) {
        this.fans = myFans;
    }
    public void setCompany(Company myCompany) {
        this.company = myCompany;
    }
    public void meeting() {
        System.out.println(fans.getName() + "与明星" + star.getName() + "见面了");
    }
    public void business() {
        System.out.println(company.getName() + "与明星" + star.getName() + "洽谈业务");
    }
}

// 粉丝
class Fans {
    private String name;
    public Fans(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

// 媒体公司
class Company {
    private String name;
    public Company(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
