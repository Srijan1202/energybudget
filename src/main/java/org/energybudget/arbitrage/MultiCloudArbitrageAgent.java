package org.energybudget.arbitrage;
import org.energybudget.models.*;
import org.energybudget.core.UtilityEngine;
import java.util.List;
public class MultiCloudArbitrageAgent {
    public CloudRegion selectBest(List<CloudRegion> regions, SLAContract sla, double energyRemaining) {
        return regions.stream()
            .min((a, b) -> Double.compare(
                UtilityEngine.utility(a, sla, energyRemaining),
                UtilityEngine.utility(b, sla, energyRemaining)))
            .orElse(regions.get(0));
    }
}