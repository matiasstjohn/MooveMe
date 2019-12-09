package service;

import model.Client;
import org.junit.Test;
import static org.junit.Assert.*;

public class SignUpServiceTest {
    private SignUpService signUpService = new SignUpService();
    private Client client = new Client("Hola", "Hola", 123, "Hola");

    @Test
    public void signUp() {
        signUpService.getSignedUpClients().add(client);
        assertEquals("Username and password validated.",
                signUpService.signUp("test", 1));
        assertEquals("Username or phone number already exists.",
                signUpService.signUp("Hola", 123));
    }

    @Test
    public void registerClient(){
        signUpService.getSignedUpClients().add(client);
        assertEquals("Nickname already exists.",
                signUpService.registerClient("Hola", 123, "Hola", "Hola"));
        assertEquals("Registered successfully.",
                signUpService.registerClient("Test", 1, "Test", "Test"));
    }
}