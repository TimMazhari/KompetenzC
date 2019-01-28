package Employee;

import java.util.ArrayList;
import java.util.List;

public class Head extends Employee{

	private String departement;

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	private List<Employee> employees = new ArrayList<Employee>();
	
	public void print() {
		System.out.println("Abteilungsleiter" + "\nName: " + getName() + "\nTelefon: " + getPhoneNr() + "\nAbteilung: " + getDepartement());
		for (Employee employee: employees) {
			employee.print();
		}
	}
	
	public void add(Employee employee) {
		employees.add(employee);
	}
	
	public void remove(Employee employee) {
		employees.remove(employee);
	}
	
	public Employee getEmployee(int index) {
		return employees.get(index);
	}
	
	public int getAmountEmployees() {
		int self = 1;
		for (Employee employee : employees) {
			self += employee.getAmountEmployees();
		}
		return self;
	}
	
}