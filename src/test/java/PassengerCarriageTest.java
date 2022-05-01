import carriage.Carriage;
import carriage.PassengerCarriage;
import org.junit.Assert;
import org.junit.Test;
import user.Passenger;
import user.User;
import userAttributes.Ticket;
import java.util.HashMap;
import java.util.Map;

public class PassengerCarriageTest {
    @Test
    public void carriageFilling(){
        User passenger1 = new Passenger("Pasha", "Glinskiy", 21, new Ticket(11, 1));
        User passenger2 = new Passenger("Two", "Two", 18, new Ticket(12, 2));
        Carriage carriage  = new PassengerCarriage(5, 3);
        carriage.carriageFilling(passenger1);
        carriage.carriageFilling(passenger2);
        Map<Integer, User> expected = ((PassengerCarriage)carriage).getCarriage();

        Map<Integer, User> actual = new HashMap<>();
        actual.put(((Passenger) passenger1).getTicket().getNumberOfSeat(), passenger1);
        actual.put(((Passenger) passenger2).getTicket().getNumberOfSeat(), passenger2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parameterType(){
        User passenger1 = new Passenger("Pasha", "Glinskiy", 21, new Ticket(11, 1));
        Carriage carriage  = new PassengerCarriage(5, 3);
        carriage.carriageFilling(passenger1);
        String expected = passenger1.getClass().getName();

        String actual = "user.Passenger";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberOfSeats(){
        User passenger1 = new Passenger("Pasha", "Glinskiy", 21, new Ticket(11, 1));
        User passenger2 = new Passenger("Two", "Two", 18, new Ticket(12, 2));
        User passenger3 = new Passenger("Pasha", "Glinskiy", 21, new Ticket(11, 1));
        Carriage carriage  = new PassengerCarriage(5, 3);
        carriage.carriageFilling(passenger1);
        carriage.carriageFilling(passenger2);
        carriage.carriageFilling(passenger3);
        Map<Integer, User> map = ((PassengerCarriage)carriage).getCarriage();
        int expected = map.size();
        int actual = ((PassengerCarriage)carriage).getNumberOfSeats();
        Assert.assertTrue(expected <= actual);
    }
}
