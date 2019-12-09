package view;

import model.*;
import service.DiscountService;
import service.ScoringService;
import service.ViewService;
import util.Hour;
import util.InProgress;
import java.util.List;
import java.util.Scanner;

public class ClientMenu {
    private ViewService viewService = new ViewService();
    private Scanner scanner = new Scanner(System.in);
    private ClientSignUp clientSignUp = new ClientSignUp();
    private ScoringService scoringService;
    private Trip trip;

    public void clientMenu() {

        System.out.println("Client menu: \n\n");
        System.out.println("1. New trip. \n" +
                "2. Show leaderboard. \n" +
                "3. Show profile. \n" +
                "4. Exit. \n");

        System.out.println("Please enter the option number you want: \n");

        int clientAnswer = scanner.nextInt();

        switch (clientAnswer) {
            case 1: newTrip();
            case 2: showLeaderBoard();
            case 3: showProfile();
            case 4: System.out.println("Thanks for using MoovMe."); System.exit(0);
            default: System.out.println("Invalid option");
        }

        clientMenu();
    }

    public void newTrip() {

        trip = new Trip(clientSignUp.getClient());

        System.out.println("Please, choose the zone: ");
        viewService.getZones();

        int zone = scanner.nextInt();

        Zone zone1 = viewService.zonesList().get(zone);
        trip.setZone(zone1);

        System.out.println("Please, choose an asset:");

        viewService.getAssetsInZone(zone1);

        int asset = scanner.nextInt();

        Asset asset1 = viewService.assetsList().get(asset);
        trip.setAsset(asset1);

        System.out.println("If you want, choose a terminal to deliver the asset or -1 if not.");

        viewService.getTerminalInZone(zone1);

        int terminal = scanner.nextInt();

        if (terminal == -1) {
            Terminal terminal1 = null;
            trip.setTerminalToHandOver(terminal1);
        } else {
            Terminal terminal1 = viewService.terminalsInZoneList(zone1).get(terminal);
            trip.setTerminalToHandOver(terminal1);
        }

        System.out.println("Please, choose hour to return the asset");
        int hour = scanner.nextInt();


        System.out.println("Please, choose minute to return the asset");
        int minute = scanner.nextInt();

        Hour tripHour = new Hour(minute, hour);
        trip.setTripTime(tripHour);

        System.out.println("If you want, choose a discount or -1 if not.");

        viewService.getDiscounts();

        int discount = scanner.nextInt();

        if (discount == -1) {
            Discount discount1 = null;
            trip.setDiscount(discount1);
        } else {
            Discount discount1 = viewService.discountList().get(discount);
            trip.setDiscount(discount1);
        }

        System.out.println("Would you like to change your trip information? \n");

        String clientAnswer = scanner.nextLine();

        while (!clientAnswer.equals("yes") && !clientAnswer.equals("no")) {

            System.out.println("Would you like to change your trip information? \n");

            clientAnswer = scanner.nextLine();
        }


        if (clientAnswer.equals("yes")) {
            newTrip();
        }

        if (clientAnswer.equals("no")) {
            System.out.println("The trip will begin.");
            new InProgress(trip);
        }

        clientMenu();
    }

    public void showLeaderBoard() {
        Scoring scoring = new Scoring(trip.getZone());
        scoringService = new ScoringService(scoring);

        System.out.println("Leader Board: \n");

        List<String> leaderboard = scoringService.showLeaders();

        for (String s : leaderboard) System.out.println(s);

        System.out.println("To return to the menu enter 1. \n");

        int clientAnswer = scanner.nextInt();

        while (clientAnswer != 1) {


            clientAnswer = scanner.nextInt();
        }

        clientMenu();
    }

    public void showProfile() {
        System.out.println("Profile: \n");
        System.out.println("1. Points. \n" +
                "2. Discounts. \n" +
                "3. Back.");
        System.out.println("Enter de number of option you want");

        int profileOptions = scanner.nextInt();

        switch (profileOptions) {
            case 1: System.out.println("Your points are: "
                    + trip.getClient().getAccumulatedScore());

            showProfile();

            case 2: System.out.println("Your Discount are: ");
                final List<Discount> discounts = trip.getClient().getDiscounts();
                for (int i = 0; i < discounts.size(); i++) {
                    System.out.println(i + ". Discount of " + discounts.get(i).getPercent() + "%");
                } showProfile();

            case 3: clientMenu();
        }

        showProfile();
    }
}
