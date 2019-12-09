package model;

import util.AssetType;
import util.Entity;
import util.KeyGenerator;
import util.Tariff;

public class Asset implements AssetI, Entity {

    private final Long key;
    private final AssetType assetType;
    private PurchaseLot purchaseLot;
    private Zone zone;
    private Terminal terminal;
    private Tariff tariff;
    private Integer minScore;

    public Asset(Zone zone, AssetType assetType, Terminal terminal, PurchaseLot purchaseLot) {
        this.key = new KeyGenerator().generateKey();
        this.zone = zone;
        this.assetType = assetType;
        this.terminal = terminal;
        this.purchaseLot = purchaseLot;
    }

    @Override
    public Long getKey() {
        return key;
    }

    @Override
    public AssetType getType() {
        return assetType;
    }

    @Override
    public PurchaseLot getLot() {
        return purchaseLot;
    }

    @Override
    public Zone getZone() {
        return zone;
    }

    @Override
    public Terminal getTerminal() {
        return terminal;
    }

    @Override
    public Integer getMinScore() {
        return minScore;
    }

    @Override
    public void setTerminalToHandOver(Terminal terminal) {
        this.terminal = terminal;
    }

    public boolean equals(Asset asset) {
        return this.getZone().equals(asset.getZone()) && this.getType().equals(asset.getType()) && this.getTerminal().equals(asset.getTerminal()) && this.getLot().equals(asset.getLot());
    }
}
