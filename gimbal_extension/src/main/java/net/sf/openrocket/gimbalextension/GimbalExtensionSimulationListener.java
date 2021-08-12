package net.sf.openrocket.gimbalextension;

import net.sf.openrocket.simulation.SimulationStatus;
import net.sf.openrocket.simulation.exception.SimulationException;
import net.sf.openrocket.simulation.listeners.AbstractSimulationListener;
import net.sf.openrocket.util.Coordinate;

public class GimbalExtensionSimulationListener extends AbstractSimulationListener {
	
	private Coordinate rotation = new Coordinate(0, 0, 0);
	
	GimbalExtensionSimulationListener() {
		super();
	}
	
	@Override
	public void postStep(SimulationStatus status) throws SimulationException {
		Coordinate rotationVelocity = status.getRocketRotationVelocity();
		rotation = rotation.add(rotationVelocity);
		System.out.println("rotation: " + rotation + ", rotationVelocity: " + rotationVelocity);
	}

}
