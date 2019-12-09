package view;

import java.util.Scanner;

public class MainScreen {

    private Scanner scanner = new Scanner(System.in);
    private AdminLogIn adminLogIn = new AdminLogIn();
    private ClientSignUp clientSignUp = new ClientSignUp();
    private ClientLogIn clientLogIn = new ClientLogIn();

    public void showScreen() {
        System.out.println("Welcome to MoovMe!");
        System.out.println("Are you an admin or a client? ");

        String userAnswer = scanner.next();

        while (!userAnswer.equals("admin") && !userAnswer.equals("client")) {


            System.out.println("Invalid answer.\n " + "Are you an admin or a client? ");

            userAnswer = scanner.next();
        }

        if (userAnswer.equals("admin")) {
            adminLogIn.adminLogIn();
        }

        if (userAnswer.equals("client")) {

            System.out.println("Would you like to sign up or log in? ");

            String userAnswer2 = scanner.next();


            while (!userAnswer2.equals("sign") && !userAnswer2.equals("log")) {

                System.out.println("Invalid answer.\n " +
                        "Would you like to sign up or log in? ");

                userAnswer2 = scanner.next();
            }


            if (userAnswer2.equals("sign")) {
                clientSignUp.clientSignUp();
            }

            if (userAnswer2.equals("log")) {
                clientLogIn.clientLogIn();
            }
        }

        showScreen();
    }
}
