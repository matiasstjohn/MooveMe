package repository;

import model.Asset;
import model.PurchaseLot;
import model.Terminal;
import model.Zone;
import util.AssetType;
import java.util.ArrayList;
import java.util.List;

public class AssetRepository extends AbstractRepository<Asset> {

    private static AssetRepository assetRepository;

    private AssetRepository() {
        final Zone zone = new Zone("CABA", 10);
        final AssetType assetType = new AssetType("Bici", 10, 15);
        create(new Asset(zone, assetType , new Terminal(zone, "Terminal en CABA"),
                new PurchaseLot(zone, assetType, 15 )));

        final Zone zone1 = new Zone("VicenteLopez", 5);
        final AssetType assetType1 = new AssetType("Scooter", 5, 20);
        create(new Asset(zone1, assetType1 , new Terminal(zone1, "Terminal en VicenteLopez"),
                new PurchaseLot(zone1, assetType1, 20 )));

        final Zone zone2 = new Zone("Pilar", 15);
        final AssetType assetType2 = new AssetType("Moto", 5, 30);
        create(new Asset(zone2, assetType2 , new Terminal(zone2, "Terminal en Pilar"),
                new PurchaseLot(zone2, assetType2, 15 )));

        final Zone zone3 = new Zone("Munro", 20);
        final AssetType assetType3 = new AssetType("BiciMoto", 10, 15);
        create(new Asset(zone3, assetType3 , new Terminal(zone3, "Terminal en Munro"),
                new PurchaseLot(zone3, assetType3, 18 )));

        final Zone zone4 = new Zone("Villa Crespo", 5);
        final AssetType assetType4 = new AssetType("MonoPatin", 10, 5);
        create(new Asset(zone4, assetType4 , new Terminal(zone4, "Terminal en Villa Crespo"),
                new PurchaseLot(zone4, assetType4, 5 )));

        final Zone zone5 = new Zone("Pacheco", 10);
        final AssetType assetType5 = new AssetType("Clio", 10, 15);
        create(new Asset(zone5, assetType5 , new Terminal(zone5, "Terminal en Pacheco"),
                new PurchaseLot(zone5, assetType5, 15 )));

        final Zone zone6 = new Zone("Palermo", 10);
        final AssetType assetType6 = new AssetType("Patineta", 5, 5);
        create(new Asset(zone6, assetType6 , new Terminal(zone6, "Terminal en Palermo"),
                new PurchaseLot(zone6, assetType6, 20 )));

        final Zone zone7 = new Zone("Belgrano", 15);
        final AssetType assetType7 = new AssetType("Rueda de Hamnster Gigante", 20, 30);
        create(new Asset(zone7, assetType7 , new Terminal(zone7, "Terminal en Belgrano"),
                new PurchaseLot(zone7, assetType7, 20 )));

        final Zone zone8 = new Zone("La lucila", 10);
        final AssetType assetType8 = new AssetType("BatiMovil", 10, 15);
        create(new Asset(zone8, assetType8 , new Terminal(zone8, "Terminal en La lucila"),
                new PurchaseLot(zone8, assetType8, 15 )));

        final Zone zone9 = new Zone("San Isidro", 10);
        final AssetType assetType9 = new AssetType("X wing", 5, 20);
        create(new Asset(zone9, assetType9 , new Terminal(zone9, "Terminal en San Isidro"),
                new PurchaseLot(zone9, assetType9, 5 )));
    }

    public Asset searchByAssetType(AssetType assetType) {
        List<Asset> assets = findAll();

        for (Asset asset: assets) {
            if (asset.getType().equals(assetType)) return asset;
        }

        return null;
    }

    public List<Asset> searchByZone(Zone zone) {
        List<Asset> assets = findAll();
        List<Asset> assetsInZone = new ArrayList<>();

        for (Asset asset: assets) {
            if (asset.getZone().equals(zone)) {
                assetsInZone.add(asset);
            }
        }

        return assetsInZone;
    }

    public static AssetRepository getInstance() {

        if (assetRepository != null) {
            return assetRepository;
        } else {
            assetRepository = new AssetRepository();
        }

        return assetRepository;
    }
}
