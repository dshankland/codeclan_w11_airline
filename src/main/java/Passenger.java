public class Passenger {

    private String name;
    private int bags;
    private String flightNumber;
    private int seatNumber;

    public Passenger(String name, int bags) {
        this.name = name;
        this.bags = bags;
        this.flightNumber = null;
    }

    public String getName() {
        return this.name;
    }

    public int getBags() {
        return this.bags;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
