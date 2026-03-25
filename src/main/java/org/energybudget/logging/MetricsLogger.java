package org.energybudget.logging;
import org.energybudget.core.EnergyBudgetManager;
import org.energybudget.models.CloudRegion;
import java.io.FileWriter;
public class MetricsLogger {
    public static void log(int time, EnergyBudgetManager energy, CloudRegion region) {
        try (FileWriter fw = new FileWriter("energy_metrics.csv", true)) {
            fw.write(time + "," + energy.getConsumed() + "," +
                     energy.remaining() + "," + region.getName() + "," +
                     region.getCarbon() + "\n");
        } catch (Exception e) { e.printStackTrace(); }
    }
}