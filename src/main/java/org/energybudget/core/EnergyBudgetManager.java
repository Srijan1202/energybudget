package org.energybudget.core;
public class EnergyBudgetManager {
    private final double totalBudget;
    private double consumed = 0;
    public EnergyBudgetManager(double budget) { this.totalBudget = budget; }
    public void consume(double energy) { consumed += energy; }
    public boolean nearViolation() { return consumed >= 0.8 * totalBudget; }
    public double remaining() { return totalBudget - consumed; }
    public double getConsumed() { return consumed; }
}