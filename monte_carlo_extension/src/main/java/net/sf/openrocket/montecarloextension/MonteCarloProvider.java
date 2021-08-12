package net.sf.openrocket.montecarloextension;

import net.sf.openrocket.plugin.Plugin;
import net.sf.openrocket.simulation.extension.AbstractSimulationExtensionProvider;

/**
 * Sets the Name and Sub-name of the plugin when it appears within OpenRocket
 */
@Plugin
public class MonteCarloProvider extends AbstractSimulationExtensionProvider {
    public MonteCarloProvider() {
        super(MonteCarlo.class, "Monte Carlo", "Scatter Plot");
    }
}
