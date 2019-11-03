package model;

public class Discount {
    private final String assetType;
    private final Integer minScore;
    private final Zone zone;
    private final int percent;

    public Discount(String assetType, Integer minScore, Zone zone, int percent) {
        this.assetType = assetType; // asset.getAssetType();
        this.minScore = minScore;
        this.zone = zone;
        this.percent = percent;
    }

    public String getAssetType() {
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
}
