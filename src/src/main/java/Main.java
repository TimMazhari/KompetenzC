/**
 * Main class
 *
 * manages user input and biggest part of System output
 * @author Luca Schweizer and Tim Mazhari
 * @version 1.0
 */

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

    /**
     * getUserInput()
     * getting the input for the main menu
     * @throws Exception
     */
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

    /**
     * printMenu()
     * prints main menu
     */
    private static void printMenu() {
        System.out.println("---Mitarbeiterverwaltung Menü---");
        System.out.println("[1] print all employees");
        System.out.println("[2] add new Head");
        System.out.println("[3] add new AtomicEmployee");
        System.out.println("[4] add new Trainee");
        System.out.println("[5] save and close");
    }

    /**
     * createEmployees(doJob, doYear)
     * creates new Head, AtomicEmployee or Trainee. doJob and doYear are there to diffirenciate between these 3.
     * @param doJob
     * @param doYear
     */
    private static void createEmployees(boolean doJob, boolean doYear) {
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Departement: ");
        String departement = sc.nextLine();
        System.out.println("Phone number:");
        int phoneNr = Integer.parseInt(sc.nextLine());
        //If the employee has the attribute job but not year, he is an atomic employee
        if (doJob && !doYear) {
            System.out.println("Job: ");
            String job = sc.nextLine();
            AtomicEmployee atomicEmployee = new AtomicEmployee(name, departement, phoneNr, job);
            ea.getAtomicEmployees().add(atomicEmployee);
            ea.addWorker(atomicEmployee);
        }
        //if he has the attribute year, he is a trainee
        else if (doJob && doYear) {
            System.out.println("Job: ");
            String job = sc.nextLine();
            System.out.println("Year: ");
            int year = Integer.parseInt(sc.nextLine());
            Trainee trainee = new Trainee(name, departement, phoneNr, job, year, "");
            ea.addWorker(trainee, false);
            ea.getTrainees().add(trainee);

        }
        //if he has none of them, he is a head.
        else if(!doJob && !doYear) {
            Head head = new Head(name, departement, phoneNr);
            ea.getHeads().add(head);
        }
    }
}
