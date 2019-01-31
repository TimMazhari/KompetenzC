/**
 * EmployeeAdmin class
 *
 * manages the logic between the user and the objects
 * @author Luca Schweizer and Tim Mazhari
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeAdmin {

    //path of the employees.csv file
    private final String PATH ="C:\\Users\\11tmazhari\\IdeaProjects\\Kompetenz C\\src\\src\\main\\java\\employees.csv";

    //lists for all kind of employees
    private ArrayList<Head> heads = new ArrayList<Head>();
    private ArrayList<AtomicEmployee> atomicEmployees = new ArrayList<AtomicEmployee>();
    private ArrayList<Trainee> trainees = new ArrayList<Trainee>();

    public ArrayList<Head> getHeads() {
        return heads;
    }

    public ArrayList<AtomicEmployee> getAtomicEmployees() {
        return atomicEmployees;
    }

    public ArrayList<Trainee> getTrainees() {
        return trainees;
    }

    /**
     * calls print() from all heads
     * prints amount of employees
     */
    public void printAllEmployees() {
        int amountEmployee = 0;
        for (Head head : heads) {
            head.print();
            amountEmployee += head.getAmountEmployees();
        }
        System.out.println("\nThere are a total of " + amountEmployee + " employees\n\n");
    }

    /**
     * Overloaded method
     * adds a new atomicEmployee to one of the heads
     * @param atomicEmployee
     */
    public void addWorker(AtomicEmployee atomicEmployee) {
        for (Head head : heads) {
            if (head.getDepartement().equals(atomicEmployee.getDepartement())) {
                head.add(atomicEmployee);
            }
        }
    }

    /**
     * Overloaded method
     * adds a new trainee to one of the atomic employees
     * @param trainee
     * @param onStart
     */
    public void addWorker(Trainee trainee, boolean onStart) {
        Scanner sc = new Scanner(System.in);
        if(onStart) {
            for (AtomicEmployee atomicEmployee : atomicEmployees) {
                if (atomicEmployee.getName().equals(trainee.getTeachingMaster())) {
                    atomicEmployee.add(trainee);
                }
            }
        }
        else {
            System.out.println("Which is his teaching master?");
            for (AtomicEmployee atomicEmployee : atomicEmployees) {
                if (atomicEmployee.getDepartement().equals(trainee.getDepartement())) {
                    System.out.println(atomicEmployee.getName());
                }
            }
            String teachingMaster = sc.nextLine();
            trainee.setTeachingMaster(teachingMaster);
            addWorker(trainee, true);
        }
    }

    /**
     * reads file and creates objects from its data
     * @throws IOException
     */
    public void load() throws IOException {
        FileReader fr = new FileReader(PATH);
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            switch (parts[0]) {
                case "Head":
                    heads.add(new Head(parts[1], parts[2], Integer.parseInt(parts[3])));
                    break;
                case "AtomicEmployee":
                    AtomicEmployee atomicEmployee = new AtomicEmployee(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                    atomicEmployees.add(atomicEmployee);
                    addWorker(atomicEmployee);
                    break;
                default:
                    Trainee trainee = new Trainee(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5]), parts[6]);
                    trainees.add(trainee);
                    addWorker(trainee, true);
                    break;
            }
        }
        br.close();
    }

    /**
     * overwrites the file with the new data
     * @throws IOException
     */
    public void save() throws IOException {
        PrintWriter pw = new PrintWriter(PATH);
        for (Head head : heads) {
            pw.print("Head;" + head.getName() +
                    ";" + head.getDepartement() +
                    ";" + head.getPhoneNr() + "\r\n");
        }
        for (AtomicEmployee atomicEmployee : atomicEmployees) {
            pw.print("AtomicEmployee;" + atomicEmployee.getName() +
                    ";" + atomicEmployee.getDepartement() +
                    ";" + atomicEmployee.getPhoneNr() +
                    ";" + atomicEmployee.getJob() + "\r\n");
        }
        for (Trainee trainee : trainees) {
            pw.print("Trainee;" + trainee.getName() +
                    ";" + trainee.getDepartement() +
                    ";" + trainee.getPhoneNr() +
                    ";" + trainee.getJob() +
                    ";" + trainee.getYear() +
                    ";" + trainee.getTeachingMaster() + "\r\n");
        }
        pw.close();
    }

}
