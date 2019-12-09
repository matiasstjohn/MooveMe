package model;

import util.AssetType;
import util.Entity;
import util.KeyGenerator;

public class PurchaseLot implements Entity {

    private final Long key;
    private final Zone zone;
    private final AssetType assetType;
    private final int lot;

    public PurchaseLot(Zone zone, AssetType assetType, int lot) {
        this.key = new KeyGenerator().generateKey();
        this.assetType = assetType;
        this.zone = zone;
        this.lot = lot;
    }

    @Override
    public Long getKey() {
        return key;
    }

    public Zone getZone() {
        return zone;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public int getLot() {
        return lot;
    }


    public boolean equals(PurchaseLot purchaseLot){
        return this.getZone().equals(purchaseLot.getZone()) &&
                this.getAssetType().equals(purchaseLot.getAssetType()) &&
                (this.getLot() == purchaseLot.getLot());
    }
}
