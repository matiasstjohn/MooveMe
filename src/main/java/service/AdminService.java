package service;

import model.*;
import util.KeyGenerator;
import java.util.List;

/**
 * Crear descuentos.
 * Crear activos.
 */

public class AdminService {

    private List<Client> blockedClients;
    private List<Client> clients;
    private List<Terminal> terminals;
    private List<PurchaseLot> purchaseLots;
    private List<Discount> discounts;


    public void blockClient(Client client) {
        for (Client client1: clients) {
            if (client1.equals(client)) {
                clients.remove(client);
                blockedClients.add(client);
                client.blockClient();
            }
        }
    }

    public void unBlockClient(Client client) {
        for (Client client1: blockedClients) {
            if (client1.equals(client)) {
                blockedClients.remove(client);
                clients.add(client);
                client.unBlockClient();
            }
        }
    }

    public Integer reportTrip(Trip trip) { return 0; //multo, bloqueo, restituyo a donde?

    }

    public String createAsset(Zone zone, String assetType) {
        for (PurchaseLot purchaseLot: purchaseLots) {

            if (purchaseLot.getAssetType().equals(assetType) && purchaseLot.getZone().equals(zone)) {

                // Asset asset = purchaseLot.createAsset(zone, assetType);

                for (Terminal terminal: terminals) {

                    if (terminal.showZone().equals(zone)) {
                        // terminal.receive(asset);

                        return "Your Asset has been created correctly";
                    }

                    return "Terminal could not recive asset";
                }
            }
        }

        return "Your Asset was not created";
    }

    public Discount createDiscount(String assetType, Integer minScore, Zone zone, int percent) {
        Discount discount = new Discount(assetType, minScore, zone, percent);
        discounts.add(discount);
        return discount;
    }

    public Terminal createTerminal(Zone zone, String name) {
        return new Terminal(zone, name);
    }

    public PurchaseLot createPurchaseLot(KeyGenerator keyGenerator, Zone zone, String assetType) {
        PurchaseLot purchaseLot = new PurchaseLot(keyGenerator, zone, assetType);
        purchaseLots.add(purchaseLot);
        return purchaseLot;
    }
}
