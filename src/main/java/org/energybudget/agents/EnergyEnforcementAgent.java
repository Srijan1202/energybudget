package org.energybudget.agents;
import org.energybudget.core.*;
import org.energybudget.arbitrage.MultiCloudArbitrageAgent;
import org.energybudget.models.*;
import java.util.List;
public class EnergyEnforcementAgent {
    private final EnergyBudgetManager energy;
    private final SLANegotiationEngine slaEngine = new SLANegotiationEngine();
    private final MultiCloudArbitrageAgent arbitrage = new MultiCloudArbitrageAgent();
    public EnergyEnforcementAgent(EnergyBudgetManager energy) { this.energy = energy; }
    public CloudRegion decide(SLAContract sla, List<CloudRegion> regions) {
        if (energy.nearViolation()) { sla = slaEngine.relax(sla); }
        return arbitrage.selectBest(regions, sla, energy.remaining());
    }
}