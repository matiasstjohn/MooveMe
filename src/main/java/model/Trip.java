package model;

import util.*;

public class Trip implements TripI, Entity {

    private final Long key;
    private final Client client;
    private Asset asset;
    private Zone zone;
    private Hour tripTime;
    private Discount discount;
    private Terminal toHandOver;
    private Tariff tariff;
    private Integer score;
    private TripState tripState;

    public Trip(Client client) {
        this.client = client;
        this.key = new KeyGenerator().generateKey();
        this.score = 0;
    }

    @Override
    public Long getKey() {
        return key;
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
    public void setTripTime(Hour tripTime) {
        this.tripTime = tripTime;
    }

    @Override
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public void setTerminalToHandOver(Terminal toHandOver) {
        this.toHandOver = toHandOver;
    }

    @Override
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public void setScore(Integer score) {
        this.score += score;
    }

    @Override
    public void setTripState(TripState tripState) {
        this.tripState = tripState;
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
    public Hour getTripTime() {
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

    @Override
    public Integer getScore() {
        return score;
    }

    @Override
    public TripState getTripState() {
        return tripState;
    }
}
