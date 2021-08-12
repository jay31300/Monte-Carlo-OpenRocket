package net.sf.openrocket.gimbalextension;

import net.sf.openrocket.simulation.SimulationConditions;
import net.sf.openrocket.simulation.exception.SimulationException;
import net.sf.openrocket.simulation.extension.AbstractSimulationExtension;

public class GimbalExtension extends AbstractSimulationExtension {

	@Override
	public void initialize(SimulationConditions conditions) throws SimulationException {
		conditions.getSimulationListenerList().add(new GimbalExtensionSimulationListener());
	}

}
