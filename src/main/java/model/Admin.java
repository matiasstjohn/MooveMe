package model;
import java.util.List;


public class Admin extends User implements AdminI {
    private List<ClientI> clients;
    private List<PurchaseLot> purchaseLot;
    private List<Terminal> terminals;

    public Admin(String username, String password) {
        super(username, password);
    }

    /**
    @Override
    public Terminal getTerminal(Zone zone) {
        for(int i = 0; i < terminals.size(); i++) {
            if(terminals.get(i).showZone().getType().equals(zone.getType())) {
                return terminals.get(i);
            }
        }

        return null;
    }

    @Override
    public PurchaseLot getPurchaseLot(PurchaseLot lookPurchaseLot) {
        for(int i = 0; i < purchaseLot.size(); i++){
            if(purchaseLot.get(i).getKey().equals(lookPurchaseLot.getKey())) {
                return purchaseLot.get(i);
            }
        }

        return null;
    }
    */

    public List<Terminal> showTerminal() {
        return terminals;
    }

    public List<PurchaseLot> showPL(){
        return purchaseLot;
    }
}
