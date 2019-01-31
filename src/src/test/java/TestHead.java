import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHead {

    Head head = null;

    @Before
    public void setUp(){
        head = new Head("Luca", "ABAP", 151);
    }

    @Test
    public void testAdd (){
        AtomicEmployee atomicEmployee = new AtomicEmployee("Tim", "ABAP", 145, "Appli");
        head.add(atomicEmployee);
        Assert.assertEquals(2, head.getAmountEmployees());
    }

    @Test
    public void testGetAmountEmployees(){
        Assert.assertEquals(1, head.getAmountEmployees());
    }

    @Test(expected = AssertionError.class)
    public void negativeTestAdd (){
        AtomicEmployee atomicEmployee = new AtomicEmployee("Tim", "ABAP", 145, "Appli");
        head.add(atomicEmployee);
        Assert.assertEquals(1, head.getAmountEmployees());
    }

    @Test(expected = AssertionError.class)
    public void negativeTestGetAmountEmployees(){
        Assert.assertEquals(2, head.getAmountEmployees());
    }

}
