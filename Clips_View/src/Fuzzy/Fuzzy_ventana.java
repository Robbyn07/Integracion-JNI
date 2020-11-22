
package Fuzzy;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JDialogFis;

/**
 *
 * @author Usuario
 */
public class Fuzzy_ventana extends JFrame{
    private JButton btnArea;
    private JDialogFis dialogoFis;
    private FIS _FIS;
    private JSlider sldTemp;
    
    public Fuzzy_ventana(){
        super("Sistema Inferencia Difusa");
        setSize(700,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(1, 2));
        
        inicializar();
    }
    
    public void inicializar(){
        getContentPane().add(new JLabel("Temperatura: "));
        
        sldTemp = new JSlider();
        sldTemp.setMaximum(430);
        sldTemp.setMinimum(0);
        sldTemp.setPaintTicks(true);
        sldTemp.setMajorTickSpacing(30);
        sldTemp.setMinorTickSpacing(10);
        sldTemp.setPaintLabels(true);
        
        btnArea = new JButton("Area");
        btnArea.addActionListener(evt -> {
            //net.sourceforge.jFuzzyLogic.plot.JFuzzyChart.get().chart(_FIS.getVariable("velocidad").getDeffuzifier,true);
        });
        
        sldTemp.addChangeListener(evt -> {
            double val = new Integer(sldTemp.getValue()).doubleValue()/10.0;
            
            //Cargar el archivo
            _FIS = FIS.load("Logica.fcl");

            //Asignar valor a la variable y difusificamos
            _FIS.setVariable("temperatura", val);
            _FIS.evaluate(); //Realiza el calculo para defusificar

            double res = _FIS.getVariable("velocidad").getLatestDefuzzifiedValue();
            
            System.out.println("Val: " + val);
            
            dialogoFis.repaint();
            
            getContentPane().add(sldTemp);
            getContentPane().add(btnArea);
        });
        
        //Cargar el archivo
        _FIS = FIS.load("Logica.fcl");
        
        //Asignar valor a la variable y difusificamos
        _FIS.setVariable("temperatura", 26.5);
        _FIS.evaluate(); //Realiza el calculo para defusificar
        
        double res = _FIS.getVariable("velocidad").getLatestDefuzzifiedValue();
        
        System.out.println("Res: " + res);
    }
    
    
    
}
