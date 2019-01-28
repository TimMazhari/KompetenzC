package Employee;

public abstract class Employee {

	private String name;
	private int phoneNr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(int phoneNr) {
		this.phoneNr = phoneNr;
	}

	public abstract int getAmountEmployees();
	
	public abstract void print();

}