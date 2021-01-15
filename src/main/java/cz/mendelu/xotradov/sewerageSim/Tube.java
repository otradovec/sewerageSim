package cz.mendelu.xotradov.sewerageSim;

public class Tube {
    private int maxCapacity;
    private float currentAmount;

    public Tube(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.currentAmount = 0;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public float getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(float currentAmount) {
        if (currentAmount>this.maxCapacity)throw new RuntimeException("Pipe owerflow");
        this.currentAmount = currentAmount;
    }

    public float getUsagePercent() {
        return currentAmount/maxCapacity*100;
    }
}
