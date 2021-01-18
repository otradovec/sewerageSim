package cz.mendelu.xotradov.sewerageSim;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SewerageSimTest {
    SewerageSim sewerageSim;
    @Before
    public void setUp() throws Exception {
        sewerageSim = new SewerageSim();
    }

    @Test
    public void runFor() {
        SewerageSys system = new SewerageSys();
        sewerageSim.createStaticSystem(system);
        try {
            sewerageSim.runFor(20,system);
        }catch (RuntimeException e) {
            fail();
        }
    }
}