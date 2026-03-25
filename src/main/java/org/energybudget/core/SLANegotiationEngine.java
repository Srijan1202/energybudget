package org.energybudget.core;
import org.energybudget.models.SLAContract;
public class SLANegotiationEngine {
    public SLAContract relax(SLAContract sla) {
        return new SLAContract(
            sla.getLatencyMs() * 1.25,
            sla.getDeadlineSec() * 1.3,
            sla.getAvailability()
        );
    }
}