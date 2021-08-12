package net.sf.openrocket.montecarloextension;

import net.sf.openrocket.simulation.SimulationStatus;
import net.sf.openrocket.simulation.exception.SimulationException;
import net.sf.openrocket.simulation.listeners.AbstractSimulationListener;

import java.io.BufferedWriter;
import java.io.IOException;

public class EndSimListener extends AbstractSimulationListener {

    private final BufferedWriter writer;

    public EndSimListener(BufferedWriter writer) {
        this.writer = writer;
    }

    /**
     * At the end of every simulation it will write the landing position to a txt file
     */
    @Override
    public void endSimulation(SimulationStatus status, SimulationException exception) {
        try {
            writer.write(status.getRocketPosition().x + "," + status.getRocketPosition().y +  "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
