package model;

public class Zone {
    private final String type;
    private final Integer rate;

    public Zone(String type, Integer rate) {
        this.type = type;
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public Integer getRate() {
        return rate;
    }
}
