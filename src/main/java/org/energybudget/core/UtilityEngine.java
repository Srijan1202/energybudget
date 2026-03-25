package org.energybudget.core;
import org.energybudget.models.*;
public class UtilityEngine {
    public static double utility(CloudRegion region, SLAContract sla, double energyRemaining) {
        return CarbonCostModel.carbonPenalty(region.getCarbon()) +
               CarbonCostModel.costPenalty(region.getCost()) +
               sla.getLatencyMs() * 0.1 +
               (1.0 / energyRemaining);
    }
}