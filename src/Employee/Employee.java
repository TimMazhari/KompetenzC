package Employee;

public abstract class Employee {

    private String name;
    private String departement;
    private int phoneNr;

    public Employee(String name, String departement, int phoneNr) {
        this.name = name;
        this.departement = departement;
        this.phoneNr = phoneNr;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDepartement() {return departement;}

    public void setDepartement(String departement){this.departement = departement;}

    public int getPhoneNr() {return phoneNr;}

    public void setPhoneNr(int phoneNr) {this.phoneNr = phoneNr;}

    public abstract int getAmountEmployees();

    public abstract void print();

}