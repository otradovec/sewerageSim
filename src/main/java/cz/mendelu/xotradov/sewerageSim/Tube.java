package cz.mendelu.xotradov.sewerageSim;

public class Tube {
    private String name;
    private int maxCapacity;
    private float currentAmount;

    public Tube(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentAmount = 0;
    }

    public String getName() {
        return name;
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tube)
            return this.name.equals(((Tube) obj).name);
        else return false;
    }

    public void addCurrentAmount(float currentAmount) {
        this.setCurrentAmount(getCurrentAmount()+currentAmount);
    }
}
