package model;

import util.KeyGenerator;

public class Asset implements AssetI {

    private final KeyGenerator key;
    private Tariff tariff;
    private Integer minScore;
    private final Zone zone;
    private final String assetType;
    private Discount discount;
    private PurchaseLot purchaseLot;

    public Asset(KeyGenerator key, Zone zone, String assetType) {
        this.key = key;
        this.zone = zone;
        this.assetType = assetType;
    }

    @Override
    public KeyGenerator getKey() {
        return key;
    }

    @Override
    public Integer getMinScore() {
        return minScore;
    }

    @Override
    public Zone getZone() {
        return zone;
    }

    @Override
    public String getType() {
        return assetType;
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    @Override
    public PurchaseLot getLot() {
        return purchaseLot;
    }

    @Override
    public Tariff getTariff() { return tariff; }

    @Override
    public void setPurchaseLot(PurchaseLot purchaseLot) {
        this.purchaseLot = purchaseLot;
    }
}
