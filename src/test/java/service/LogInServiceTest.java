package service;

import model.Admin;
import model.Client;
import org.junit.Test;
import static org.junit.Assert.*;

public class LogInServiceTest {
    private LogInService logInService = new LogInService();
    private Client client = new Client("Hola", "Hola", 12, "Hola");
    private Client client1 = new Client("Hola2", "Hola2", 123, "Hola2");
    private Admin admin = new Admin("Hola", "Hola");
    private Admin admin2 = new Admin("Hola2", "Hola2");

    @Test
    public void clientLogIn() {
        logInService.getSignedUpClients().add(client1);
        logInService.getSignedUpClients().add(client);
        assertEquals("Successful log in!", logInService.clientLogIn("Hola2", "Hola2"));
        assertEquals("Invalid nickname or password.", logInService.clientLogIn("test", "test"));

    }

    @Test
    public void adminLogIn() {

        logInService.getSignedUpAdmins().add(admin2);
        logInService.getSignedUpAdmins().add(admin);
        assertEquals("Invalid username or password.",logInService.AdminLogIn("Test", "Test"));
        assertEquals("Successful log in!",logInService.AdminLogIn("Hola2", "Hola2"));

    }
}
