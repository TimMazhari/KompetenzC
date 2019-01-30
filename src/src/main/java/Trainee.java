/**
 * Trainee class
 *
 * represents a trainee with its parameters and methods
 * @author Luca Schweizer and Tim Mazhari
 * @version 1.0
 */

public class Trainee extends AtomicEmployee{

    //attributes
    private int year;
    private String teachingMaster;

    //constructor
    public Trainee(String name, String departement, int phoneNr, String job, int year, String teachingMaster) {
        super(name, departement, phoneNr, job);
        this.year = year;
        this.teachingMaster = teachingMaster;
    }

    @Override
    public void print() {
        System.out.println("        " + "--TRAINEE--" + "\n        Name: " + getName() + "\n        PhoneNr: " + getPhoneNr() + "\n        Job: " + getJob() + "\n        Year:" + getYear());
    }

    @Override
    public int getAmountEmployees() {
        return 1;
    }

    //getter and setter
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
