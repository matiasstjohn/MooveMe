package model;

import util.Entity;
import util.KeyGenerator;
import java.util.ArrayList;
import java.util.List;

public class Terminal implements Entity {

    private List<Asset> assets;
    private final Long key;
    private final Zone zone;
    private final String name;

    public Terminal(Zone zone, String name) {
        this.key = new KeyGenerator().generateKey();
        this.zone = zone;
        this.name = name;
        this.assets = new ArrayList<>();
    }

    @Override
    public Long getKey() {
        return key;
    }

    public Zone showZone() {
        return zone;
    }

    public String getName() {
        return name;
    }

    public void receive(Asset asset) {
        assets.add(asset);
    }

    public List<Asset> getAssets() {
        return assets;
    }


    public boolean equals(Terminal terminal){
        return getName().equals(terminal.getName()) && this.showZone().equals(terminal.showZone());
    }
}
