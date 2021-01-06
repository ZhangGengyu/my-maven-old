package org.zgy.strategy;

/**
 * 支付类型
 */
public enum PlayTypeEnum {
    //
    CARD_STRATEGY(1, "充值卡"),
    E_BANK(2, "网银"),
    BUSI_ACCOUNTS(3, "商户账号"),
    MOBILE(4, "手机卡充值");

    private Integer key;
    private String value;

    PlayTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
