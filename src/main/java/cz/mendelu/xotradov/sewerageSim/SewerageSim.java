package cz.mendelu.xotradov.sewerageSim;

public class SewerageSim {

    void runFor(int steps, SewerageSys system) {
        float output;
        Tube worstInSimulation = null;
        for (int i = 0;i<steps;i++){
            output = system.nextStep();
            System.out.println("Step "+ i +". Output "+ output +".");
            system.printTubes();
            Tube weakestInStep = system.getWeakestTube();
            if (worstInSimulation==null || worstInSimulation.getUsagePercent()<weakestInStep.getUsagePercent())
                worstInSimulation = weakestInStep.cloneTube();
        }
        printWorstCase(worstInSimulation);
    }

    private static void printWorstCase(Tube worstTube) {
        System.out.println("The Worst case was on tube "+worstTube.getName()+" that had usage of "+worstTube.getUsagePercent()+" %.");
    }

    void createStaticSystem(SewerageSys system) {
        Tube a = new Tube("A",200);
        system.add(a);
        Tube b = new Tube("B",200);
        system.add(b);
        Tube c = new Tube("C",300);
        system.add(c);
        Tube d = new Tube("D",300);
        system.add(d);
        Tube e = new Tube("E",400);
        system.add(e);
        Tube f = new Tube("F",500);
        system.add(f);
        Tube g = new Tube("G",800);
        system.add(g);

        system.connect(a,e);
        system.connect(b,e);
        system.connect(c,f);
        system.connect(d,f);
        system.connect(e,g);
        system.connect(f,g);

        a.setInput(new InputTube(100,5));
        b.setInput(new InputTube(125,5));
        c.setInput(new InputTube(170,10));
        d.setInput(new InputTube(210,15));
    }
}
