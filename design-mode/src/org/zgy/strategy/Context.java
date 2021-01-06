package org.zgy.strategy;

public class Context {

    private IStrategy strategy;

    public String calculate(Integer type) {
        strategy = StrategyFactory.getInstance().creator(type);
        return strategy.calculate(type);
    }
}
