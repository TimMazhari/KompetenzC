package Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EmployeeAdmin {

    private final String PATH = "C:\\Users\\11tmazhari\\IdeaProjects\\Kompetenz C\\src\\Employee\\employees.csv";

    public ArrayList<Head> getHeads() {
        return heads;
    }

    public void setHeads(ArrayList<Head> heads) {
        this.heads = heads;
    }

    public ArrayList<AtomicEmployee> getAtomicEmployees() {
        return atomicEmployees;
    }

    public void setAtomicEmployees(ArrayList<AtomicEmployee> atomicEmployees) {
        this.atomicEmployees = atomicEmployees;
    }

    public ArrayList<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(ArrayList<Trainee> trainees) {
        this.trainees = trainees;
    }

    private ArrayList<Head> heads = new ArrayList<Head>();
    private ArrayList<AtomicEmployee> atomicEmployees = new ArrayList<AtomicEmployee>();
    private ArrayList<Trainee> trainees = new ArrayList<Trainee>();

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
                atomicEmployees.add(new AtomicEmployee(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
            }
            else {
                trainees.add(new Trainee(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5])));
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
                    ";" + trainee.getYear() + "\r\n");
        }
        pw.close();
    }

}
