import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your To-Do List!");
        System.out.println("Here are your options:");
        System.out.println("1. View List");
        System.out.println("2. Add to List");
        System.out.println("3. Remove from List");
        System.out.println("4. Remove all from List");
        System.out.println("5. Quit");

        Scanner inputScanner = new Scanner(System.in);

        int choice = inputScanner.nextInt();
        HandleInput(choice);

        inputScanner.close();
    }

    static void HandleInput(int choice)
    {
        switch (choice) {
            case 5:
                System.out.println("Quitting...");
                System.exit(0);
                break;
        
            default:
                break;
        }
    }
}
