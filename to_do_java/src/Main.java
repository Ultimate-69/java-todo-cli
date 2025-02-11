import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.FileWriter;

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
        Path filepath = Paths.get("tasks.txt");

        switch (choice) {
            case 1:
                if (Files.exists(filepath))
                {
                    System.out.println("Your list of tasks:");
                    try {
                        FileReader reader = new FileReader("tasks.txt");
                        int i;
                        String tasks = "- ";
                        while ((i = reader.read()) != -1)
                        {
                            tasks += (char) i;
                            if ((char) i == '\n')
                            {
                                tasks += "- ";
                            }
                        }
                        System.out.println(tasks);
                        reader.close();
                    } catch (Exception e)
                    {
                        System.out.println("An error occured when fetching tasks.");
                    }
                }
                else
                {
                    System.out.println("No valid list exists! Please add a task to create a list.");
                }
                break;
            case 2:
                System.out.print("Insert a task: ");
                Scanner scanner = new Scanner(System.in);
                String task = scanner.nextLine();

                try {
                    FileWriter writer = new FileWriter("tasks.txt", true);
                    writer.write(task + '\n');
                    writer.close();
                } catch (Exception e) {
                    System.out.println("An error occured when adding the task.");
                }

                scanner.close();
                break;
            case 5:
                System.out.println("Quitting...");
                System.exit(0);
                break;
        
            default:
                break;
        }
    }
}
