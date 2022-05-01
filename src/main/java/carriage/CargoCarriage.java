package carriage;

import cargo.Cargo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class CargoCarriage implements Carriage {

    private int loadCapacity;
    private List<Cargo> carriage = new ArrayList<>();
    private static final Logger log = Logger.getLogger(CargoCarriage.class.getName());

    public CargoCarriage(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void carriageFilling(CarriageFiller cargo) {
        if (cargo.getClass().getName().equals("cargo.Cargo")) {
            int counter = 0;
            for (Cargo entry : carriage) {
                counter += entry.getWeight();
            }
            if (this.getLoadCapacity() - counter >= ((Cargo) cargo).getWeight()) {
                carriage.add((Cargo) cargo);
                log.info("Груз весом: " + ((Cargo) cargo).getWeight() + " добавлен");
            } else {
                log.warning("В вагоне " + (this.getLoadCapacity() - counter)
                        + " свободного места, " + "груз весом: "
                        + ((Cargo) cargo).getWeight() + " не помещается");
            }
        }else log.warning("Объкт не является грузом");
    }

    public void removeCargo(){
        carriage.clear();
        log.info("Вагон очищен");
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public List<Cargo> getCarriage() {
        return carriage;
    }

    public void setCarriage(List<Cargo> carriage) {
        this.carriage = carriage;
    }

    @Override
    public String toString() {
        return "CargoCarriage - " +
                "loadCapacity: " + loadCapacity +
                ", cargo:" + carriage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoCarriage carriage1 = (CargoCarriage) o;
        return loadCapacity == carriage1.loadCapacity &&
                Objects.equals(carriage, carriage1.carriage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loadCapacity, carriage);
    }
}
