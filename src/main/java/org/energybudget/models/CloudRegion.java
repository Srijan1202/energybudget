package org.energybudget.models;
public class CloudRegion {
    private final String name;
    private final double carbon, cost;
    public CloudRegion(String name, double carbon, double cost) {
        this.name = name; this.carbon = carbon; this.cost = cost;
    }
    public String getName() { return name; }
    public double getCarbon() { return carbon; }
    public double getCost() { return cost; }
}