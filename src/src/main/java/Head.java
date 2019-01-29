import java.util.ArrayList;

public class Head extends Employee{

    private ArrayList<AtomicEmployee> atomicEmployees = new ArrayList<AtomicEmployee>();

    @Override
    public void print() {
        System.out.println("HEAD" + "\nName: " + getName() + "\nPhoneNr: " + getPhoneNr() + "\nDepartement: " + getDepartement());
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

	public Head(String name, String departement, int phoneNr) {
        super(name, departement, phoneNr);
    }

    public void add(AtomicEmployee atomicEmployee) {
        atomicEmployees.add(atomicEmployee);
    }
}
