package net.sf.openrocket.montecarloextension;

import org.junit.Test;
import net.sf.openrocket.montecarloextension.MonteCarlo;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MonteCarloTests {
    @Test
    public void test_default_values_1() {
        MonteCarloConfigurator monteCarloConfigurator = new MonteCarloConfigurator();
        JPanel jPanel = (JPanel)monteCarloConfigurator.getConfigurationComponent(new MonteCarlo(), null, new JPanel());
        JTextField jTextField = (JTextField)jPanel.getComponent(1);
        assert jTextField.getText().equals("100");
    }
    
    @Test
    public void test_default_values_2() {
        MonteCarloConfigurator monteCarloConfigurator = new MonteCarloConfigurator();
        JPanel jPanel = (JPanel)monteCarloConfigurator.getConfigurationComponent(new MonteCarlo(), null, new JPanel());
        JTextField jTextField = (JTextField)jPanel.getComponent(3);
        assert jTextField.getText().equals("0.2");
    }
    
    @Test
    public void test_default_values_3() {
        MonteCarloConfigurator monteCarloConfigurator = new MonteCarloConfigurator();
        JPanel jPanel = (JPanel)monteCarloConfigurator.getConfigurationComponent(new MonteCarlo(), null, new JPanel());
        JTextField jTextField = (JTextField)jPanel.getComponent(5);
        assert jTextField.getText().equals("0.2");
    }
    
    @Test
    public void test_default_values_4() {
        MonteCarloConfigurator monteCarloConfigurator = new MonteCarloConfigurator();
        JPanel jPanel = (JPanel)monteCarloConfigurator.getConfigurationComponent(new MonteCarlo(), null, new JPanel());
        JTextField jTextField = (JTextField)jPanel.getComponent(5);
        assert jTextField.getText().equals("0.2");
    }
}
