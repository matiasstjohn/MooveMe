package util;

import model.Trip;

public abstract class TripState {

    private Trip trip;
    protected String type;

    public abstract void plan();

    public abstract void start();

    public abstract void finish();

    public String getType() {
        return type;
    }

    public boolean equals(TripState state) {
        return this.getType().equals(state.getType());
    }
}
