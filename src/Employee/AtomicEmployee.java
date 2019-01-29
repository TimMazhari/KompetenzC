package Employee;

import java.util.ArrayList;
import java.util.List;

public class AtomicEmployee extends Employee {

    private String job;
    private List<Employee> trainees = new ArrayList<Employee>();

    @Override
    public int getAmountEmployees() {
        return 1;
    }

    @Override
    public void print() {
        System.out.println("	"  + "Angestellter" + "\n	Name : " + getName() +  "\n	Telefon: " + getPhoneNr());

    }


    public AtomicEmployee(String name, String departement, int phoneNr, String job) {
        super(name, departement, phoneNr);
        this.job = job;
    }

    public void add(AtomicEmployee trainee) {
        trainees.add(trainee);
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}