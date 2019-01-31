import org.junit.Assert;
import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class TestAtomicEmployee {

    AtomicEmployee atomicEmployee = null;

    @Before
    public void setUp(){
        atomicEmployee = new AtomicEmployee("Tim", "ABAP", 123, "Appli");
    }


    @Test
    public void testGetAmountEmployees(){
        int amountEmployees = atomicEmployee.getAmountEmployees();
        Assert.assertEquals(1, amountEmployees);
    }

    @Test
    public void testGetJob(){
        String job = atomicEmployee.getJob();
        Assert.assertEquals("Appli", job);
    }

    @Test
    public void testAdd(){
        Trainee trainee = new Trainee("Luca", "ABAP", 456, "Appli", 1, "Tim");
        atomicEmployee.add(trainee);
        Assert.assertEquals(2, atomicEmployee.getAmountEmployees());

    }

    @Test(expected = AssertionError.class)
    public void negativeTestGetAmountEmployees(){
        int amountEmployees = atomicEmployee.getAmountEmployees();
        Assert.assertEquals(2, amountEmployees);
    }

    @Test(expected = AssertionError.class)
    public void negativeTestGetJob(){
        String job = atomicEmployee.getJob();
        Assert.assertEquals("Systemtechniker", job);
    }

    @Test(expected = AssertionError.class)
    public void negativeTestAdd(){
        Trainee trainee = new Trainee("Luca", "ABAP", 456, "Appli", 1, "Tim");
        atomicEmployee.add(trainee);
        Assert.assertEquals(1, atomicEmployee.getAmountEmployees());

    }

}