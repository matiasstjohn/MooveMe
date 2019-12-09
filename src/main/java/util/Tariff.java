package util;

import model.Discount;
import model.Trip;

public class Tariff {
    private double tripValue;

    public Tariff(double tripValue) {
        this.tripValue = tripValue;
    }

    public void setTripValue(double tripValue) {
        this.tripValue += tripValue;
    }

    public Double getTripValue() {
        return tripValue;
    }

    public double calculateTariff(Trip trip, Discount discount, Fine fine) {
        tripValue = trip.getTripTime().getMinute() *
                trip.getAsset().getType().getPricePerMinute();

        setTripValue(tripValue * trip.getZone().getRate());

        if (fine != null) {
            setTripValue(fine.getFineValue());
        }

        if (discount != null) {
            setTripValue(-tripValue * discount.getPercent());
        }

        return tripValue;
    }
}
