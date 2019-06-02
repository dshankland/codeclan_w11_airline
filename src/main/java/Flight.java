import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Flight {


    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private GregorianCalendar departureTime;

    public Flight(Plane plane, String flightNumber, String destination, String departureAirport, GregorianCalendar departureTime) {
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
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
}
