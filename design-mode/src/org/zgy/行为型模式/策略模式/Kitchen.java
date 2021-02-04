package org.zgy.行为型模式.策略模式;

import java.util.HashMap;
import java.util.Map;

public class Kitchen {
    static Map<String, CrabCooking> map;
    static {
        map = new HashMap<>();
        map.put("braised", new BraisedCrabs());
        map.put("steamed", new SteamedCrabs());
    }
    public static void main(String[] args) {
        Context context = new Context();
        context.setCrabCooking(map.get("steamed"));
        context.strategyMethod();
    }
}

interface CrabCooking {
    void cookingMethod();
}

class SteamedCrabs implements CrabCooking {
    @Override
    public void cookingMethod() {
        System.out.println("清蒸大闸蟹");
    }
}

class BraisedCrabs implements CrabCooking {
    @Override
    public void cookingMethod() {
        System.out.println("红烧大闸蟹");
    }
}

class Context {
    private CrabCooking crabCooking;
    public void setCrabCooking(CrabCooking crabCooking) {
        this.crabCooking = crabCooking;
    }
    public CrabCooking getCrabCooking() {
        return crabCooking;
    }
    public void strategyMethod() {
        crabCooking.cookingMethod();
    }
}



