package org.zgy.strategy;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        String calculate = context.calculate(4);
        System.out.println(calculate);
    }
}
