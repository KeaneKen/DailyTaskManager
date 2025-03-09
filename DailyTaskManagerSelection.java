import java.util.Scanner;

public class DailyTaskManagerSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            // Display menu
            System.out.println("\nWhat mode do you want to run the Task Manager with?");
            System.out.println("1. Array Mode");
            System.out.println("2. Linked List Mode");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                clearScreen();
                    System.out.println("\nRunning Array Mode...\n");
                    DailyTaskManagerArray.main(new String[]{}); // Directly calling main method
                    break;
                case 2:
                clearScreen();
                    System.out.println("\nRunning Linked List Mode...\n");
                    DailyTaskManagerLinkList.main(new String[]{}); // Directly calling main method
                    break;
                case 3:
                clearScreen();
                    run = false;
                    System.out.println("Exiting...");
                    break;
                default:
                clearScreen();
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
// Function for clearing the screen
private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    }
}

