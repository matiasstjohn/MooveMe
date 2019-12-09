package service;

import model.Client;
import model.Discount;
import java.util.List;

/**
 * Mostrar todas las cosas del perfil (Nickname, PhoneNumber)
 */

public class ClientService {
    private Client client;

    public Integer showScore(Client client) {
        return client.getAccumulatedScore();
    }

    public List<Discount>showDiscounts(Client client) {
        return client.getDiscounts();
    }

    public Integer showPhoneNumber(Client client) { return client.getPhoneNumber(); }

    public String showNickname(Client client) { return client.getNickname(); }
}
