package carriage;

import user.Driver;
import user.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Locomotive implements Carriage {

    private int id;
    List<User> carriage = new ArrayList<>();
    public Locomotive(int id) {
        this.id = id;
    }
    private static final Logger log = Logger.getLogger(Locomotive.class.getName());

    @Override
    public void carriageFilling(CarriageFiller driver) {
        if (driver.getClass().getName().equals("user.Driver")){
            if (carriage.isEmpty()) {
                if (((User) driver).getAge() >= 18) {
                    carriage.add((Driver) driver);
                    log.info("Маашинист: " + driver + " добавлен");
                }else{
                    log.warning(driver + " имеет не подходящий возраст: " + ((User) driver).getAge());
                }
            } else{
                log.warning("В вагоне уже есть машинист");
            }
        }else{
            log.warning(driver + " не имеет лицензии");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getCarriage() {
        return carriage;
    }

    public void setCarriage(List<User> carriage) {
        this.carriage = carriage;
    }

    @Override
    public String toString() {
        return "Locomotive - " +
                "number: " + id +
                ", driver:" + carriage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locomotive that = (Locomotive) o;
        return id == that.id &&
                Objects.equals(carriage, that.carriage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carriage);
    }
}
