package service;

import model.*;
import org.junit.Test;
import util.*;
import static org.junit.Assert.*;

public class TripServiceTest {
    private Client client = new Client("Test", "Test", 111111, "Test");
    private Zone zone = new Zone("Test", 1);
    private Trip trip = new Trip(client);
    private TripService tripService = new TripService(trip);
    private Terminal terminal = new Terminal(zone, "Test");
    private AssetType assetType = new AssetType("test", 1, 20);
    private PurchaseLot purchaseLot = new PurchaseLot( zone, assetType, 5);
    private Hour hour = new Hour(1,11);
    private Asset asset = new Asset(zone, assetType, terminal, purchaseLot);
    private Discount discount = new Discount(assetType, 5, zone, 5);
    private Fine fine = new Fine(zone, 1);
    private Tariff tariff = new Tariff(11);

    @Test
    public void setZone() {
        trip.setTripState(new ToPlan(trip));
      tripService.setZone(zone);
        assertEquals(zone, trip.getZone());
    }

    @Test
    public void setAsset() {
        trip.setTripState(new ToPlan(trip));
        tripService.setAsset(asset);
        assertEquals(asset, trip.getAsset());
    }

    @Test
    public void setTripTime() {
        trip.setTripState(new ToPlan(trip));
        tripService.setTripTime(hour);
        assertEquals(hour, trip.getTripTime());

    }

    @Test
    public void setDiscount() {
        trip.setTripState(new ToPlan(trip));
        tripService.setDiscount(discount);
        assertEquals(discount, trip.getDiscount());
    }

    @Test
    public void setTerminalToHandOver() {
        trip.setTripState(new ToPlan(trip));
        tripService.setTerminalToHandOver(terminal);
        assertEquals(terminal, trip.getTerminal());
    }

    @Test
    public void setTariff() {
        trip.setTripState(new ToPlan(trip));
        trip.setTariff(tariff);
        trip.setTripTime(hour);
        trip.setAsset(asset);
        trip.setZone(zone);
        double tripValue = trip.getTariff().calculateTariff(trip, discount, fine);
        assertEquals(tripValue,tripService.setTariff(discount, fine), 0.01);
    }

    @Test
    public void setScore() {
        trip.setAsset(asset);
        trip.setTripTime(hour);
        tripService.setScore();

        assertEquals(trip.getScore(), tripService.setScore());
    }
}
