package cargo;
import carriage.CarriageFiller;

public class Cargo extends CarriageFiller {
    private int weight;

    public Cargo(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "weight - " + weight;
    }
}
