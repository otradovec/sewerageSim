package cz.mendelu.xotradov.sewerageSim;

import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SewerageSys {
    Map<String,Tube> tubes = new HashMap<>();
    /**
     * First is sourceTube
     */
    List<Pair<Tube,Tube>> connections = new ArrayList<>();
    public void add(@NotNull Tube tube) {
        tubes.put(tube.getName(),tube);
    }

    public Tube getTube(String name) {
        return tubes.get(name);
    }

    public void connect(Tube tubeSource, Tube tubeDestination) {
        connections.add(Pair.with(tubeSource,tubeDestination));
    }

    public boolean isConnected(Tube tubeA, Tube tubeB) {
        for (Pair<Tube,Tube> pair : connections){
            if (pair.equals(Pair.with(tubeA,tubeB))) return true;
        }
        return false;
    }

    public Tube getWeakestTube() {
        Tube weakest = null;
        for(Tube tube : tubes.values()){
            if (weakest == null || weakest.getUsagePercent()<tube.getUsagePercent()) weakest = tube;
        }
        return weakest;
    }

    public float nextStep() {
        Tube end = findEnd();
        Float result = end.getCurrentAmount();
        end.setCurrentAmount(0);
        this.populateStep(end);
        return result;
    }

    private void populateStep(Tube endTube) {
        for (Pair<Tube,Tube> pair : connections){
            if (pair.getValue1().equals(endTube)){
                endTube.addCurrentAmount(pair.getValue0().getCurrentAmount());
                pair.getValue0().setCurrentAmount(0);
                populateStep(pair.getValue0());
            }
        }
    }

    private Tube findEnd() {
        Tube resutl = null;
        for (Tube tube: tubes.values()){
            if (isNotSource(tube)) resutl=tube;
        }
        return resutl;
    }

    private boolean isNotSource(Tube tube) {
        for (Pair<Tube,Tube> pair:connections){
            if (pair.getValue0().equals(tube)) return false;
        }
        return true;
    }
}
