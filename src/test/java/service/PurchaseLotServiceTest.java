package service;

import model.*;
import org.junit.Test;
import util.AssetType;
import static org.junit.Assert.*;

public class PurchaseLotServiceTest {
    private PurchaseLotService purchaseLotService = new PurchaseLotService();
    private Zone zone = new Zone("Hola", 1);
    private Terminal terminal = new Terminal(zone, "Hola");
    private AssetType assetType = new AssetType("Hola", 1, 1);
    private PurchaseLot purchaseLot = new PurchaseLot(zone, assetType, 1);
    private Asset asset = new Asset(zone, assetType, terminal, purchaseLot);

    @Test
    public void createLot() {
        purchaseLotService.createLot(asset, 1);
        assertTrue(purchaseLotService.getAssetRepository().findAll().contains(asset));
    }
}
