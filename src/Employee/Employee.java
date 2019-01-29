package Employee;

import java.util.ArrayList;

public abstract class Employee {

    private String name;
    private String departement;
    private int phoneNr;

    public Employee(String name, String departement, int phoneNr) {
        this.name = name;
        this.departement = departement;
        this.phoneNr = phoneNr;
    }

    ArrayList<Employee> allEmployees = new ArrayList<Employee>();

    public String getName() {
        return name;
    }

    public String getDepartement() {
        return departement;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public abstract int getAmountEmployees();

    public abstract void print();

}