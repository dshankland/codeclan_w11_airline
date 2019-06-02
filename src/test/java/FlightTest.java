import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FlightTest {

    private Flight flight;
    private Plane plane ;
    private GregorianCalendar dateTime;
    private Passenger passenger;

    @Before
    public void setUp() {
        passenger = new Passenger("Darren Shankland", 3);
        dateTime = new GregorianCalendar(2019, 6, 01, 17, 22);
        plane = new Plane(PlaneType.CONCORDE);
        flight = new Flight(plane, "FRN123", "SFO", "GLA", dateTime);
    }

    @Test
    public void flightHasPlaneType() {
        assertEquals(PlaneType.CONCORDE, flight.getPlane().getPlaneType());
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("FRN123", flight.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals("SFO", flight.getDestination());
    }

    @Test
    public void hasDepartureAirport() {
        assertEquals("GLA", flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime() {
        assertEquals(dateTime, flight.getDepartureTime());
    }

    @Test
    public void hasAvailableCapacity() {
        assertEquals(true, flight.hasAvailableCapacity());
    }

    @Test
    public void canBookPassengerOnFlight() {
        flight.bookPassenger(passenger);
        assertEquals(127, flight.getAvailableCapacity());
    }

    @Test
    public void canCountPassengers() {
        flight.bookPassenger(passenger);
        assertEquals(1, flight.getPassengerCount());
    }

    @Test
    public void canGetSeats() {
        assertEquals(128, flight.getSeats().size());
    }

    @Test
    public void canGetPassangerFlightNo() {
        flight.bookPassenger(passenger);
        assertEquals(flight.getFlightNumber(), passenger.getFlightNumber());
    }

    @Test
    public void canGetPassangerSeatNo() {
        flight.bookPassenger(passenger);
        assertNotEquals(0, passenger.getSeatNumber());
    }

    @Test
    public void availableSeatNumbersHaveGoneDown() {
        flight.bookPassenger(passenger);
        assertEquals(127, flight.getSeats().size());
    }
}
