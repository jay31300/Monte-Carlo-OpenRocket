package net.sf.openrocket.montecarloextension;

import net.sf.openrocket.document.Simulation;
import net.sf.openrocket.plugin.Plugin;
import net.sf.openrocket.simulation.extension.AbstractSwingSimulationExtensionConfigurator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@Plugin
public class MonteCarloConfigurator extends AbstractSwingSimulationExtensionConfigurator<MonteCarlo>{

    public MonteCarloConfigurator() {
        super(MonteCarlo.class);
    }

    /**
     * Defines the plugin customisation popup that appears when the plugin is added to a simulation
     *
     * @param jPanel The jPanel that is being adjusted within the method
     */
    @Override
    protected JComponent getConfigurationComponent(MonteCarlo monteCarlo, Simulation simulation, JPanel jPanel) {
        //sets the layout of the configuration window
    	jPanel.setLayout(new GridLayout(5,2));
    	
    	//gets the number of simulation 
    	JLabel label = new JLabel("Number of Simulation");
    	JTextField textField = new JTextField("100");
    	
    	//gets the launch angle deviation
    	JLabel label2 = new JLabel("Launch Angle Deviation");
        JTextField textField2 = new JTextField("0.2");

        //gets the launch direction deviation
        JLabel label3 = new JLabel("Launch Direction Deviation");
        JTextField textField3 = new JTextField("0.2");
        
        //gets the wind deviation
    	JLabel label4 = new JLabel("Wind Deviation");
        JTextField textField4 = new JTextField("0.2");
    	
    	// Run Simulation Button
        JButton simBtn = new JButton("Set Values");
        simBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //set the total number of simulation to run
                MonteCarloSimulationListener.totalSim = Integer.parseInt(textField.getText());

            	//set the value of the laungle direction deviation
                MonteCarloSimulationListener.launchAngle = Double.parseDouble(textField2.getText());

                //set the value of the launch direction deviation
                MonteCarloSimulationListener.launchDirection = Double.parseDouble(textField3.getText());

                //set the value of the wind deviation
                MonteCarloSimulationListener.windVariation = Double.parseDouble(textField4.getText());
            }
        });

        jPanel.add(label);
        jPanel.add(textField);
        jPanel.add(label2);
        jPanel.add(textField2);
        jPanel.add(label3);
        jPanel.add(textField3);
        jPanel.add(label4);
        jPanel.add(textField4);
        jPanel.add(simBtn);
        jPanel.setVisible(true);
        return jPanel;
    }
}
