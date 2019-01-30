import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

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



}