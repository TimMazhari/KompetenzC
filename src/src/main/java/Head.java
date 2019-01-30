/**
 * Head class
 *
 * represents a Head with its parameters and methods
 * @author Luca Schweizer and Tim Mazhari
 * @version 1.0
 */

import java.util.ArrayList;

public class Head extends Employee{

    //a list for all employees from one head
    private ArrayList<AtomicEmployee> atomicEmployees = new ArrayList<AtomicEmployee>();

    //constructor
    public Head(String name, String departement, int phoneNr) {
        super(name, departement, phoneNr);
    }

    @Override
    public void print() {
        System.out.println("--HEAD--" + "\nName: " + getName() + "\nPhoneNr: " + getPhoneNr() + "\nDepartement: " + getDepartement());
        for (AtomicEmployee atomicEmployee: atomicEmployees) {
            atomicEmployee.print();
        }
    }

    @Override
    public int getAmountEmployees() {
        int self = 1;
        for (AtomicEmployee atomicEmployee : atomicEmployees) {
            self += atomicEmployee.getAmountEmployees();
        }
        return self;
    }

    /**
     * adds a new atomic employee to the head's list
     * @param atomicEmployee
     */
    public void add(AtomicEmployee atomicEmployee) {
        atomicEmployees.add(atomicEmployee);
    }

}
