
package ups.edu.ec;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Rakrad07
 */
public class WindowUser extends JFrame implements ActionListener{
    
    Controlador con;
    
    public WindowUser(Controlador control){
        this.con = control;
        initComponents();
    }
    
    JLabel intro,intro2,l1,l2,l3, vacio; 
    JTextField t1,t2,t3;
    JButton b1, b2;
    
    public void initComponents(){
        setSize(450, 500);
        setTitle("Factibilidad de comprar un Vehiculo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentsWindowUser();
    }
    
    public void componentsWindowUser(){
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        
        GridBagConstraints g1 = new GridBagConstraints();
        
        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        
            intro = new JLabel("Para comenzar con la realizacion del cuestionario,");
            p1.add(intro);
            
            intro2 = new JLabel(" por favor ingrese los datos solicitados");
            p1.add(intro2);
        
        g1.gridx = 0;
        g1.gridy = 0;
        cp.add(p1, g1);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new GridBagLayout());
        GridBagConstraints g2 = new GridBagConstraints();

            l1 = new JLabel("Nombre: ");
            g2.gridx = 0;
            g2.gridy = 0;
            p2.add(l1, g2);

            t1 = new JTextField(15);
            g2.gridx = 1;
            g2.gridy = 0;
            p2.add(t1, g2);

            l2 = new JLabel("Apellido: ");
            g2.gridx = 0;
            g2.gridy = 1;
            p2.add(l2, g2);

            t2 = new JTextField(15);
            g2.gridx = 1;
            g2.gridy = 1;
            p2.add(t2, g2);

            l3 = new JLabel("Fondos: ");
            g2.gridx = 0;
            g2.gridy = 2;
            p2.add(l3, g2);

            t3 = new JTextField(15);
            g2.gridx = 1;
            g2.gridy = 2;
            p2.add(t3, g2);
            
        g1.gridx = 0;
        g1.gridy = 2;
        cp.add(p2, g1);
            
        
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        
            b1 = new JButton("Comenzar");
            b1.addActionListener(this);
            b1.setActionCommand("comenzar");
            p3.add(b1);

        g1.gridx = 0;
        g1.gridy = 4;
        cp.add(p3, g1);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("comenzar".equals(e.getActionCommand())){
            llamarWindow();
        } 
    }
    
    String nombre;
    String apellido;
    String fondo;
    
    public void llamarWindow(){
        nombre = t1.getText();
        apellido = t2.getText();
        fondo = t3.getText();
        
        Window cl = new Window(con,nombre,apellido,fondo);
        this.setVisible(false);
        cl.setVisible(true); 
    }
    
    
    
}
