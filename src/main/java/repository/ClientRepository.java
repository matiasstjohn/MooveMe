package repository;

import model.Client;
import model.User;
import util.UserRepositoryInterface;
import java.util.List;

public class ClientRepository extends AbstractRepository<Client> implements UserRepositoryInterface {

    private static ClientRepository clientRepository;

    private ClientRepository() {
        create(new Client("mati", "1234", 1130041854, "mati"));


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
            if ( client.getPhoneNumber()==(phoneNumber)) return client;
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
