/**
 * AtomicEmployee class
 *
 * represents an atomic employee with its parameters and methods
 * @author Luca Schweizer and Tim Mazhari
 * @version 1.0
 */

import java.util.ArrayList;

public class AtomicEmployee extends Employee {

    //attributes
    private String job;

    //a list for all trainees from one atomic employee
    private ArrayList<Trainee> trainees = new ArrayList<Trainee>();

    //constructor
    public AtomicEmployee(String name, String departement, int phoneNr, String job) {
        super(name, departement, phoneNr);
        this.job = job;
    }

    /**
     * returns the amount of total employees
     * @return amount of employees
     */
    @Override
    public int getAmountEmployees() {
        int self = 1;
        for (Trainee trainee : trainees) {
            self += trainee.getAmountEmployees();
        }
        return self;
    }

    /**
     * prints an atomicAmployee with its parameters plus calls print() from all trainees
     */
    @Override
    public void print() {
        System.out.println("	"  + "--EMPLOYEE--" + "\n	Name: " + getName() +  "\n	PhoneNr: " + getPhoneNr() + "\n    Job: " + getJob());
        for (Trainee trainee : trainees) {
            trainee.print();
        }
    }

    /**
     * adds a new trainee to the atmoic employee's list
     * @param trainee
     */
    public void add(Trainee trainee) {
        trainees.add(trainee);
    }

    //getter
    public String getJob() {
        return job;
    }
}