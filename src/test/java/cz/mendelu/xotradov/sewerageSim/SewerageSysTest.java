package cz.mendelu.xotradov.sewerageSim;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SewerageSysTest {
    SewerageSys sewerageSys;
    @Before
    public void setUp() throws Exception {
        sewerageSys = new SewerageSys();
        sewerageSys.add(new Tube("A", 200));
        sewerageSys.add(new Tube("B", 200));
        sewerageSys.add(new Tube("C", 100));
    }

    @Test
    public void getTube() {
        Tube tube = new Tube("Z",30);
        sewerageSys.add(tube);
        assertEquals(tube,sewerageSys.getTube("Z"));
        assertNotEquals(tube,sewerageSys.getTube("A"));
    }

    @Test
    public void connect(){
        Tube tubeA = sewerageSys.getTube("A");
        Tube tubeB = sewerageSys.getTube("B");
        sewerageSys.connect(tubeA,tubeB);
        assertTrue(sewerageSys.isConnected(tubeA,tubeB));
        assertFalse(sewerageSys.isConnected(tubeA,sewerageSys.getTube("C")));
    }
}