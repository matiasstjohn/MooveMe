package util;

import model.Trip;

public class ToPlan extends TripState {

    private Trip trip;

    public ToPlan(Trip trip) {
        this.trip = trip;
        type = "To plan";
    }

    @Override
    public void plan() {
        trip.setTripState(this);
    }

    @Override
    public void start() {
        throw new RuntimeException("The trip is being planned");
    }

    @Override
    public void finish() {
        throw new RuntimeException("The trip is being planned");
    }
}
