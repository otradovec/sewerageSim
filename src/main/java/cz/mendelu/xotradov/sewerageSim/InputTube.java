package cz.mendelu.xotradov.sewerageSim;

import java.util.Random;

public class   InputTube {
    private float mean;
    private float deviation;
    private Random random;

    public InputTube(float mean, float deviation) {
        this.mean = mean;
        this.deviation = deviation;
        random = new Random();
    }
    public  float getInput(){
        return (float) ((random.nextGaussian()*deviation) +mean);
    }

    public InputTube getClone() {
        return new InputTube(mean,deviation);
    }
}
