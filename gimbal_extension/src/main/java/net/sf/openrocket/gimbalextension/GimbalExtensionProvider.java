package net.sf.openrocket.gimbalextension;

import net.sf.openrocket.gimbalextension.GimbalExtension;
import net.sf.openrocket.plugin.Plugin;
import net.sf.openrocket.simulation.extension.AbstractSimulationExtensionProvider;

@Plugin
public class GimbalExtensionProvider extends AbstractSimulationExtensionProvider {

	public GimbalExtensionProvider() {
		super(GimbalExtension.class, "PID Motor Gimbaling");
	}
	
}
