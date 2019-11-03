package model;

import util.KeyGenerator;

import java.util.List;

public class PurchaseLot {
    private List<AssetI> assets;
    private final KeyGenerator key;
    private final Zone zone;
    private final String assetType;

    public PurchaseLot(KeyGenerator key, Zone zone, String assetType) {
        this.key = key;
        this.zone = zone;
        this.assetType = assetType;
    }

    public KeyGenerator getKey() {
        return key;
    }

    public Zone getZone() {
        return zone;
    }

    public String getAssetType() {
        return assetType;
    }
}
