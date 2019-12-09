package view;

import service.AdminService;
import service.ViewService;
import java.util.Scanner;

public class AdminMenu {

    private AdminService adminService = new AdminService();
    private ViewService viewService = new ViewService();
    private Scanner scanner = new Scanner(System.in);


    public void adminMenu() {
        System.out.println("Admin menu: \n\n");
        System.out.println("1. Block client. \n" +
                "2. Unblock client. \n" +
                "3. Report trip. \n" +
                "4. Create terminal. \n" +
                "5. Create purchase lot. \n" +
                "6. Create discount. \n" +
                "7. Exit.");

        System.out.println("Please enter the option number you want: \n");

        int adminAnswer = scanner.nextInt();

        switch (adminAnswer) {
            case 1: blockClient();
            case 2: unblockClient();
            case 3: reportTrip();
            case 4: createTerminal();
            case 5: newPurchaseLot();
            case 6: createDiscount();
            case 7: System.out.println("Thanks for using MoovMe"); System.exit(0);
            default:
                System.out.println("Invalid option");
        }

        adminMenu();
    }

    public void blockClient() {
        System.out.println("Enter the client you want to block. \n");

        viewService.getClients();

        int blockClient = scanner.nextInt();

        adminService.blockClient(viewService.clientsList().get(blockClient));
        System.out.println("Successfully blocked.");

        adminMenu();
    }

    public void unblockClient() {
        System.out.println("Enter the client you want to unblock. \n");

        viewService.getBlockedClients();

        int unblockClient = scanner.nextInt();

        adminService.unBlockClient(viewService.blockedClientsList().get(unblockClient));

        System.out.println("Successfully unblocked");

        adminMenu();
    }

    public void reportTrip() {
        System.out.println("Insert which trip to report.");

        viewService.getTrips();

        int trip = scanner.nextInt();

        System.out.println("Insert terminal to hand over.");

        viewService.getTerminals();

        int toHandOver = scanner.nextInt();

        System.out.println("Insert the amount of the fine.");

        int baseFine = scanner.nextInt();

         adminService.reportTrip(viewService.tripList().get(trip),
                 viewService.terminalsList().get(toHandOver), baseFine);

        System.out.println("Successfully reported.");

        adminMenu();
    }

    public void createTerminal() {

        System.out.println("Insert in which zone it will be created.");

        viewService.getZones();

        int terminalZone = scanner.nextInt();

        System.out.println("Insert name of the new terminal.");

        String terminalName = scanner.next();

        adminService.createTerminal(viewService.zonesList().get(terminalZone), terminalName);

        System.out.println("Successfully created.");

        return;
    }

    public void newPurchaseLot(){

        System.out.println("Insert zone. \n");

        viewService.getZones();

        int zone = scanner.nextInt();

        System.out.println("Insert an asset type.");

        viewService.getAssets();

        int asset = scanner.nextInt();

        System.out.println("Insert in which terminal they will be delivered.");

        viewService.getTerminals();

        int terminal = scanner.nextInt();

        System.out.println("Insert amount to buy.");

        int lot = scanner.nextInt();

        adminService.createPurchaseLot(viewService.zonesList().get(zone),
                viewService.assetsList().get(asset).getType(), viewService.terminalsList().get(terminal), lot);

        adminMenu();
    }

    public void createDiscount() {

        System.out.println("Insert an asset type.");

        viewService.getAssets();

        int asset = scanner.nextInt();

        System.out.println("Enter minimum score required. ");

        int minScore = scanner.nextInt();

        System.out.println("Insert zone. \n");

        viewService.getZones();

        int zone = scanner.nextInt();

        System.out.println("Enter discount percentage. ");

        int percent = scanner.nextInt();

        adminService.createDiscount(viewService.assetsList().get(asset).getType(), minScore,
                viewService.zonesList().get(zone), percent);

        adminMenu();
    }
}


