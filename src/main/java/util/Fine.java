package util;

import model.Zone;

public class Fine {

    private Zone zone;
    private Integer fineValue;

    public Fine(Zone zone, int basePrice){
        this.zone = zone;
        this.fineValue = 0;
        fineValue += basePrice * zone.getRate();
    }

    public Integer getFineValue() {
        return fineValue;
    }

    public Zone getZone() {
        return zone;
    }

    public boolean equals(Fine fine) {
        return this.getZone().equals(fine.getZone()) && this.getFineValue().equals(fine.getFineValue());
    }
}
