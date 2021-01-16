package cz.mendelu.xotradov.sewerageSim;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SewerageSysTest {
    private static final double DELTA = 1e-15;
    SewerageSys sewerageSys;
    Tube tubeA;
    Tube tubeB;
    Tube tubeC;
    @Before
    public void setUp() throws Exception {
        sewerageSys = new SewerageSys();
        sewerageSys.add(new Tube("A", 200));
        sewerageSys.add(new Tube("B", 200));
        sewerageSys.add(new Tube("C", 100));
        tubeA = sewerageSys.getTube("A");
        tubeB = sewerageSys.getTube("B");
        tubeC =  sewerageSys.getTube("C");
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
        sewerageSys.connect(tubeA,tubeB);
        assertTrue(sewerageSys.isConnected(tubeA,tubeB));
        assertFalse(sewerageSys.isConnected(tubeA,sewerageSys.getTube("C")));
    }

    @Test
    public void getWeakestPlace() {
        sewerageSys.connect(tubeA,tubeB);
        sewerageSys.connect(tubeC,tubeB);
        tubeA.setCurrentAmount(70);
        tubeC.setCurrentAmount(40);
        assertEquals(tubeC, sewerageSys.getWeakestTube());
        sewerageSys.nextStep();
        tubeA.setCurrentAmount(70);
        tubeC.setCurrentAmount(40);
        assertEquals(tubeB,sewerageSys.getWeakestTube());
    }

    @Test
    public void nextStep() {
        sewerageSys.connect(tubeA,tubeB);
        sewerageSys.connect(tubeC,tubeB);
        tubeA.setCurrentAmount(70);
        tubeC.setCurrentAmount(40);
        float output = sewerageSys.nextStep();
        assertEquals(0,tubeA.getCurrentAmount(),0);
        assertEquals(40+70,tubeB.getCurrentAmount(),DELTA);
        assertEquals(0,output,DELTA);
        output =sewerageSys.nextStep();
        assertEquals(40+70,output,DELTA);
        output = sewerageSys.nextStep();
        assertEquals(0,output,DELTA);
        assertEquals(0,tubeA.getCurrentAmount(),0);
    }
}