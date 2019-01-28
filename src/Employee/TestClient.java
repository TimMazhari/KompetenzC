package Employee;

public class TestClient {

	public static void main(String[] args) {
		Head head = new Head();
		head.setDepartement("ABAP");
		head.setName("Tim");
		head.setPhoneNr(76);
		AtomicEmployee atomicEmployee = new AtomicEmployee();
		atomicEmployee.setName("Luca");
		atomicEmployee.setPhoneNr(79);
		head.add(atomicEmployee);
		head.print();


		System.out.println(head.getAmountEmployees());



	}

}
