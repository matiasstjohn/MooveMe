package service;

import model.Client;
import model.Scoring;
import model.Zone;
import org.junit.Test;
import util.Date;
import util.Voucher;
import java.util.List;
import static org.junit.Assert.*;

public class ScoringServiceTest {

    private Client client = new Client("Hola", "Hola", 123, "Hola");
    private Client client1 = new Client("Hola1", "Hola1", 1232, "Hola1");
    private Client client2 = new Client("Hola2", "Hola2", 1231, "Hola2");
    private Zone zone = new Zone("Test", 1);
    private Scoring scoring = new Scoring(zone);
    private ScoringService scoringService = new ScoringService(scoring);
    private List<String> nickNamesTest = scoringService.showLeaders();
    private Voucher voucher = new Voucher("Best in the area: 50% discount");
    private Date date = new Date(30,3, 2001);
    private Voucher voucher2;

    @Test
    public void showLeaders() {
        assertEquals(nickNamesTest, scoringService.showLeaders());
    }

    @Test
    public void createVoucher() {
        voucher2 = scoringService.createVoucher("Best in the area: 50% discount");
        assertTrue(voucher2.equals(voucher));
    }

    @Test
    public void rewardBestThree() {
        scoring.getLeaderBoard().add(client);
        scoring.getLeaderBoard().add(client1);
        scoring.getLeaderBoard().add(client2);

        scoringService.rewardBestThree(date, voucher);
        assertEquals(true, scoring.getLeaderBoard().get(0).getVouchers().contains(voucher));
        assertEquals(true, scoring.getLeaderBoard().get(1).getVouchers().contains(voucher));
        assertEquals(true, scoring.getLeaderBoard().get(2).getVouchers().contains(voucher));
    }
}
