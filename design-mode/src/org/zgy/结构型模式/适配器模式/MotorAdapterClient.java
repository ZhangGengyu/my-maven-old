package org.zgy.结构型模式.适配器模式;

import org.zgy.util.ReadXML;

public class MotorAdapterClient {
    public static void main(String[] args) {
        ReadXML.getObject();
    }
}

interface Motor {
    void drive();
}

/**
 * 适配者1
 */
class ElectricMotor {
    public void electricDrive() {

    }
}

/**
 * 适配器1
 */
class ElectricAdapter implements Motor {
    private ElectricMotor emotor;
    public ElectricAdapter electricAdapter() {
        return null;
    }
    @Override
    public void drive() {

    }
}


