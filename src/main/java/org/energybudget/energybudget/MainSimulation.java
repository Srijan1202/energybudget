package org.energybudget;
import org.energybudget.agents.EnergyEnforcementAgent;
import org.energybudget.core.EnergyBudgetManager;
import org.energybudget.logging.MetricsLogger;
import org.energybudget.models.*;
import java.util.List;

public class MainSimulation {
    public static void main(String[] args) {
        EnergyBudgetManager energy = new EnergyBudgetManager(10000);
        EnergyEnforcementAgent agent = new EnergyEnforcementAgent(energy);
        SLAContract sla = new SLAContract(100, 5, 99.9);

        List<CloudRegion> regions = List.of(
            new CloudRegion("AWS-US",   0.38, 0.24),
            new CloudRegion("GCP-EU",   0.16, 0.28),
            new CloudRegion("Azure-IN", 0.42, 0.19)
        );

        for (int t = 0; t < 50; t++) {
            energy.consume(250);
            CloudRegion chosen = agent.decide(sla, regions);
            MetricsLogger.log(t, energy, chosen);
            System.out.println("Time " + t +
                " | Region: " + chosen.getName() +
                " | Consumed: " + energy.getConsumed() +
                " | Remaining: " + energy.remaining() +
                (energy.nearViolation() ? " WARNING: SLA RELAXED" : ""));
        }
        System.out.println("\nDone! Check energy_metrics.csv");
    }
}