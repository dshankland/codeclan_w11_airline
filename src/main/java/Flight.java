import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

public class Flight {

    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private GregorianCalendar departureTime;
    private ArrayList<Integer> seats;

    public Flight(Plane plane, String flightNumber, String destination, String departureAirport, GregorianCalendar departureTime) {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.seats = new ArrayList<Integer>();
        for (int seatNo=1; seatNo <= this.plane.getPlaneType().getCapacity(); seatNo++) {
            this.seats.add(seatNo);
        }
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public GregorianCalendar getDepartureTime() {
        return this.departureTime;
    }

    public Boolean hasAvailableCapacity() {
        return this.plane.getPlaneType().getCapacity() > this.getPassengers().size() ? true : false;
    }

    public int getAvailableCapacity() {
        return this.plane.getPlaneType().getCapacity() - this.passengers.size();
    }

    public ArrayList<Integer> getSeats() {
        return this.seats;
    }

    public int getAvailableSeat() {
        Random rand = new Random();
        int index = rand.nextInt(this.getSeats().size() + 1);
        return this.getSeats().remove(index);
    }

    public void bookPassenger(Passenger passenger) {
        if (this.hasAvailableCapacity()) {
            this.passengers.add(passenger);
            passenger.setFlightNumber(this.flightNumber);
            passenger.setSeatNumber(this.getAvailableSeat());
        }
    }

    public int getPassengerCount() {
        return this.passengers.size();
    }
}
