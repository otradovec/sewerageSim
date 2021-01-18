package cz.mendelu.xotradov.sewerageSim;

public class Main {
    public static void main(String[] args) {
        SewerageSim sewerageSim = new SewerageSim();
        SewerageSys system = new SewerageSys();
        sewerageSim.createStaticSystem(system);
        sewerageSim.runFor  (168,system);
    }
}
