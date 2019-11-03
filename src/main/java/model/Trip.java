package model;

import java.util.Date;

public class Trip implements TripI {
    private final Client client;
    private Asset asset;
    private Zone zone;
    private Date tripTime;
    private Discount discount;
    private Terminal toHandOver;
    private Tariff tariff;
    private Integer score;


    public Trip(Client client, Asset asset, Zone zone) {
        this.client = client;
        this.asset = asset;
        this.zone = zone;
    }

    @Override
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public void setToHandOver(Terminal toHandOver) {
        this.toHandOver = toHandOver;
    }

    @Override
    public void setTripTime(Date tripTime) {
        this.tripTime = tripTime;
    }

    @Override
    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @Override
    public void setZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public void setTerminal(Terminal terminal) {
        this.toHandOver = terminal;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public Asset getAsset() {
        return asset;
    }

    @Override
    public Zone getZone() {
        return zone;
    }

    @Override
    public Date getTripTime() {
        return tripTime;
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    @Override
    public Terminal getTerminal() {
        return toHandOver;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }
}
