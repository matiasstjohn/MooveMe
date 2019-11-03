package service;

import model.Client;
import java.util.List;

public class SignUpService {

    private List<Client> signedUpClients;

    // Cuando un cliente se registre, que le pida el nombre, numero de telefono, valida los datos
    // y despues que le pida el apodo y la contraseña

    // Chequear que el nickname sea unico

    public void signUp(String username, String password, String phoneNumber, String nickname) {
        Client client = new Client(username, password, phoneNumber, nickname);
        signedUpClients.add(client);
    }
}
