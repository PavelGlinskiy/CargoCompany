import cargo.Cargo;
import carriage.Carriage;
import carriage.Locomotive;
import org.junit.Assert;
import org.junit.Test;
import user.Driver;
import user.User;
import userAttributes.License;
import java.util.ArrayList;
import java.util.List;

public class LocomotiveCarriageTest {

    @Test
    public void carriageFilling(){
        User driver2 = new Driver("Two", "Two", 19, new License(222));
        Carriage carriage  = new Locomotive(5);
        carriage.carriageFilling(driver2);
        List<User> expected = ((Locomotive)carriage).getCarriage();

        List<User> actual = new ArrayList<>();
        actual.add(driver2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parameterType(){
        User driver2 = new Driver("Two", "Two", 19, new License(222));
        Carriage carriage  = new Locomotive(5);
        carriage.carriageFilling(driver2);
        String expected = driver2.getClass().getName();

        String actual = "user.Driver";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void havingOneDriver(){
        User driver1 = new Driver("One", "One", 19, new License(12));
        User driver2 = new Driver("Two", "Two", 29, new License(2));
        Carriage carriage  = new Locomotive(5);
        carriage.carriageFilling(driver1);
        carriage.carriageFilling(driver2);
        int expected =  ((Locomotive)carriage).getCarriage().size();

        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void suitableAge(){
        User driver1 = new Driver("One", "One", 18, new License(12));
        Carriage carriage  = new Locomotive(5);
        carriage.carriageFilling(driver1);
        int expected = driver1.getAge();

        Assert.assertTrue(expected >= 18);
    }
}
