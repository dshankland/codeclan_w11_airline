import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void setUp() {
        passenger = new Passenger("Darren Shankland", 2);
    }

    @Test
    public void hasName() {
        assertEquals("Darren Shankland", passenger.getName());
    }

    @Test
    public void hasBags() {
        assertEquals(2, passenger.getBags());
    }

    @Test
    public void canSetSeatNumber() {
        passenger.setSeatNumber(12);
        assertEquals(12, passenger.getSeatNumber());
    }

    @Test
    public void canSetFlightNumber() {
        passenger.setFlightNumber("ABC123");
        assertEquals("ABC123", passenger.getFlightNumber());
    }
}
