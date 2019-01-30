/**
 * Employee class <<abstract>>
 *
 * represents an employee with its parameters and methods
 * @author Luca Schweizer and Tim Mazhari
 * @version 1.0
 */

public abstract class Employee {

    //attributes
    private String name;
    private String departement;
    private int phoneNr;

    //constructor
    public Employee(String name, String departement, int phoneNr) {
        this.name = name;
        this.departement = departement;
        this.phoneNr = phoneNr;
    }

    //abstract methods
    public abstract int getAmountEmployees();

    public abstract void print();

    //getter
    public String getName() {
        return name;
    }

    public String getDepartement() {
        return departement;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

}