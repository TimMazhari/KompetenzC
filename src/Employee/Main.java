package Employee;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    private static boolean running = true;
    private static EmployeeAdmin ea = new EmployeeAdmin();

    public static void main(String[] args) throws IOException {
        ea.load();
        while (running) {
            getUserInput();
        }
    }

    private static void getUserInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("---Mitarbeiterverwaltung Menü---");
        System.out.println("[1] print all employees");
        System.out.println("[2] add new Head");
        System.out.println("[3] add new AtomicEmployee");
        System.out.println("[4] add new Trainee");
        System.out.println("[5] save and close");
        String input = sc.nextLine();
        switch (input) {
            case "1":
                int counter = 0;
                int counter1 = 0;
                int counter2 = 0;
                System.out.println("HEAD:");
                for (Head head: ea.getHeads()) {
                    System.out.println("Name:" + ea.getHeads().get(counter).getName());
                    System.out.println("Departement:" + ea.getHeads().get(counter).getDepartement());
                    System.out.println("Phonenr:" + ea.getHeads().get(counter).getPhoneNr());
                    counter1 = 0;
                    for (AtomicEmployee atomicEmployee: ea.getAtomicEmployees()) {
                        if (ea.getHeads().get(counter).getDepartement().equals(ea.getAtomicEmployees().get(counter1).getDepartement())){
                            System.out.println("    EMPLOYEE:");
                            System.out.println("    Name:" + ea.getAtomicEmployees().get(counter1).getName());
                            System.out.println("    Departement:" + ea.getAtomicEmployees().get(counter1).getDepartement());
                            System.out.println("    Phonenr:" + ea.getAtomicEmployees().get(counter1).getPhoneNr());
                            System.out.println("    Job:" + ea.getAtomicEmployees().get(counter1).getJob());

                        }
                        counter1++;
                        counter2 = 0;
                        for (Trainee trainee: ea.getTrainees()) {
                            if (ea.getAtomicEmployees().get(counter2).getDepartement().equals(ea.getTrainees().get(counter2).getDepartement()) &&
                                    ea.getAtomicEmployees().get(counter2).getJob().equals(ea.getTrainees().get(counter2).getJob())){
                                System.out.println("        TRAINEE:");
                                System.out.println("        Name:" + ea.getTrainees().get(counter2).getName());
                                System.out.println("        Departement:" + ea.getTrainees().get(counter2).getDepartement());
                                System.out.println("        Phonenr:" + ea.getTrainees().get(counter2).getPhoneNr());
                                System.out.println("        Job:" + ea.getTrainees().get(counter2).getJob());
                                System.out.println("        Year:" + ea.getTrainees().get(counter2).getYear());
                            }
                            counter2++;
                        }
                    }
                    counter++;
                }
                break;
            case "2":
                String headName;
                String headDepartement;
                int headPhoneNr;
                System.out.println("Name:");
                headName = sc.nextLine();
                System.out.println("Departement:");
                headDepartement = sc.nextLine();
                System.out.println("phoneNr");
                headPhoneNr = sc.nextInt();
                Head newHead = new Head(headName, headDepartement, headPhoneNr);
                ea.getHeads().add(newHead);
                ea.save();
                break;
            case "3":
                String atomicName;
                String atomicDepartement;
                int atomicPhoneNr;
                String atomicJob;
                System.out.println("Name:");
                atomicName = sc.nextLine();
                System.out.println("Departement:");
                atomicDepartement = sc.nextLine();
                System.out.println("Job:");
                atomicJob = sc.nextLine();
                System.out.println("phoneNr");
                atomicPhoneNr = sc.nextInt();
                AtomicEmployee newAtomic = new AtomicEmployee(atomicName, atomicDepartement, atomicPhoneNr, atomicJob);
                ea.getAtomicEmployees().add(newAtomic);
                ea.save();
                break;
            case "4":
                String traineeName;
                String traineeDepartement;
                int traineePhoneNr;
                int traineeYear;
                String traineeJob;
                System.out.println("Name:");
                traineeName = sc.nextLine();
                System.out.println("Departement:");
                traineeDepartement = sc.nextLine();
                System.out.println("Job:");
                traineeJob = sc.nextLine();
                System.out.println("phoneNr");
                traineePhoneNr = sc.nextInt();
                System.out.println("Year");
                traineeYear = sc.nextInt();
                Trainee newTrainee = new Trainee(traineeName, traineeDepartement, traineePhoneNr, traineeJob, traineeYear);
                ea.getTrainees().add(newTrainee);
                ea.save();
                break;
            case "5":
                ea.save();
                running = false;
                sc.close();
                System.out.println("program closed");
                break;
            default:
                System.out.println("please select an option with its number\n");
        }
    }

}
