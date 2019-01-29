package Employee;

import java.io.IOException;
import java.util.Scanner;

public class TestClient {

    private static boolean running = true;
    private static EmployeeAdmin ea = new EmployeeAdmin();

    public static void main(String[] args) throws IOException {
        ea.load();
        while (running) {
            getUserInput();
        }
    }

    private static void getUserInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Mitarbeiterverwaltung Menü---");
        System.out.println("[1] print all employees");
        System.out.println("[2] add new Head");
        System.out.println("[3] add new AtomicEmployee");
        System.out.println("[4] add new Trainee");
        System.out.println("[5] save and close");
        String input = sc.nextLine();
        switch (input) {
            case "1":
                //
                break;
            case "2":
                //
                break;
            case "3":
                //
                break;
            case "4":
                //
                break;
            case "5":
                ea.save();
                running = false;
                sc.close();
                System.out.println("program closed");
                break;
            default:
                System.out.println("please select an option with its number\n");
        }
    }

}
