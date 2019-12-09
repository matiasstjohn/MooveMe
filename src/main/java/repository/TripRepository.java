package repository;

import model.Client;
import model.Trip;

public class TripRepository extends AbstractRepository<Trip> {

    private static TripRepository tripRepository;

    private TripRepository() {
        create(new Trip(new Client("agus", "123", 123, "agus")));
        create(new Trip(new Client("flor", "1234", 1234, "flor")));
        create(new Trip(new Client("santi", "1235", 12345, "santi")));
    }

    public static TripRepository getInstance() {
        if (tripRepository != null) {
            return tripRepository;
        } else {
            tripRepository = new TripRepository();
        }

        return tripRepository;
    }
}
