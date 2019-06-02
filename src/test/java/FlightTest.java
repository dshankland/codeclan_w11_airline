import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;
    private Plane plane ;
    private GregorianCalendar dateTime;

    @Before
    public void setUp() {
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
}
