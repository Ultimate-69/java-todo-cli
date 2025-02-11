import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    static Scanner inputScanner = new Scanner(System.in); // Create a single Scanner instance

    public static void main(String[] args) {
        GiveOptions();
    }

    static void GiveOptions() {
        System.out.println("Welcome to your To-Do List!");
        System.out.println("Here are your options:");
        System.out.println("1. View List");
        System.out.println("2. Add to List");
        System.out.println("3. Remove from List");
        System.out.println("4. Remove all from List");
        System.out.println("5. Quit");

        int choice = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume newline character
        HandleInput(choice);
    }

    static void HandleInput(int choice) {
        Path filepath = Paths.get("tasks.txt");

        switch (choice) {
            case 1:
                if (Files.exists(filepath)) {
                    System.out.println("Your list of tasks:");
                    try (FileReader reader = new FileReader("tasks.txt")) {
                        int i;
                        String tasks = "- ";
                        while ((i = reader.read()) != -1) {
                            tasks += (char) i;
                            if ((char) i == '\n') {
                                tasks += "- ";
                            }
                        }
                        System.out.println(tasks);
                    } catch (Exception e) {
                        System.out.println("An error occurred when fetching tasks.");
                    }
                } else {
                    System.out.println("No valid list exists! Please add a task to create a list.");
                }
                GiveOptions();
                break;
            case 2:
                System.out.print("Insert a task: ");
                String task = inputScanner.nextLine();

                try (FileWriter writer = new FileWriter("tasks.txt", true)) {
                    writer.write(task + '\n');
                } catch (Exception e) {
                    System.out.println("An error occurred when adding the task.");
                }

                GiveOptions();
                break;
            case 5:
                System.out.println("Quitting...");
                inputScanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                GiveOptions();
                break;
        }
    }
}
