package repository;

import model.Client;
import model.User;
import util.UserRepositoryInterface;
import java.util.List;

public class ClientRepository extends AbstractRepository<Client> implements UserRepositoryInterface {

    private static ClientRepository clientRepository;

    private ClientRepository() {
        create(new Client("santi", "1234", 1130041854, "santi"));
        create(new Client("agus", "1234", 1138081835, "agus"));

        Client client = (new Client("flor", "1234", 1143383000, "flor"));
        client.sumScore(100);
        create(client);
        create(new Client("alex", "1234", 1143338542, "alex"));
    }

    @Override
    public User searchByUsername(String username) {
        List<Client> clients = findAll();

        for (Client client: clients) {
            if ( client.getUsername().equals(username)) return client;
        }

        return null;
    }

    public Client searchByNickname(String nickname) {
        List<Client> clients = findAll();

        for (Client client: clients) {
            if ( client.getNickname().equals(nickname)) return client;
        }

        return null;
    }

    public Client searchByPhoneNumber(Integer phoneNumber) {
        List<Client> clients = findAll();

        for (Client client: clients) {
            if ( client.getPhoneNumber().equals(phoneNumber)) return client;
        }

        return null;
    }

    public static ClientRepository getInstance() {
        if (clientRepository != null) {
            return clientRepository;
        } else {
            clientRepository = new ClientRepository();
        }

        return clientRepository;
    }
}
