package userAttributes;

public class Ticket {
    private int numberOfTicket;
    private int numberOfSeat;

    public Ticket(int numberOfTicket, int numberOfSeat) {
        this.numberOfTicket = numberOfTicket;
        this.numberOfSeat = numberOfSeat;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }

    public void setNumberOfTicket(int numberOfTicket) {
        this.numberOfTicket = numberOfTicket;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }
}
