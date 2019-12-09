package service;

import model.*;
import org.junit.Test;
import util.AssetType;
import util.Voucher;
import static org.junit.Assert.*;

public class ClientServiceTest {

    private Client client = new Client("Test", "Test", 1, "Test");
    private ClientService clientService = new ClientService(client);
    private Zone zone = new Zone("CABA", 25);
    private AssetType assetType = new AssetType("Bici", 1, 20);
    private Discount discount = new Discount(assetType, 20, zone, 10);
    private Voucher voucher = new Voucher("VoucherTest");

    @Test
    public void showScore() {
        client.sumScore(500);
        Integer clientInt = client.getAccumulatedScore();
        assertEquals(clientInt, clientService.showScore(client));
    }

    @Test
    public void showDiscounts() {
        client.getDiscounts().add(discount);
        clientService.showDiscounts(client);
        assertEquals(client.getDiscounts(), clientService.showDiscounts(client));
    }
    @Test

    public void showVouchers(){
        clientService.showDiscounts(client);
        assertEquals(client.getVouchers(), clientService.showVouchers(client));
    }
    @Test
    public void showPhoneNumber(){
        clientService.showPhoneNumber(client);
        assertEquals(client.getPhoneNumber(), clientService.showPhoneNumber(client));
    }

    @Test
    public void showNickname(){
        clientService.showNickname(client);
        assertEquals(client.getNickname(), clientService.showNickname(client));
    }

    @Test
    public void buyDiscounts(){
        clientService.buyDiscount(discount);
        assertTrue(client.getDiscounts().contains(discount));
    }

    @Test
    public void useDiscounts(){
        clientService.useDiscount(discount);
        assertEquals(false, client.getDiscounts().contains(discount));
    }

    @Test
    public void useVoucher(){
        clientService.useVoucher(voucher);
        assertEquals(false, client.getVouchers().contains(voucher));
    }
}