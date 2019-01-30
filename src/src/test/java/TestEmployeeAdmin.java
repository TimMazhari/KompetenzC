import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class TestEmployeeAdmin {

    EmployeeAdmin employeeAdmin = null;

    @Before
    public void setUp(){
        employeeAdmin = new EmployeeAdmin();
    }

    @Test
    public void testGetHeads(){
        ArrayList<Head> heads = new ArrayList<Head>();
        Assert.assertEquals(heads, employeeAdmin.getHeads());
    }
    @Test
    public void testGetTrainees(){
        ArrayList<Trainee> trainees = new ArrayList<Trainee>();
        Assert.assertEquals(trainees, employeeAdmin.getTrainees());
    }
    @Test
    public void testGetAtomicEmployees(){
        ArrayList<AtomicEmployee> atomicEmployees = new ArrayList<AtomicEmployee>();
        Assert.assertEquals(atomicEmployees, employeeAdmin.getAtomicEmployees());
    }

    @Test
    public void testAddAtomicToHead(){
        Head head = new Head("Luca", "ABAP", 123);
        AtomicEmployee atomicEmployee = new AtomicEmployee("Tim", "ABAP", 1234,"Appli");
        employeeAdmin.getHeads().add(head);
        employeeAdmin.addWorker(atomicEmployee);
        Assert.assertEquals(2, head.getAmountEmployees());
    }

    @Test
    public void testAddTraineeToAtomicEmployee(){
        AtomicEmployee atomicEmployee = new AtomicEmployee("Luca", "ABAP", 245, "Appli");
        Trainee trainee = new Trainee("Tim", "ABAP", 246, "Appli", 2, atomicEmployee.getName());
        employeeAdmin.getAtomicEmployees().add(atomicEmployee);
        employeeAdmin.addWorker(trainee, true);
        Assert.assertEquals(2, atomicEmployee.getAmountEmployees());

    }
}

