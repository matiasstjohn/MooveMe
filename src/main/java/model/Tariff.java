package model;

public class Tariff {
    private Double tripValue = 0.0;
    private AssetI asset;

    public Double getTripValue() {
        return tripValue;
    }

    public void setTripValue(Integer tripValue) {
        this.tripValue += tripValue;
    }
}
