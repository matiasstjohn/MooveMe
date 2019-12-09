package util;

import model.Trip;

public class Finished extends TripState {

    private Trip trip;

    public Finished(Trip trip) {
        this.trip = trip;
        type = "Finished";
    }

    @Override
    public void plan() {
        throw new RuntimeException("This trip is finished");
    }

    @Override
    public void start() {
        throw new RuntimeException("This trip is finished");
    }

    @Override
    public void finish() {
        trip.setTripState(this);
    }
}
