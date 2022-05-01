package user;

import userAttributes.Ticket;

public class Passenger extends User {
    private Ticket ticket;

    public Passenger(String firstName, String lastName, int age, Ticket ticket) {
        super(firstName, lastName, age);
        this.ticket = ticket;
    }

    public void buy(){

    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
