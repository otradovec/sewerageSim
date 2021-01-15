package cz.mendelu.xotradov.sewerageSim;

import org.javatuples.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SewerageSys {
    Map<String,Tube> tubes = new HashMap<>();
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
}
