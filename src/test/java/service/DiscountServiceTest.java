package service;

import model.*;
import org.junit.Test;
import util.*;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class DiscountServiceTest {

    private Client client = new Client("Test", "Test", 111111, "Test");
    private Trip trip = new Trip(client);
    private ArrayList<Discount> discounts = new ArrayList<>();
    private Zone zone = new Zone("CABA", 1);
    private Terminal terminal = new Terminal(zone, "TerminalPepito");
    private AssetType assetType = new AssetType("Bici", 1, 2);
    private Discount discount = new Discount(assetType, 20, zone, 1);
    private ToPlan toPlan = new ToPlan(trip);
    private PurchaseLot purchaseLot = new PurchaseLot(zone, assetType, 12);
    private Asset asset = new Asset(zone, assetType, terminal, purchaseLot);
    private DiscountService discountService = new DiscountService();


    @Test
    public void showDiscounts() {
        assertEquals(discounts, discountService.showDiscounts(trip));
    }

    @Test
    public void canUse() {
        client.addZone(zone);
        client.sumScore(300);
        trip.setZone(zone);
        trip.setDiscount(discount);
        trip.setAsset(asset);
        trip.setTripState(toPlan);
        assertTrue(discountService.canUse(client,asset,zone,discount));
    }
}