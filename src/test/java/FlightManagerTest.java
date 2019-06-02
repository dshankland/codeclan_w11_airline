import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FlightManagerTest {

    private Flight flight;
    private Plane plane ;
    private GregorianCalendar dateTime;
    private FlightManager flightManager;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;

    @Before
    public void setUp() {
        passenger1 = new Passenger("Darren Shankland", 3);
        passenger2 = new Passenger("Ann Campbell", 2);
        passenger3 = new Passenger("Bruce Wayne", 2);
        passenger4 = new Passenger("Clark Kent", 1);
        dateTime = new GregorianCalendar(2019, 6, 01, 17, 22);
        plane = new Plane(PlaneType.CONCORDE);
        flight = new Flight(plane, "FRN123", "SFO", "GLA", dateTime);
        flightManager = new FlightManager(flight);
        flightManager.getFlight().bookPassenger(passenger1);
        flightManager.getFlight().bookPassenger(passenger2);
        flightManager.getFlight().bookPassenger(passenger3);
        flightManager.getFlight().bookPassenger(passenger4);
    }

    @Test
    public void canCalculateReservedBaggageWeightForPassenger() {
        assertEquals(722, flightManager.getReservedPassengerBagWeight());
    }

    @Test
    public void canCalculateBaggageWeightBooked() {
        assertEquals(240, flightManager.getBookedBagWeight());
    }

    @Test
    public void canCalculateBaggageWeightRemaining() {
        assertEquals(92260, flightManager.getRemainingBaggageWeight());
    }

    @Test
    public void canGetLowestBookedSeatNumber() {
        assertNotEquals(0, flightManager.getLowestBookedSeatNumber());
    }

    @Test
    public void canSortPassengersBySeat() {
        flightManager.bubbleSortPassengers();
        int lowestBookedSeatNumber = flightManager.getLowestBookedSeatNumber();
        assertEquals(lowestBookedSeatNumber, flightManager.getFlight().getPassengers().get(0).getSeatNumber());
    }


}
