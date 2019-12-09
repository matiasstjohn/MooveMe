package service;

import model.*;
import repository.*;
import java.util.List;

public class ViewService {

    private ClientRepository clientRepository = ClientRepository.getInstance();
    private BlockedClientRepository blockedClientRepository = BlockedClientRepository.getInstance();
    private TripRepository tripRepository = TripRepository.getInstance();
    private TerminalRepository terminalRepository = TerminalRepository.getInstance();
    private ZoneRepository zoneRepository = ZoneRepository.getInstance();
    private AssetRepository assetRepository = AssetRepository.getInstance();
    private DiscountRepository discountRepository = DiscountRepository.getInstance();

    private List<Client> clients = clientRepository.findAll();
    private List<Client> blockedClients = blockedClientRepository.findAll();
    private List<Trip> trips = tripRepository.findAll();
    private List<Zone> zones = zoneRepository.findAll();
    private List<Terminal> terminals = terminalRepository.findAll();
    private List<Asset> assets = assetRepository.findAll();
    private List<Discount> discounts = discountRepository.findAll();

    public void getClients() {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(i + ". " + clients.get(i).getNickname());
        }
    }

    public List<Client> clientsList(){
        return clients;
    }

    public void getBlockedClients() {
        for (int i = 0; i < blockedClients.size(); i++) {
            System.out.println(i + ". " + blockedClients.get(i).getNickname());
        }
    }

    public List<Client> blockedClientsList() {
        return blockedClients;
    }

    public void getTrips() {
        for (int i = 0; i < trips.size(); i++) {
            System.out.println(i + ". " + trips.get(i).getClient().getNickname() + "'s trip");
        }
    }

    public List<Trip> tripList() {
        return trips;
    }

    public void getTerminals() {
        for (int i = 0; i < terminals.size() ; i++) {
            System.out.println(i + ". " + terminals.get(i).getName());
        }
    }

    public List<Terminal> terminalsList() {
        return terminals;
    }

    public void getTerminalInZone(Zone zone) {
        final List<Terminal> terminals = terminalRepository.searchByZone(zone);
        for (int i = 0; i < terminals.size() ; i++) {
            System.out.println(i + ". " + terminals.get(i).getName());
        }
    }

    public List<Terminal> terminalsInZoneList(Zone zone) {
        return terminalRepository.searchByZone(zone);
    }

    public void getZones() {
        for (int i = 0; i < zones.size(); i++) {
            System.out.println(i + ". " + zones.get(i).getType());
        }
    }

    public List<Zone> zonesList() {
        return zones;
    }

    public void getAssets() {
        for(int i = 0; i < assets.size(); i++) {
            System.out.println(i + ". " + assets.get(i).getType().getAssetType());
        }
    }

    public List<Asset> assetsList() {
        return assets;
    }

    public void getAssetsInZone(Zone zone) {
        final List<Asset> assets = assetRepository.searchByZone(zone);

        for(int i = 0; i < assets.size(); i++) {
            System.out.println(i + ". " + assets.get(i).getType().getAssetType());
        }
    }

    public List<Asset> assetInZoneList(Zone zone) {
        return assetRepository.searchByZone(zone);
    }

    public void getDiscounts() {
        for (int i = 0; i < discounts.size(); i++) {
            System.out.println(i + ". Descuento de " + discounts.get(i).getPercent() + "%.");
        }
    }

    public List<Discount> discountList() {
        return discounts;
    }
}
