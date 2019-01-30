import javax.annotation.PostConstruct;

public class Trainee extends AtomicEmployee{

    private int year;
    private String teachingMaster;

    public Trainee(String name, String departement, int phoneNr, String job, int year, String teachingMaster) {
        super(name, departement, phoneNr, job);
        this.year = year;
        this.teachingMaster = teachingMaster;
    }
    @Override
    public void print() {
        System.out.println("        " + "--TRAINEE--" + "\n        Name: " + getName() + "\n        PhoneNr: " + getPhoneNr() + "\n        Job: " + getJob() + "\n        Year:" + getYear());    }
    @Override
    public int getAmountEmployees() {
        return 1;
    }

    public int getYear() {
        return year;
    }

    public String getTeachingMaster() {
        return teachingMaster;
    }

    public void setTeachingMaster(String teachingMaster) {
        this.teachingMaster = teachingMaster;
    }
}
