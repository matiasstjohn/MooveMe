package view;

import model.Client;
import service.SignUpService;
import java.util.Scanner;

public class ClientSignUp {
    private Scanner scanner = new Scanner(System.in);
    private SignUpService signUpService = new SignUpService();
    private Client client;

    public void clientSignUp() {

        System.out.println("Client sign up: \n");
        System.out.println("Please enter your username: ");

        String username = scanner.nextLine();

        System.out.println("\n Please enter your phonenumber: ");

        Integer phoneNumber = scanner.nextInt();

        String valid = signUpService.signUp(username, phoneNumber);

        while (valid.equals("Username or phone number already exists.")) {


            System.out.println("Please enter your username: ");

            String username2 = scanner.next();

            System.out.println("Please enter your phonenumber: ");

            Integer phoneNumber2 = scanner.nextInt();

            valid = signUpService.signUp(username2, phoneNumber2);
        }

        System.out.println(valid);

        System.out.println("Please enter your nickname: ");

        String nickname = scanner.next();

        System.out.println("Please enter your password: ");

        String password = scanner.next();

        String valid1 = signUpService.registerClient(username, phoneNumber, nickname, password);

        while (valid1.equals("Nickname already exists.")) {

            System.out.println("Pleas enter your nickname: ");

            String nickname2 = scanner.nextLine();

            valid1 = signUpService.registerClient(username, phoneNumber, nickname2, password);
        }

        System.out.println(valid1);

        client = new Client(username, password, phoneNumber, nickname);
    }

    protected Client getClient() {
        return client;
    }
}
