package org.energybudget.core;
public class CarbonCostModel {
    public static double carbonPenalty(double intensity) { return intensity * 0.6; }
    public static double costPenalty(double cost) { return cost * 0.4; }
}