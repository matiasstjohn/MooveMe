package service;
import model.Admin;
import model.Client;
import repository.AdminRepository;
import repository.ClientRepository;
import java.util.List;

/**
 * Perguntar si es admin o client, son dos log in separados.
 */

public class LogInService {

    private ClientRepository clientRepository = ClientRepository.getInstance();
    private AdminRepository adminRepository = AdminRepository.getInstance();

    private List<Client> signedUpClients = clientRepository.findAll();
    private List<Admin> signedUpAdmins = adminRepository.findAll();

    public String clientLogIn(String nickname, String password) {

        Client client1 = null;

        for (Client client: signedUpClients) {

            if (client.getNickname().equals(nickname) &&
                    client.getPassword().equals(password)) {
                client1 = client;
            }
        }

        if (client1 == null) {
            return "Invalid nickname or password.";
        }

        return "Successful log in!";
    }

    public String AdminLogIn(String username, String password) {

        Admin admin1 = null;

        for (Admin admin: signedUpAdmins ) {

            if (admin.getUsername().equals(username) &&
                    admin.getPassword().equals(password)) {
                admin1 = admin;
            }
        }

        if (admin1 == null) {
            return "Invalid username or password.";
        }

        return "Successful log in!";
    }

    public List<Client> getSignedUpClients() {
        return signedUpClients;
    }

    public List<Admin> getSignedUpAdmins() {
        return signedUpAdmins;
    }
}
