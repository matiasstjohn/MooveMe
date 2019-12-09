package repository;

import model.Zone;

public class ZoneRepository extends AbstractRepository<Zone> {

    private static ZoneRepository zoneRepository;

    private ZoneRepository() {
        create(new Zone("Tigre", 15));
        create(new Zone("Pilar", 5));
        create(new Zone("CABA", 15));
        create(new Zone("Pacheco", 10));
        create(new Zone("Belgrano", 10));
        create(new Zone("Palermo", 15));
        create(new Zone("Villa Crespo", 20));
        create(new Zone("Vicente Lopez", 10));
        create(new Zone("Munro", 5));
        create(new Zone("San Isidro", 5));
    }

    public static ZoneRepository getInstance() {
        if (zoneRepository != null) {
            return zoneRepository;
        } else {
            zoneRepository = new ZoneRepository();
        }

        return zoneRepository;
    }
}
