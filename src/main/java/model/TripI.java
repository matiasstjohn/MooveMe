package model;

import java.util.Date;

public interface TripI {
    void setDiscount(Discount discount);
    void setToHandOver(Terminal toHandOver);
    void setTripTime(Date tripTime);
    void setAsset(Asset asset);
    void setZone(Zone zone);
    void setTerminal(Terminal terminal);
    Client getClient();
    Asset getAsset();
    Zone getZone();
    Date getTripTime();
    Discount getDiscount();
    Terminal getTerminal();
    Tariff getTariff();

}
