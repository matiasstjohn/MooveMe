package service;

import model.Asset;
import model.PurchaseLot;
import model.Terminal;
import model.Zone;
import util.KeyGenerator;

import java.util.List;

/**
 * Los lotes tienen que generar activos y devolverlos.
 * Guardar los service en una terminal.
 * Tambien deben guardar los activos comprados, que serian los generados por el lote.
 */

public class PurchaseLotService {
    private List<Asset> purchasedAssets;
    private TerminalService terminalService;
    private List<PurchaseLot> purchaseLots;

    /*public Asset createAsset(Zone zone, String assetType, Terminal terminal) {
          Asset asset = new Asset(new KeyGenerator(), zone, assetType);
          terminalService.receive(asset);
          purchasedAssets.add(asset);
          return asset;
      }*/
}
