package org.energybudget.models;
public class SLAContract {
    private final double latencyMs, deadlineSec, availability;
    public SLAContract(double l, double d, double a) {
        latencyMs = l; deadlineSec = d; availability = a;
    }
    public double getLatencyMs() { return latencyMs; }
    public double getDeadlineSec() { return deadlineSec; }
    public double getAvailability() { return availability; }
}