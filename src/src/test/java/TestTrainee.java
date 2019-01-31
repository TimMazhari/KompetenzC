import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class TestTrainee {

    Trainee trainee = null;
    AtomicEmployee teachingMaster = null;

    @Before
    public void setUp(){
        teachingMaster = new AtomicEmployee("Luca", "ABAP", 141, "Appli");
        trainee = new Trainee("Tim", "ABAP", 123, "Appli", 1, teachingMaster.getName());
    }

    @Test
    public void testGetTeachingMaster(){
        Assert.assertEquals("Luca", trainee.getTeachingMaster());
    }

    @Test
    public void testSetTeachingMaster(){
        trainee.setTeachingMaster("Michael");
        Assert.assertEquals("Michael", trainee.getTeachingMaster());
    }

    @Test
    public void testGetYear(){
        Assert.assertEquals(1, trainee.getYear());
    }

    @Test
    public void testGetAmountEmployees(){
        Assert.assertEquals(1, trainee.getAmountEmployees());
    }



    @Test(expected = AssertionError.class)
    public void negativeTestGetAmountEmployees(){
        Assert.assertEquals(2, trainee.getAmountEmployees());
    }

    @Test(expected = AssertionError.class)
    public void negativeTestGetTeachingMaster()
    {
        Assert.assertEquals("Tim", trainee.getTeachingMaster());
    }

    @Test(expected = AssertionError.class)
    public void negativeTestSetTeachingMaster(){
        trainee.setTeachingMaster("Michael");
        Assert.assertEquals("Luca", trainee.getTeachingMaster());
    }
    @Test(expected = AssertionError.class)
    public void negativeTestGetYear(){
        Assert.assertEquals(2, trainee.getYear());
    }


}
