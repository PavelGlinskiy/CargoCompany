import cargo.Cargo;
import carriage.CargoCarriage;
import carriage.Carriage;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CargoCarriageTest {

    @Test
    public void carriageFilling(){
        Cargo cargo1 = new Cargo(300);
        Cargo cargo2 = new Cargo(100);
        Carriage carriage  = new CargoCarriage(500);
        carriage.carriageFilling(cargo1);
        carriage.carriageFilling(cargo2);
        List<Cargo> expected = ((CargoCarriage)carriage).getCarriage();

        List<Cargo> actual = new ArrayList<>();
        actual.add(cargo1);
        actual.add(cargo2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parameterType(){
        Cargo cargo = new Cargo(300);
        Carriage carriage  = new CargoCarriage(500);
        carriage.carriageFilling(cargo);
        String expected = cargo.getClass().getName();

        String actual = "cargo.Cargo";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cargoCapacity(){
        Cargo cargo1 = new Cargo(100);
        Cargo cargo2 = new Cargo(200);
        Cargo cargo3 = new Cargo(300);
        Carriage carriage  = new CargoCarriage(500);
        carriage.carriageFilling(cargo1);
        carriage.carriageFilling(cargo2);
        carriage.carriageFilling(cargo3);
        int expected = 0;
        for (Cargo entry : ((CargoCarriage)carriage).getCarriage()) {
            expected += entry.getWeight();
        }
        int actual = ((CargoCarriage)carriage).getLoadCapacity();
        Assert.assertTrue(expected <= actual);
    }

    @Test
    public void removeCargo(){
        Cargo cargo1 = new Cargo(300);
        Cargo cargo2 = new Cargo(100);
        Carriage carriage  = new CargoCarriage(500);
        carriage.carriageFilling(cargo1);
        carriage.carriageFilling(cargo2);
        List<Cargo> expected = ((CargoCarriage)carriage).getCarriage();
        ((CargoCarriage) carriage).removeCargo();

        List<Cargo> actual = new ArrayList<>();
        actual.add(cargo1);
        actual.add(cargo2);
        actual.clear();
        Assert.assertEquals(expected, actual);
    }

}
