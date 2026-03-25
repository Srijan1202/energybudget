import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("energy_metrics.csv",
    names=["Time","Consumed","Remaining","Region","Carbon"])

fig, (ax1, ax2) = plt.subplots(2, 1, figsize=(12, 7))

ax1.plot(df["Time"], df["Consumed"], label="Energy Consumed", color="red", linewidth=2)
ax1.plot(df["Time"], df["Remaining"], label="Energy Remaining", color="green", linewidth=2)
ax1.axhline(y=8000, color='orange', linestyle='--', label="80% Threshold (SLA kicks in)")
ax1.axhline(y=10000, color='red', linestyle=':', label="Budget Limit")
ax1.set_ylabel("Energy Units")
ax1.set_title("Energy Budget Enforcement Over Time")
ax1.legend()
ax1.grid(True)

ax2.plot(df["Time"], df["Carbon"], label="Carbon Intensity of Selected Region", color="blue", linewidth=2)
ax2.set_ylabel("Carbon Intensity")
ax2.set_xlabel("Simulation Time Steps")
ax2.legend()
ax2.grid(True)

plt.tight_layout()
plt.savefig("patent_graph.png", dpi=150)
print("Graph saved as patent_graph.png")
plt.show()