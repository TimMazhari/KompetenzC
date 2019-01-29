package Employee;

public class Trainee extends AtomicEmployee{

    private int year;

    public Trainee(String name, String departement, int phoneNr, String job, int year) {
        super(name, departement, phoneNr, job);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
