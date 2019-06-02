import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private Flight flight;
    private Plane plane ;
    private GregorianCalendar dateTime;
    private FlightManager flightManager;
    private Passenger passenger1;
    private Passenger passenger2;

    @Before
    public void setUp() {
        passenger1 = new Passenger("Darren Shankland", 3);
        passenger2 = new Passenger("Ann Campbell", 2);
        dateTime = new GregorianCalendar(2019, 6, 01, 17, 22);
        plane = new Plane(PlaneType.CONCORDE);
        flight = new Flight(plane, "FRN123", "SFO", "GLA", dateTime);
        flightManager = new FlightManager(flight);
        flightManager.getFlight().bookPassenger(passenger1);
        flightManager.getFlight().bookPassenger(passenger2);
    }

    @Test
    public void canCalculateReservedBaggageWeightForPassenger() {
        assertEquals(722, flightManager.getReservedPassengerBagWeight());
    }

    @Test
    public void canCalculateBaggageWeightBooked() {
        assertEquals(150, flightManager.getBookedBagWeight());
    }

    @Test
    public void canCalculateBaggageWeightRemaining() {
        assertEquals(92350, flightManager.getRemainingBaggageWeight());
    }
}
