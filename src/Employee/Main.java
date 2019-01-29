package Employee;

import java.util.Scanner;

public class Main {

    private static boolean running = true;
    private static EmployeeAdmin ea = new EmployeeAdmin();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ea.load();
        while (running) {
            getUserInput();
        }
    }

    private static void getUserInput() throws Exception {
        printMenu();
        String input = sc.nextLine();
        switch (input) {
            case "1":
                ea.printAllEmployees();
                break;
            case "2":
                createEmployees(false,false);
                break;
            case "3":
                createEmployees(true, false);
                break;
            case "4":
                createEmployees(true, true);
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

    private static void printMenu() {
        System.out.println("---Mitarbeiterverwaltung Menü---");
        System.out.println("[1] print all employees");
        System.out.println("[2] add new Head");
        System.out.println("[3] add new AtomicEmployee");
        System.out.println("[4] add new Trainee");
        System.out.println("[5] save and close");
    }

    private static void createEmployees(boolean doJob, boolean doYear) {
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Departement: ");
        String departement = sc.nextLine();
        System.out.println("Phone number:");
        int phoneNr = Integer.parseInt(sc.nextLine());
        if (doJob && !doYear) {
            System.out.println("Job: ");
            String job = sc.nextLine();
            AtomicEmployee atomicEmployee = new AtomicEmployee(name, departement, phoneNr, job);
            ea.getAtomicEmployees().add(atomicEmployee);
            ea.addToHead(atomicEmployee);
        }
        else if (doYear) {
            System.out.println("Job: ");
            String job = sc.nextLine();
            System.out.println("Year: ");
            int year = Integer.parseInt(sc.nextLine());
            Trainee trainee = new Trainee(name, departement, phoneNr, job, year);
            ea.getTrainees().add(trainee);
            ea.addToAtomicEmployee(trainee, false);
        }
        else {
            Head head = new Head(name, departement, phoneNr);
            ea.getHeads().add(head);
        }
    }
}
