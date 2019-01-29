package Employee;

import java.util.ArrayList;

public class AtomicEmployee extends Employee {

    private String job;
    private ArrayList<Trainee> trainees = new ArrayList<Trainee>();

    @Override
    public int getAmountEmployees() {
        int self = 1;
        for (Trainee trainee : trainees) {
            self += trainee.getAmountEmployees();
        }
        return self;
    }

    @Override
    public void print() {
        System.out.println("	"  + "EMPLOYEE" + "\n	Name: " + getName() +  "\n	PhoneNr: " + getPhoneNr() + "\n Job: " + getJob());
        for (Trainee trainee : trainees) {
            trainee.print();
        }
    }

    public AtomicEmployee(String name, String departement, int phoneNr, String job) {
        super(name, departement, phoneNr);
        this.job = job;
    }

    public void add(Trainee trainee) {
        trainees.add(trainee);
    }

    public String getJob() {
        return job;
    }
}