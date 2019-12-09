package repository;

import model.Scoring;
import model.Zone;
import java.util.List;

public class ScoringRepository extends AbstractRepository<Scoring> {

    private static ScoringRepository scoringRepository;

    private ScoringRepository() {}

    public Scoring searchByZone(Zone zone) {
        List<Scoring> scoringList = findAll();

        for (Scoring scoring: scoringList) {
            if (scoring.getZone().equals(zone)) return scoring;
        }
        Scoring scoring = new Scoring(zone);
        return create(scoring);
    }

    public static ScoringRepository getInstance() {
        if (scoringRepository != null) {
            return scoringRepository;
        } else {
            scoringRepository = new ScoringRepository();
        }

        return scoringRepository;
    }
}
