package librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        run();
    }
    
    private static void run() {
        int adminOrBorrower;
        int adminSelection;
        
        adminOrBorrower = adminOrBorrower();
        selectUser(adminOrBorrower);
        
    }

    private static int adminOrBorrower() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean ifChoice = true;

        //Låter använvändaren välja inloggning
        System.out.print("Vill du logga in som admin eller låntagare?"
                + "\n 1) Admin"
                + "\n 2) Låntagare"
                + "\n\nVälj: ");
        while (ifChoice) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice == 1 || choice == 2) {
                    ifChoice = false;
                } else {
                    System.out.print("\nVälj ett heltal mellan 1 och 2: ");
                }
            } else {
                System.out.print("\nVälj ett heltal mellan 1 och 2: ");
                input.next();
            }
        }
        return choice;
    }

    private static void selectUser(int choice) {
        switch (choice) {
            case 1:
                adminLogin();
                break;
            case 2:
                borrowerLogin();
                break;
        }
    }
    
    private static void adminLogin() {
        // Här ska admin få välja sitt användarkod och skirva in ett lösenord
        // admin ska kunna ändra:
        // 1. Skapa en författare
        // 2. Skapa en bok
        // 3. Skapa en ny låntagare
        // 4. Ta bort dessa
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean ifChoice = true;

        
        System.out.println("Grattis du är en admin!!");
        System.out.print("1. Skapa en författare"
                + "\n2. Skapa en bok"
                + "\n3. Skapa en ny låntagare"
                + "\n4. Ta bort författare/bok/låntagare"
                + "\n5. Gå tillbaka"
                + "\n\nVälj: ");
        while (ifChoice) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice > 0 || choice < 5) {
                    ifChoice = false;
                } else {
                    System.out.print("\nVälj ett heltal mellan 1 och 5: ");
                }
            } else {
                System.out.print("\nVälj ett heltal mellan 1 och 5: ");
                input.next();
            }
        }
    }

    private static void borrowerLogin() {
        // Här ska ska låntagaren få skriva in sina inloggnings uppgifter
        // Låntagare ska kunna göra:
        // 1. Låna en bok
        // 2. Lämna tillbaka en bok
        System.out.println("Du är bara en låntagare");
        System.out.println("");
    }
    
    private static Connection connect() {
        final String url = "jdbc:mysql://localhost:3306/sti?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        final String user = "root";
        final String password = "Etthundra2";
        Connection connection = null;
        
        try {
            // 1. Anslut till databasen
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
