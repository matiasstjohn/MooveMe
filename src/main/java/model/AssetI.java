package model;

import util.KeyGenerator;

public interface AssetI {
    KeyGenerator getKey();
    Integer getMinScore();
    Zone getZone();
    String getType();
    Discount getDiscount();
    PurchaseLot getLot();
    Tariff getTariff();
    void setPurchaseLot(PurchaseLot lot);
}
