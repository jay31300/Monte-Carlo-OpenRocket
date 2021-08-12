package net.sf.openrocket.montecarloextension;
import net.sf.openrocket.simulation.SimulationConditions;
import net.sf.openrocket.simulation.exception.SimulationException;
import net.sf.openrocket.simulation.extension.AbstractSimulationExtension;

public class MonteCarlo extends AbstractSimulationExtension {

    /**
     * @return provides the name of the plugin
     */
    @Override
    public String getName() {
        return "Monte Carlo Plugin";
    }

    /**
     * @return provides the description of the plugin (appears when the user clicks the 'info' button)
     */
    @Override
    public String getDescription() {
        return "This extension runs the simulation multiple times while changing the parameters of the simulation. It will then graph the results";
    }

    /**
     * Adds the simulation listener to the given simulation
     * @param conditions the conditions of the simulation
     */
    @Override
    public void initialize(SimulationConditions conditions) throws SimulationException {
        conditions.getSimulationListenerList().add(new MonteCarloSimulationListener());
    }
}