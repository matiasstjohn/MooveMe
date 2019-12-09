package model;
import java.util.List;


public class Admin extends User implements AdminI {
    private List<ClientI> clients;
    private List<PurchaseLot> purchaseLot;
    private List<Terminal> terminals;

    public Admin(String username, String password) {
        super(username, password);
    }


    public List<Terminal> showTerminal() {
        return terminals;
    }

    public List<PurchaseLot> showPL(){
        return purchaseLot;
    }
}
