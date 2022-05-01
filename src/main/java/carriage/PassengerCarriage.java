package carriage;

import user.Passenger;
import user.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class PassengerCarriage implements Carriage {
    private int number;
    private int numberOfSeats;
    private Map<Integer, User> carriage = new HashMap<>();
    private static final Logger log = Logger.getLogger(PassengerCarriage.class.getName());

    public PassengerCarriage(int number, int numberOfSeats) {
        this.number = number;
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void carriageFilling(CarriageFiller passenger) {
        if (passenger.getClass().getName().equals("user.Passenger")) {
            if (carriage.size() < this.getNumberOfSeats()) {
                if (!carriage.containsKey((((Passenger) passenger).getTicket().getNumberOfSeat()))) {
                    carriage.put(((Passenger) passenger).getTicket().getNumberOfSeat(), (Passenger) passenger);
                    log.info("Пассажир: " + passenger + " добавлен на "
                            + ((Passenger) passenger).getTicket().getNumberOfSeat() + " место" + " в вагон номер: " + this.getNumber());
                } else {
                    log.warning(((Passenger) passenger).getTicket().getNumberOfSeat() + " место уже занято");
                }
            } else {
                log.warning("В вагоне нету мест");
            }
        }else log.warning("Объект не является пассажиром");
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Map<Integer, User> getCarriage() {
        return carriage;
    }

    public void setCarriage(Map<Integer, User> carriage) {
        this.carriage = carriage;
    }

    @Override
    public String toString() {
        return "PassengerCarriage - " +
                "number: " + number +
                ", numberOfSeats: " + numberOfSeats +
                ", passengers: " + carriage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerCarriage that = (PassengerCarriage) o;
        return number == that.number &&
                numberOfSeats == that.numberOfSeats &&
                Objects.equals(carriage, that.carriage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, numberOfSeats, carriage);
    }
}
