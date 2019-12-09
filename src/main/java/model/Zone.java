package model;

import util.Entity;
import util.KeyGenerator;

public class Zone implements Entity {
    private final Long key;
    private final String type;
    private final Integer rate;

    public Zone(String type, Integer rate) {
        this.key = new KeyGenerator().generateKey();
        this.type = type;
        this.rate = rate;
    }

    @Override
    public Long getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public Integer getRate() {
        return rate;
    }

    public boolean equals(Zone zone) {
        return this.getType().equals(zone.getType());
    }
}
