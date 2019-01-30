import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeAdmin {

    private final String PATH ="C:\\Users\\11tmazhari\\IdeaProjects\\Kompetenz C\\src\\src\\main\\java\\employees.csv";

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

    public void printAllEmployees() {
        int amountEmployee = 0;
        for (Head head : heads) {
            head.print();
            amountEmployee += head.getAmountEmployees();
        }
        System.out.println("\nThere are a total of " + amountEmployee + " employees\n\n");
    }

    public void addWorker(AtomicEmployee atomicEmployee) {
        for (Head head : heads) {
            if (head.getDepartement().equals(atomicEmployee.getDepartement())) {
                head.add(atomicEmployee);
            }
        }
    }
    //Overloaded.
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

    //read Employees.csv, create the objects and add them to the lists
    public void load() throws IOException {
        FileReader fr = new FileReader(PATH);
        BufferedReader br = new BufferedReader(fr);

        String line = "";
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts[0].equals("Head")) {
                heads.add(new Head(parts[1], parts[2], Integer.parseInt(parts[3])));
            }
            else if (parts[0].equals("AtomicEmployee")) {
                AtomicEmployee atomicEmployee = new AtomicEmployee(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                atomicEmployees.add(atomicEmployee);
                addWorker(atomicEmployee);
            }
            else {

                Trainee trainee = new Trainee(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5]), parts[6]);
                trainees.add(trainee);
                addWorker(trainee, true);
            }
        }
        br.close();
    }

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
