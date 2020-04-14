
package ups.edu.ec;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.CLIPSLoadException;
import net.sf.clipsrules.jni.CaptureRouter;
import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.Router;

/**
 *
 * @author Usuario
 */
public final class Window extends JFrame implements ActionListener{
    
    private final Environment clips;
    
    //CaptureRouter mensaje;
    public Window() throws CLIPSLoadException{
        clips = new Environment();
        clips.load("baseConocimientos.clp");
        initComponents();
    }
    
    JLabel intro, q1, q2, q3, q4, q5, q6, q7, q8, q9;
    JLabel vacio;
    
    JCheckBox ch1, ch2;
    JCheckBox ch3, ch4, ch5, ch6; 
    JCheckBox ch7, ch8;
    JCheckBox ch9, ch10;
    JCheckBox ch11, ch12, ch13;
    JCheckBox ch14, ch15;
    JCheckBox ch16, ch17;
    JCheckBox ch18, ch19;
    JCheckBox ch20, ch21;
    
    JButton bt1;
    
    public void initComponents(){
        setSize(650, 950);
        setTitle("Factibilidad de comprar un Vehiculo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentsWindow();
    }
    
    public void componentsWindow(){
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        
        GridBagConstraints g1 = new GridBagConstraints();
        
        intro = new JLabel("Este cuestionario analizara si le es factible comprar o no"
                + " un vehiculo para su transporte.");
        g1.gridx = 0;
        g1.gridy = 0;
        cp.add(intro, g1);
        
        vacio = new JLabel(" ");
        g1.gridx = 0;
        g1.gridy = 1;
        cp.add(vacio, g1);
        
        q1 = new JLabel("1. El lugar de trabajo o estudio es lejano a su domicilio?");
        q1.setAlignmentX(Component.LEFT_ALIGNMENT);
        g1.gridx = 0;
        g1.gridy = 2;
        cp.add(q1, g1);
        
        JPanel pane1 = new JPanel();
        pane1.setLayout(new BoxLayout(pane1, BoxLayout.Y_AXIS));

            ch1 = new JCheckBox("Vivo lejos de mi lugar de trabajo/estudio");
            ch1.addActionListener(this);
            ch1.setActionCommand("check");
            pane1.add(ch1);

            ch2 = new JCheckBox("Vivo cerca de mi lugar de trabajo/estudio");
            ch2.addActionListener(this);
            ch2.setActionCommand("check2");
            ch2.setSelected(true);
            pane1.add(ch2);

        g1.gridx = 0;
        g1.gridy = 3;
        cp.add(pane1, g1);
        
        q2 = new JLabel("2. Tiene que salir de su casa a muy temprano y volver "
                + "muy tarde?");
        g1.gridx = 0;
        g1.gridy = 4;
        cp.add(q2, g1);
        
        JPanel pane2 = new JPanel();
        pane2.setLayout(new BoxLayout(pane2, BoxLayout.Y_AXIS));
        
            ch3 = new JCheckBox("Ambos");
            ch3.addActionListener(this);
            ch3.setActionCommand("check");
            pane2.add(ch3);

            ch4 = new JCheckBox("Salgo muy temprano");
            ch4.addActionListener(this);
            ch4.setActionCommand("check2");
            pane2.add(ch4);

            ch5 = new JCheckBox("Regreso muy tarde");
            ch5.addActionListener(this);
            ch5.setActionCommand("check3");
            pane2.add(ch5);
            
            ch6 = new JCheckBox("Ninguno");
            ch6.addActionListener(this);
            ch6.setActionCommand("check4");
            ch6.setSelected(true);
            pane2.add(ch6);
        
        g1.gridx = 0;
        g1.gridy = 5;
        cp.add(pane2, g1);
        
        q3 = new JLabel("3. Sale de su vivienda por lo menos 5 dias a la semana?");
        g1.gridx = 0;
        g1.gridy = 6;
        cp.add(q3, g1);
        
        JPanel pane3 = new JPanel();
        pane3.setLayout(new BoxLayout(pane3, BoxLayout.Y_AXIS));
        
            ch7 = new JCheckBox("Si, salgo al menos 5 veces a la semana");
            ch7.addActionListener(this);
            ch7.setActionCommand("check");
            pane3.add(ch7);

            ch8 = new JCheckBox("No, salgo menos de 5 veces a la semana");
            ch8.addActionListener(this);
            ch8.setActionCommand("check2");
            ch8.setSelected(true);
            pane3.add(ch8);
        
        g1.gridx = 0;
        g1.gridy = 7;
        cp.add(pane3, g1);
        
        q4 = new JLabel("4. En la zona donde vive existe facilidad de transporte"
                + " publico?");
        g1.gridx = 0;
        g1.gridy = 8;
        cp.add(q4, g1);
        
        JPanel pane4 = new JPanel();
        pane4.setLayout(new BoxLayout(pane4, BoxLayout.Y_AXIS));
        
            ch9 = new JCheckBox("Si");
            ch9.addActionListener(this);
            ch9.setActionCommand("check");
            ch9.setSelected(true);
            pane4.add(ch9);

            ch10 = new JCheckBox("No");
            ch10.addActionListener(this);
            ch10.setActionCommand("check2");
            pane4.add(ch10);
        
        g1.gridx = 0;
        g1.gridy = 9;
        cp.add(pane4, g1);
        
        q5 = new JLabel("5. Que metodo de viaje usa mayormente?");
        g1.gridx = 0;
        g1.gridy = 10;
        cp.add(q5, g1);
        
        JPanel pane5 = new JPanel();
        pane5.setLayout(new BoxLayout(pane5, BoxLayout.Y_AXIS));
        
            ch11 = new JCheckBox("Bus");
            ch11.addActionListener(this);
            ch11.setActionCommand("check");
            pane5.add(ch11);

            ch12 = new JCheckBox("Taxi");
            ch12.addActionListener(this);
            ch12.setActionCommand("check2");
            pane5.add(ch12);
            
            ch13 = new JCheckBox("Otro");
            ch13.addActionListener(this);
            ch13.setActionCommand("check3");
            ch13.setSelected(true);
            pane5.add(ch13);
        
        g1.gridx = 0;
        g1.gridy = 11;
        cp.add(pane5, g1);
        
        q6 = new JLabel("6. Cuando se transporta lo hace con algun acompañante?");
        g1.gridx = 0;
        g1.gridy = 12;
        cp.add(q6, g1);
        
        JPanel pane6 = new JPanel();
        pane6.setLayout(new BoxLayout(pane6, BoxLayout.Y_AXIS));
        
            ch14 = new JCheckBox("Si");
            ch14.addActionListener(this);
            ch14.setActionCommand("check");
            pane6.add(ch14);

            ch15 = new JCheckBox("No, siempre solo");
            ch15.addActionListener(this);
            ch15.setActionCommand("check2");
            ch15.setSelected(true);
            pane6.add(ch15);
        
        g1.gridx = 0;
        g1.gridy = 13;
        cp.add(pane6, g1);
        
        q7 = new JLabel("7. Considera que por su trabajo, estudio o alguna otra "
                + "razon tendra que hacer esta rutina por mucho tiempo?");
        g1.gridx = 0;
        g1.gridy = 14;
        cp.add(q7, g1);
        
        JPanel pane7 = new JPanel();
        pane7.setLayout(new BoxLayout(pane7, BoxLayout.Y_AXIS));
        
            ch16 = new JCheckBox("Si");
            ch16.addActionListener(this);
            ch16.setActionCommand("check");
            pane7.add(ch16);

            ch17 = new JCheckBox("No");
            ch17.addActionListener(this);
            ch17.setActionCommand("check2");
            ch17.setSelected(true);
            pane7.add(ch17);
        
        g1.gridx = 0;
        g1.gridy = 15;
        cp.add(pane7, g1);
        
        q8 = new JLabel("8. Se considera con estabilidad economica suficientre "
                + "para mantener un vehiculo?");
        g1.gridx = 0;
        g1.gridy = 16;
        cp.add(q8, g1);
        
        JPanel pane8 = new JPanel();
        pane8.setLayout(new BoxLayout(pane8, BoxLayout.Y_AXIS));
        
            ch18 = new JCheckBox("Si");
            ch18.addActionListener(this);
            ch18.setActionCommand("check");
            pane8.add(ch18);

            ch19 = new JCheckBox("No");
            ch19.addActionListener(this);
            ch19.setActionCommand("check2");
            ch19.setSelected(true);
            pane8.add(ch19);
        
        g1.gridx = 0;
        g1.gridy = 17;
        cp.add(pane8, g1);
        
        q9 = new JLabel("9. Tiene licencia de conducir?");
        g1.gridx = 0;
        g1.gridy = 18;
        cp.add(q9, g1);
        
        JPanel pane9 = new JPanel();
        pane9.setLayout(new BoxLayout(pane9, BoxLayout.Y_AXIS));
        
            ch20 = new JCheckBox("Si");
            ch20.addActionListener(this);
            ch20.setActionCommand("check");
            pane9.add(ch20);

            ch21 = new JCheckBox("No");
            ch21.addActionListener(this);
            ch21.setActionCommand("check2");
            ch21.setSelected(true);
            pane9.add(ch21);
        
        g1.gridx = 0;
        g1.gridy = 19;
        cp.add(pane9, g1);
        
        JPanel pane10 = new JPanel();
        pane10.setLayout(new FlowLayout());
        
            bt1 = new JButton("Calcular");
            bt1.addActionListener(this);
            bt1.setActionCommand("calcular");
            pane10.add(bt1);
            
        g1.gridx = 0;
        g1.gridy = 20;
        cp.add(pane10, g1);         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("check".equals(e.getActionCommand())){
            habilitar();
        }
        
        if("check2".equals(e.getActionCommand())){
            habilitar2();
        }
        
        if("check3".equals(e.getActionCommand())){
            habilitar3();
        }
        
        if("check4".equals(e.getActionCommand())){
            habilitar4();
        }
        
        if("calcular".equals(e.getActionCommand())){
            obtener_resultados();
        }  
    }
 
    String a1;
    String a2;
    String a3;
    String a4;
    String a5;
    String a6;
    String a7;
    String a8;
    String a9;
    /**
    JCheckBox ch16, ch17;
    JCheckBox ch18, ch19;
    JCheckBox ch20, ch21;
    **/
    public void habilitar(){
        if(ch1.isSelected()){
            ch2.setSelected(false);
        }
        
        if(ch3.isSelected()){
            ch4.setSelected(false);
            ch5.setSelected(false);
            ch6.setSelected(false);
        }
        
        if(ch7.isSelected()){
            ch8.setSelected(false);
        }
        
        if(ch9.isSelected()){
            ch10.setSelected(false);
        }
        
        if(ch11.isSelected()){
            ch12.setSelected(false);
            ch13.setSelected(false);
        }
        
        if(ch14.isSelected()){
            ch15.setSelected(false);
        }
        
        if(ch16.isSelected()){
            ch17.setSelected(false);
        }
        
        if(ch18.isSelected()){
            ch19.setSelected(false);
        }
        
        if(ch20.isSelected()){
            ch21.setSelected(false);
        }
    }
    
    public void habilitar2(){
        if(ch2.isSelected()){
            ch1.setSelected(false);
        }
        
        if(ch4.isSelected()){
            ch3.setSelected(false);
            ch5.setSelected(false);
            ch6.setSelected(false);
        }
        
        if(ch8.isSelected()){
            ch7.setSelected(false);
        }
        
        if(ch10.isSelected()){
            ch9.setSelected(false);
        }
        
        if(ch12.isSelected()){
            ch11.setSelected(false);
            ch13.setSelected(false);
        }
        
        if(ch15.isSelected()){
            ch14.setSelected(false);
        }
        
        if(ch17.isSelected()){
            ch16.setSelected(false);
        }
        
        if(ch19.isSelected()){
            ch18.setSelected(false);
        }
        
        if(ch21.isSelected()){
            ch20.setSelected(false);
        }
    }
    
    public void habilitar3(){
        if(ch5.isSelected()){
            ch3.setSelected(false);
            ch4.setSelected(false);
            ch6.setSelected(false);
        }
        
        if(ch13.isSelected()){
            ch11.setSelected(false);
            ch12.setSelected(false);
        }
    }
    
    public void habilitar4(){
        if(ch6.isSelected()){
            ch3.setSelected(false);
            ch4.setSelected(false);
            ch5.setSelected(false);
        }
    }
    
    public void obtener_resultados(){
        //Primera Respuesta
        if(ch1.isSelected()){
            a1 = "lejos";
        } 
        if(ch2.isSelected()){
            a1 = "cerca";
        }
        
        //Segunda Respuesta
        if(ch3.isSelected()){
            a2 = "ambos";
        } 
        if(ch4.isSelected()){
            a2 = "temprano";
        }
        if(ch5.isSelected()){
            a2 = "tarde";
        }
        if(ch6.isSelected()){
            a2 = "ninguno";
        }
        
        //Tercera Respuesta
        if(ch7.isSelected()){
            a3 = "si";
        }
        if(ch8.isSelected()){
            a3 = "no";
        }
        
        //Cuarta Respuesta
        if(ch9.isSelected()){
            a4 = "si";
        }
        if(ch10.isSelected()){
            a4 = "no";
        }
        
        //Quinta Respuesta
        if(ch11.isSelected()){
            a5 = "bus";
        }
        if(ch12.isSelected()){
            a5 = "taxi";
        }
        if(ch13.isSelected()){
            a5 = "otro";
        }
        
        //Sexta Respuesta
        if(ch14.isSelected()){
            a6 = "si";
        }
        if(ch15.isSelected()){
            a6 = "no";
        }
        
        //Septima Respuesta
        if(ch16.isSelected()){
            a7 = "si";
        }
        if(ch17.isSelected()){
            a7 = "no";
        }
        
        //Octava Respuesta
        if(ch18.isSelected()){
            a8 = "si";
        }
        if(ch19.isSelected()){
            a8 = "no";
        }
        
        //Novena Respuesta
        if(ch20.isSelected()){
            a9 = "si";
        }
        if(ch21.isSelected()){
            a9 = "no";
        }
        mandarBase(a1, a2, a3, a4, a5, a6, a7, a8, a9);
    }
       
    public void mandarBase(String a1, String a2, String a3, String a4, String a5, 
            String a6, String a7, String a8, String a9){  
        
        try {
            clips.reset();
            
            clips.eval("(assert (cuestionario (lejano \"" + a1 + "\") "
                            + "(salir \"" + a2 + "\") "
                            + "(veces \"" + a3 + "\") "
                            + "(factibilidad \"" + a4 + "\") "
                            + "(metodo \"" + a5 + "\") "
                            + "(acompaniante \"" + a6 + "\") "
                            + "(rutina \"" + a7 + "\") "
                            + "(estabilidad \"" + a8 + "\") "
                            + "(licencia \"" + a9 + "\")"
                    + "))");
            
            CaptureRouter mensaje = new CaptureRouter(clips, new String[] {Router.STDOUT});
            
            clips.run();
            JOptionPane.showMessageDialog(this, mensaje.getOutput());
            
        } catch (CLIPSException e) {
            e.printStackTrace();
        }   
    }
    
}
