package service;

import model.*;
import org.junit.Test;
import util.AssetType;
import util.Finished;
import util.Hour;
import static org.junit.Assert.*;

public class TerminalServiceTest {

    private Zone zone = new Zone("Test", 1);
    private TerminalService terminalService = new TerminalService();
    private Terminal terminal = new Terminal(zone, "Test");
    private Client client = new Client("Test", "Test", 111, "Test");
    private Trip trip = new Trip(client);
    private AssetType assetType = new AssetType("test", 1, 1);
    private PurchaseLot purchaseLot = new PurchaseLot(zone, assetType, 1);
    private Hour hour;
    private Hour hour2;
    private Finished finished = new Finished(trip);
    private Asset asset = new Asset(zone, assetType, terminal, purchaseLot);

    @Test
    public void showAssets() {
        terminal.getAssets().add(asset);
        terminalService.getTerminals().add(terminal);
        assertEquals(terminal.getAssets(), terminalService.showAssets(zone));
    }

    @Test
    public void receive() {
        terminal.getAssets().add(asset);
        terminalService.receive(asset);
        assertTrue(terminal.getAssets().contains(asset));
    }

    @Test
    public void reward() {
        hour2 = new Hour(1,1);
        trip.setTripState(finished);
        trip.setTripTime(hour2);
        hour = new Hour(0, 0);
        Integer clientInt = trip.getClient().getScoreToUse() + trip.getScore();
        terminalService.reward(trip, hour);
        assertEquals(clientInt, trip.getClient().getScoreToUse());
    }
}
