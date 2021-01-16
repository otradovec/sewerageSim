package cz.mendelu.xotradov.sewerageSim;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TubeTest {
    private static final double DELTA = 1e-15;
    private static final int MAX_CAP = 200;
    Tube tube;
    @Before
    public void setUp() throws Exception {
        tube = new Tube("A",MAX_CAP);
    }

    @Test
    public void testEquals() {
        assertEquals(new Tube("A",200),new Tube("A",100));
    }

    @Test
    public void getMaxCapacity() {
        assertEquals(MAX_CAP,tube.getMaxCapacity());
    }

    @Test
    public void getCurrentAmount() {
        assertEquals(0,tube.getCurrentAmount(),0);
    }

    @Test(expected = RuntimeException.class)
    public void setCurrentAmount() {
        tube.setCurrentAmount(10);
        assertEquals(10,tube.getCurrentAmount(),0);
        tube.setCurrentAmount(MAX_CAP+10);
    }

    @Test
    public void getUsagePercent(){
        assertEquals(0F,tube.getUsagePercent(),DELTA);
        tube.setCurrentAmount((float) (0.1* MAX_CAP));
        assertEquals(10F,tube.getUsagePercent(),DELTA);
    }

    @Test
    public void getName() {
        assertEquals("A",tube.getName());
    }

    @Test
    public void cloneTube() {
        Tube clone = tube.cloneTube();
        assertEquals(clone,tube);
        assertEquals(tube.getCurrentAmount(),clone.getCurrentAmount(),DELTA);
        clone.setCurrentAmount(20);
        assertNotEquals(tube.getCurrentAmount(),clone.getCurrentAmount(),DELTA);
    }
}