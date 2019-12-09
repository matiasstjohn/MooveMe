package model;

import util.AssetType;
import util.Entity;
import util.KeyGenerator;

public class Discount implements Entity {

    private final Long key;
    private final AssetType assetType;
    private final Integer minScore;
    private final Zone zone;
    private final int percent;

    public Discount(AssetType assetType, Integer minScore, Zone zone, int percent) {
        this.key = new KeyGenerator().generateKey();
        this.assetType = assetType;
        this.minScore = minScore;
        this.zone = zone;
        this.percent = percent;
    }

    @Override
    public Long getKey() {
        return key;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public Zone getZone() {
        return zone;
    }

    public int getPercent() {
        return percent;
    }

    public boolean equals(Discount discount) {
        return this.getAssetType().equals(discount.getAssetType())
                && this.getMinScore().equals(discount.getMinScore())
                && this.getZone().equals(discount.getZone()) && this.getPercent() == discount.getPercent();
    }
}
