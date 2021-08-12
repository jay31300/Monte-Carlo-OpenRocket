package net.sf.openrocket.montecarloextension;

import net.sf.openrocket.document.Simulation;
import net.sf.openrocket.simulation.SimulationStatus;
import net.sf.openrocket.simulation.exception.SimulationException;
import net.sf.openrocket.simulation.listeners.AbstractSimulationListener;

import java.io.*;

public class MonteCarloSimulationListener extends AbstractSimulationListener {
    //user defined number of simulations to run
    public static int totalSim = 100;
    //user defined launch angle deviation
    public static double launchAngle = 0.2;
    //user defined launch direction deviation
    public static double launchDirection = 0.2;
    //user defined wind deviation
    public static double windVariation = 0.2;
    
    public MonteCarloSimulationListener() {
        super();
    }

    /**
     * A method that is fired once the user clicks on the "Start Simulation" button within open rocket
     *
     * It then proceeds to create a user defined amount of simulations and runs then all while deviating certain
     * simulation conditions
     *
     * @param status The status of the given simulation
     */
    @Override
    public void startSimulation(SimulationStatus status) throws SimulationException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "/Desktop/openrocketdatafile.txt"));
            for (int i = 0; i < totalSim; i++) {
                // Creates a copy of the simulation and randomises it (according to the inputs when creating the simulation)
                Simulation s = status.getSimulationConditions().getSimulation().copy();
                s.getSimulationExtensions().removeIf(extension -> extension instanceof MonteCarlo);
                s.getOptions().randomizeSeed();
                
                // change --- launch direction, launch angle, parachute launch time/stage
                s.getOptions().setLaunchRodAngle(s.getOptions().getLaunchRodAngle() + (Math.random() * launchAngle)-(launchAngle/2));
                s.getOptions().setLaunchRodDirection(s.getOptions().getLaunchRodDirection() + (Math.random() * launchDirection)-(launchDirection/2));
                
                // Changes the average wind speed & wind deviation
                s.getOptions().setWindSpeedAverage(s.getOptions().getWindSpeedAverage() + (Math.random() * windVariation)-(windVariation/2));
                s.getOptions().setWindSpeedDeviation(s.getOptions().getWindSpeedDeviation() + (Math.random() * windVariation)-(windVariation/2));
                
                EndSimListener egListener = new EndSimListener(writer);
                s.simulate(egListener);
            }
            writer.close();
            new MonteCarloLegacy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
