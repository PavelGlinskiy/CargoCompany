import cargo.Cargo;
import carriage.CargoCarriage;
import carriage.Carriage;
import carriage.Locomotive;
import carriage.PassengerCarriage;
import train.LinkList;
import user.Driver;
import user.Passenger;
import user.User;
import userAttributes.License;
import userAttributes.Ticket;

public class main {
    public static void main(String[] args) {
        User passenger1 = new Passenger("Pasha", "Glinskiy", 21, new Ticket(11, 1));
        User passenger2 = new Passenger("Two", "Two", 18, new Ticket(12, 2));
        User passenger3 = new Passenger("Three", "Three", 16, new Ticket(13, 4));
        User driver1 = new Driver("One", "One", 21, new License(111));
        User driver2 = new Driver("Two", "Two", 11, new License(222));

        Carriage passengerCarriage1 = new PassengerCarriage(10,3);
        passengerCarriage1.carriageFilling(passenger1);
        passengerCarriage1.carriageFilling(passenger2);

        Carriage passengerCarriage2 = new PassengerCarriage(120,4);
        passengerCarriage2.carriageFilling(passenger3);
        passengerCarriage2.carriageFilling(passenger2);

        Carriage locomotive = new Locomotive(1);
        locomotive.carriageFilling(driver1);

        Cargo cargo1 = new Cargo(300);
        Cargo cargo2 = new Cargo(100);
        Carriage cargoCarriage1 = new CargoCarriage(500);
        cargoCarriage1.carriageFilling(cargo2);
        cargoCarriage1.carriageFilling(cargo1);

        LinkList<Carriage> train = new LinkList<Carriage>(12);
        train.insertHead(passengerCarriage1);
        train.insertHead(locomotive);
        train.insert(1, cargoCarriage1);
        train.insertTail(passengerCarriage2);
        train.print();
    }
}
