import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void setUp(){
        plane = new Plane(PlaneType.CONCORDE);
    }

    @Test
    public void hasType() {
        assertEquals(PlaneType.CONCORDE, plane.getPlaneType());
    }

    @Test
    public void hasTakeOffWeight() {
        assertEquals(185000, plane.getPlaneType().getMaximumTakeOffWeight());
    }

    @Test
    public void hasCapacity() {
        assertEquals(128, plane.getPlaneType().getCapacity());
    }
}
