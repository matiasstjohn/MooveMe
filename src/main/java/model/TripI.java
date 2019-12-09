package model;

import util.Hour;
import util.Tariff;
import util.TripState;

public interface TripI {

    void setAsset(Asset asset);

    void setZone(Zone zone);

    void setTripTime(Hour tripTime);

    void setDiscount(Discount discount);

    void setTerminalToHandOver(Terminal toHandOver);

    void setTariff(Tariff tariff);

    void setScore(Integer score);

    void setTripState(TripState tripState);

    Client getClient();

    Asset getAsset();

    Zone getZone();

    Hour getTripTime();

    Discount getDiscount();

    Terminal getTerminal();

    Tariff getTariff();

    Integer getScore();

    TripState getTripState();
}
