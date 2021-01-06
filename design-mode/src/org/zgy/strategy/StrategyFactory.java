package org.zgy.strategy;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {

    private static StrategyFactory strategyFactory = new StrategyFactory();
    private static Map<Integer, IStrategy> typeMap = new HashMap<>();

    static {
        typeMap.put(PlayTypeEnum.CARD_STRATEGY.getKey(), new CardStrategy());
        typeMap.put(PlayTypeEnum.E_BANK.getKey(), new EBankStrategy());
        typeMap.put(PlayTypeEnum.BUSI_ACCOUNTS.getKey(), new BusiAccountStrategy());
        typeMap.put(PlayTypeEnum.MOBILE.getKey(), new MobileStrategy());
    }

    public IStrategy creator(Integer type) {
        return typeMap.get(type);
    }

    public static StrategyFactory getInstance() {
        return strategyFactory;
    }
}
