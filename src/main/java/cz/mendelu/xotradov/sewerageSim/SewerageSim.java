package cz.mendelu.xotradov.sewerageSim;

public class SewerageSim {

    public static void main(String[] args) {
        SewerageSys system = new SewerageSys();
        createStaticSystem(system);
        runFor(168,system);
    }

    private static void runFor(int steps, SewerageSys system) {
        float output;
        for (int i = 0;i<steps;i++){
            output = system.nextStep();
            System.out.println("Step "+ i +". Output "+ output +".");
            system.print();
        }
    }

    private static void createStaticSystem(SewerageSys system) {
        Tube a = new Tube("A",200);
        system.add(a);
        Tube b = new Tube("B",200);
        system.add(b);
        Tube c = new Tube("C",200);
        system.add(c);
        Tube d = new Tube("D",200);
        system.add(d);
        Tube e = new Tube("E",200);
        system.add(e);
        Tube f = new Tube("F",200);
        system.add(f);
        Tube g = new Tube("G",200);
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
