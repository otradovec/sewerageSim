package cz.mendelu.xotradov.sewerageSim;

public class Tube {
    private String name;
    private int maxCapacity;
    private float currentAmount;
    private InputTube input;

    public Tube(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentAmount = 0;
    }

    private Tube(String name, int maxCapacity, float currentAmount, InputTube input) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.currentAmount = currentAmount;
        this.input=input;
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
        if (currentAmount>this.maxCapacity)
             throw new RuntimeException("Pipe "+this.name+" overflow. Capacity is "+
                this.maxCapacity+" but setting "+currentAmount);
        this.currentAmount = currentAmount;
    }

    public void setInput(InputTube input) {
        this.input = input;
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

    @Override
    public String toString() {
        return "Tube{" +
                "name '" + name + '\'' +
                ", maxCapacity " + maxCapacity +
                ", currentAmount " + currentAmount +
                '}';
    }

    public void addCurrentAmount(float currentAmount) {
        this.setCurrentAmount(getCurrentAmount()+currentAmount);
    }

    public float getInput() {
        return input!=null ? input.getInput() : 0;
    }

    public Tube cloneTube() {
        return new Tube(name,maxCapacity,currentAmount,input!=null? input.getClone():null);
    }
}
