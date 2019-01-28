package Employee;

public class AtomicEmployee extends Employee {
	@Override
	public int getAmountEmployees() {
		return 1;
	}

	@Override
	public void print() {
		System.out.println("	"  + "Angestellter" + "\n	Name : " + getName() +  "\n	Telefon: " + getPhoneNr());

	}
}