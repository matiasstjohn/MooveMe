package repository;

import model.PurchaseLot;
import model.Zone;
import util.AssetType;
import java.util.ArrayList;
import java.util.List;

public class PurchaseLotRepository extends AbstractRepository<PurchaseLot> {

    private static PurchaseLotRepository purchaseLotRepository;

    private PurchaseLotRepository() {
        create(new PurchaseLot(new Zone("Pacheco", 10),
                new AssetType("Camaro 77", 5, 10), 10));

        create(new PurchaseLot(new Zone("Pacheco", 15),
                new AssetType("Auto", 10, 15), 15));

        create(new PurchaseLot(new Zone("Pacheco", 20),
                new AssetType("DeLorean", 15, 20), 10));

        create(new PurchaseLot(new Zone("Pacheco", 25),
                new AssetType("Bici", 20, 25), 5));

        create(new PurchaseLot(new Zone("Pacheco", 5),
                new AssetType("Patineta", 25, 30), 15));

        create(new PurchaseLot(new Zone("Pacheco", 10),
                new AssetType("Rueda de Hamster gigante", 30, 35), 20));

        create(new PurchaseLot(new Zone("Pacheco", 15),
                new AssetType("Moto", 5, 5), 10));

        create(new PurchaseLot(new Zone("Pacheco", 20),
                new AssetType("Monopatin", 10, 15), 15));

        create(new PurchaseLot(new Zone("Pacheco", 25),
                new AssetType("Monopatin electrico", 15, 20), 20));

        create(new PurchaseLot(new Zone("Pacheco", 10),
                new AssetType("Batimovil", 20, 25), 35));
    }

    public List<PurchaseLot> searchByAssetType(AssetType assetType) {
        List<PurchaseLot> purchaseLots = findAll();
        List<PurchaseLot> assetTypeLots = new ArrayList<>();

        for (PurchaseLot lot: purchaseLots) {
            if (lot.getAssetType().equals(assetType)) {
                assetTypeLots.add(lot);
            }
        }

        return assetTypeLots;
    }

    public List<PurchaseLot> searchByZone(Zone zone) {
        List<PurchaseLot> purchaseLots = findAll();
        List<PurchaseLot> lotsInZone = new ArrayList<>();

        for (PurchaseLot lot: purchaseLots) {
            if (lot.getZone().equals(zone)) {
                lotsInZone.add(lot);
            }
        }

        return lotsInZone;
    }

    public static PurchaseLotRepository getInstance() {
        if (purchaseLotRepository != null) {
            return purchaseLotRepository;
        } else {
            purchaseLotRepository = new PurchaseLotRepository();
        }

        return purchaseLotRepository;
    }
}
