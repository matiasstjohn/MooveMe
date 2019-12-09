package util;

public class AssetType {

    private final String assetType;
    private final Integer scorePerMinute;
    private final Integer pricePerMinute;

    public AssetType(String assetType, Integer scorePerMinute, Integer pricePerMinute) {
        this.assetType = assetType;
        this.scorePerMinute = scorePerMinute;
        this.pricePerMinute = pricePerMinute;
    }

    public String getAssetType() {
        return assetType;
    }

    public Integer getScorePerMinute() {
        return scorePerMinute;
    }

    public Integer getPricePerMinute() {
        return pricePerMinute;
    }

    public boolean equals(AssetType assetType) {
        return this.getAssetType().equals(assetType.getAssetType());
    }
}
