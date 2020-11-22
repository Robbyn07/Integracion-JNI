
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
import javax.swing.JPanel;

/**
 *
 * @author Rakrad07
 */
public final class Window extends JFrame implements ActionListener{
    
    Controlador con;
    String nombre;
    String apellido;
    String fondo;
    
    public Window(Controlador control,String no, String ap, String fo){
        this.con = control;
        this.nombre = no;
        this.apellido = ap;
        this.fondo = fo;
        initComponents();
    }
    
    JLabel intro, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11;
    JLabel vacio;
    
    JCheckBox ch1, ch2, ch3; //Chexbox usados para la primera pregunta
    JCheckBox ch4, ch5, ch6; //Chexbox usados para la segunda pregunta
    JCheckBox ch7, ch8; //Chexbox usados para la tercera pregunta
    JCheckBox ch9, ch10; //Chexbox usados para la cuarta pregunta
    JCheckBox ch11, ch12; //Chexbox usados para la quinta pregunta
    JCheckBox ch13, ch14; //Chexbox usados para la sexta pregunta
    JCheckBox ch15, ch16; //Chexbox usados para la septima pregunta
    JCheckBox ch17, ch18; //Chexbox usados para la octava pregunta
    JCheckBox ch19, ch20; //Chexbox usados para la novema pregunta
    JCheckBox ch21, ch22, ch23; //Chexbox usados para la decima pregunta
    JCheckBox ch24, ch25, ch26; //Chexbox usados para la decimo primera pregunta
    
    JButton bt1,bt2;
    
    public void initComponents(){
        setSize(900, 1000);
        setTitle("Factibilidad de comprar un Vehiculo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //loadData();
        componentsWindow();
    }
    
    public void componentsWindow(){
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        
        GridBagConstraints g1 = new GridBagConstraints();
        
        intro = new JLabel("Este cuestionario analizara si usted requiere de un vehiculo, ademas le brinda algunas posibles opciones"
                + " que se adaptan a sus necesidades.");
        g1.gridx = 0;
        g1.gridy = 0;
        cp.add(intro, g1);
        
        vacio = new JLabel();
        g1.gridx = 0;
        g1.gridy = 1;
        cp.add(vacio, g1);
        
        q1 = new JLabel("1. ¿Usted se reconoce como un usuario de transporte público(buses) o privado(taxis)?");
        q1.setAlignmentX(Component.LEFT_ALIGNMENT);
        g1.gridx = 0;
        g1.gridy = 2;
        cp.add(q1, g1);
        
        JPanel pane1 = new JPanel();
        pane1.setLayout(new BoxLayout(pane1, BoxLayout.Y_AXIS));

            ch1 = new JCheckBox("Privado");
            ch1.addActionListener(this);
            ch1.setActionCommand("check");
            pane1.add(ch1);

            ch2 = new JCheckBox("Publico");
            ch2.addActionListener(this);
            ch2.setActionCommand("check2");
            pane1.add(ch2);
            
            ch3 = new JCheckBox("Otro");
            ch3.addActionListener(this);
            ch3.setActionCommand("check3");
            ch3.setSelected(true);
            pane1.add(ch3);

        g1.gridx = 0;
        g1.gridy = 3;
        cp.add(pane1, g1);
        
        q2 = new JLabel("2. ¿Comúnmente realiza viajes familiares o con más de 4 personas?");
        g1.gridx = 0;
        g1.gridy = 4;
        cp.add(q2, g1);
        
        JPanel pane2 = new JPanel();
        pane2.setLayout(new BoxLayout(pane2, BoxLayout.Y_AXIS));

            ch4 = new JCheckBox("Si");
            ch4.addActionListener(this);
            ch4.setActionCommand("check");
            pane2.add(ch4);

            ch5 = new JCheckBox("No, viajo en solitario");
            ch5.addActionListener(this);
            ch5.setActionCommand("check2");
            pane2.add(ch5);
            
            ch6 = new JCheckBox("No");
            ch6.addActionListener(this);
            ch6.setActionCommand("check3");
            ch6.setSelected(true);
            pane2.add(ch6);
        
        g1.gridx = 0;
        g1.gridy = 5;
        cp.add(pane2, g1);
        
        q3 = new JLabel("3. ¿Realiza actividades cotidianas como comprar en mercados o supermercados?");
        g1.gridx = 0;
        g1.gridy = 6;
        cp.add(q3, g1);
        
        JPanel pane3 = new JPanel();
        pane3.setLayout(new BoxLayout(pane3, BoxLayout.Y_AXIS));
        
            ch7 = new JCheckBox("Si");
            ch7.addActionListener(this);
            ch7.setActionCommand("check");
            pane3.add(ch7);

            ch8 = new JCheckBox("No");
            ch8.addActionListener(this);
            ch8.setActionCommand("check2");
            ch8.setSelected(true);
            pane3.add(ch8);
        
        g1.gridx = 0;
        g1.gridy = 7;
        cp.add(pane3, g1);
        
        q4 = new JLabel("4. Al realizar compras, ¿Lo hace con algún acompañante?");
        g1.gridx = 0;
        g1.gridy = 8;
        cp.add(q4, g1);
        
        JPanel pane4 = new JPanel();
        pane4.setLayout(new BoxLayout(pane4, BoxLayout.Y_AXIS));
        
            ch9 = new JCheckBox("Si");
            ch9.addActionListener(this);
            ch9.setActionCommand("check");
            pane4.add(ch9);

            ch10 = new JCheckBox("No");
            ch10.addActionListener(this);
            ch10.setActionCommand("check2");
            ch10.setSelected(true);
            pane4.add(ch10);
        
        g1.gridx = 0;
        g1.gridy = 9;
        cp.add(pane4, g1);
        
        q5 = new JLabel("5. Al realizar compras, ¿Carga manualmente las compras?");
        g1.gridx = 0;
        g1.gridy = 10;
        cp.add(q5, g1);
        
        JPanel pane5 = new JPanel();
        pane5.setLayout(new BoxLayout(pane5, BoxLayout.Y_AXIS));
        
            ch11 = new JCheckBox("Si");
            ch11.addActionListener(this);
            ch11.setActionCommand("check");
            ch11.setSelected(true);
            pane5.add(ch11);

            ch12 = new JCheckBox("No");
            ch12.addActionListener(this);
            ch12.setActionCommand("check2");
            pane5.add(ch12);
        
        g1.gridx = 0;
        g1.gridy = 11;
        cp.add(pane5, g1);
        
        q6 = new JLabel("6. ¿Se desplaza con frecuencia a lugares de trabajo o estudio?");
        g1.gridx = 0;
        g1.gridy = 12;
        cp.add(q6, g1);
        
        JPanel pane6 = new JPanel();
        pane6.setLayout(new BoxLayout(pane6, BoxLayout.Y_AXIS));
        
            ch13 = new JCheckBox("Si");
            ch13.addActionListener(this);
            ch13.setActionCommand("check");
            pane6.add(ch13);

            ch14 = new JCheckBox("No");
            ch14.addActionListener(this);
            ch14.setActionCommand("check2");
            ch14.setSelected(true);
            pane6.add(ch14);
        
        g1.gridx = 0;
        g1.gridy = 13;
        cp.add(pane6, g1);
        
        q7 = new JLabel("7. ¿Su vivienda se encuentra dentro de una zona rural o urbana?");
        g1.gridx = 0;
        g1.gridy = 14;
        cp.add(q7, g1);
        
        JPanel pane7 = new JPanel();
        pane7.setLayout(new BoxLayout(pane7, BoxLayout.Y_AXIS));
        
            ch15 = new JCheckBox("Rural");
            ch15.addActionListener(this);
            ch15.setActionCommand("check");
            ch15.setSelected(true);
            pane7.add(ch15);

            ch16 = new JCheckBox("Urbana");
            ch16.addActionListener(this);
            ch16.setActionCommand("check2");
            pane7.add(ch16);
        
        g1.gridx = 0;
        g1.gridy = 15;
        cp.add(pane7, g1);
        
        q8 = new JLabel("8. ¿El lugar de trabajo o estudio al que acude se encuentra cerca de su vivienda? *Menor a 5 Km*");
        g1.gridx = 0;
        g1.gridy = 16;
        cp.add(q8, g1);
        
        JPanel pane8 = new JPanel();
        pane8.setLayout(new BoxLayout(pane8, BoxLayout.Y_AXIS));
        
            ch17 = new JCheckBox("Si");
            ch17.addActionListener(this);
            ch17.setActionCommand("check");
            ch17.setSelected(true);
            pane8.add(ch17);

            ch18 = new JCheckBox("No");
            ch18.addActionListener(this);
            ch18.setActionCommand("check2");
            pane8.add(ch18);
        
        g1.gridx = 0;
        g1.gridy = 17;
        cp.add(pane8, g1);
        
        q9 = new JLabel("9. Según su localidad, ¿Posee fácil acceso al transporte público?");
        g1.gridx = 0;
        g1.gridy = 18;
        cp.add(q9, g1);
        
        JPanel pane9 = new JPanel();
        pane9.setLayout(new BoxLayout(pane9, BoxLayout.Y_AXIS));
        
            ch19 = new JCheckBox("Facil Acceso");
            ch19.addActionListener(this);
            ch19.setActionCommand("check");
            ch19.setSelected(true);
            pane9.add(ch19);

            ch20 = new JCheckBox("Dificil Acceso");
            ch20.addActionListener(this);
            ch20.setActionCommand("check2");
            pane9.add(ch20);
        
        g1.gridx = 0;
        g1.gridy = 19;
        cp.add(pane9, g1);
        
        q10 = new JLabel("10. ¿Posee una licencia de conducir o está en proceso de adquirir una?");
        g1.gridx = 0;
        g1.gridy = 20;
        cp.add(q10, g1);
        
        JPanel pane10 = new JPanel();
        pane10.setLayout(new BoxLayout(pane10, BoxLayout.Y_AXIS));

            ch21 = new JCheckBox("Poseo una licencia");
            ch21.addActionListener(this);
            ch21.setActionCommand("check");
            pane10.add(ch21);

            ch22 = new JCheckBox("Estoy en proceso de conseguir una");
            ch22.addActionListener(this);
            ch22.setActionCommand("check2");
            pane10.add(ch22);
            
            ch23 = new JCheckBox("No poseo, ni pienso sacar una");
            ch23.addActionListener(this);
            ch23.setActionCommand("check3");
            ch23.setSelected(true);
            pane10.add(ch23);
        
        g1.gridx = 0;
        g1.gridy = 21;
        cp.add(pane10, g1);
        
        q11 = new JLabel("11. Según su economía, ¿Dentro de que rango se encuentra?");
        g1.gridx = 0;
        g1.gridy = 22;
        cp.add(q11, g1);
        
        JPanel pane11 = new JPanel();
        pane11.setLayout(new BoxLayout(pane11, BoxLayout.Y_AXIS));

            ch24 = new JCheckBox("Rango A (- de 3.000)$");
            ch24.addActionListener(this);
            ch24.setActionCommand("check");
            ch24.setSelected(true);
            pane11.add(ch24);

            ch25 = new JCheckBox("Rango B (3.001 - 20.000)$");
            ch25.addActionListener(this);
            ch25.setActionCommand("check2");
            pane11.add(ch25);
            
            ch26 = new JCheckBox("Rango C (+ de 20.001)$");
            ch26.addActionListener(this);
            ch26.setActionCommand("check3");
            pane11.add(ch26);
        
        g1.gridx = 0;
        g1.gridy = 23;
        cp.add(pane11, g1);
        
        JPanel pane12 = new JPanel();
        pane12.setLayout(new FlowLayout());
            
            bt2 = new JButton("Regresar");
            bt2.addActionListener(this);
            bt2.setActionCommand("regresar");
            pane12.add(bt2);
        
            bt1 = new JButton("Enviar");
            bt1.addActionListener(this);
            bt1.setActionCommand("calcular");
            pane12.add(bt1);

        g1.gridx = 0;
        g1.gridy = 24;
        cp.add(pane12, g1);         
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
        
        if("calcular".equals(e.getActionCommand())){
            obtener_resultados();
        }  
        
        if("regresar".equals(e.getActionCommand())){
            volver_WindowUser();
        }
    }
    
    String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11;
    
    public void habilitar(){
        if(ch1.isSelected()){
            ch2.setSelected(false);
            ch3.setSelected(false);
        }
        
        if(ch4.isSelected()){
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
        }
        
        if(ch13.isSelected()){
            ch14.setSelected(false);
        }
        
        if(ch15.isSelected()){
            ch16.setSelected(false);
        }
        
        if(ch17.isSelected()){
            ch18.setSelected(false);
        }
        
        if(ch19.isSelected()){
            ch20.setSelected(false);
        }
        
        if(ch21.isSelected()){
            ch22.setSelected(false);
            ch23.setSelected(false);
        }
        
        if(ch24.isSelected()){
            ch25.setSelected(false);
            ch26.setSelected(false);
        }
    }
    
    public void habilitar2(){
        if(ch2.isSelected()){
            ch1.setSelected(false);
            ch3.setSelected(false);
        }
        
        if(ch5.isSelected()){
            ch4.setSelected(false);
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
        }
        
        if(ch14.isSelected()){
            ch13.setSelected(false);
        }
        
        if(ch16.isSelected()){
            ch15.setSelected(false);
        }
        
        if(ch18.isSelected()){
            ch17.setSelected(false);
        }
        
        if(ch20.isSelected()){
            ch19.setSelected(false);
        }
        
        if(ch22.isSelected()){
            ch21.setSelected(false);
            ch23.setSelected(false);
        }
        
        if(ch25.isSelected()){
            ch24.setSelected(false);
            ch26.setSelected(false);
        }
    }
    
    public void habilitar3(){
        if(ch3.isSelected()){
            ch1.setSelected(false);
            ch2.setSelected(false);
        }
        
        if(ch6.isSelected()){
            ch4.setSelected(false);
            ch5.setSelected(false);
        }
        
        if(ch23.isSelected()){
            ch21.setSelected(false);
            ch22.setSelected(false);
        }
        
        if(ch26.isSelected()){
            ch24.setSelected(false);
            ch25.setSelected(false);
        }
    }
    
    public void obtener_resultados(){
        //Primera Respuesta
        if(ch1.isSelected()){
            a1 = "priv";
        } 
        if(ch2.isSelected()){
            a1 = "publ";
        }
        if(ch3.isSelected()){
            a1 = "otro";
        } 
        
        //Segunda Respuesta
        if(ch4.isSelected()){
            a2 = "si";
        }
        if(ch5.isSelected()){
            a2 = "solo";
        }
        if(ch6.isSelected()){
            a2 = "no";
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
            a5 = "si";
        }
        if(ch12.isSelected()){
            a5 = "no";
        }
        
        //Sexta Respuesta
        if(ch13.isSelected()){
            a6 = "si";
        }
        if(ch14.isSelected()){
            a6 = "no";
        }
        
        //Septima Respuesta
        if(ch15.isSelected()){
            a7 = "rural";
        }
        if(ch16.isSelected()){
            a7 = "urbana";
        }
        
        //Octava Respuesta
        if(ch17.isSelected()){
            a8 = "cerca";
        }
        if(ch18.isSelected()){
            a8 = "lejos";
        }
        
        //Novena Respuesta
        if(ch19.isSelected()){
            a9 = "facil";
        }
        if(ch20.isSelected()){
            a9 = "dificil";
        }
        
        //Decima Respuesta
        if(ch21.isSelected()){
            a10 = "si";
        } 
        if(ch22.isSelected()){
            a10 = "proceso";
        }
        if(ch23.isSelected()){
            a10 = "no";
        } 
        
        //Decima Primera Respuesta
        if(ch24.isSelected()){
            a11 = "A";
        }
        if(ch25.isSelected()){
            a11 = "B";
        }
        if(ch26.isSelected()){
            a11 = "C";
        }
        
        con.mandarCuestionario(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,nombre, apellido, fondo);
        
        WindowResult wr = new WindowResult(con);
        wr.setVisible(true);
    }
    
    public void volver_WindowUser(){
        WindowUser wu = new WindowUser(con);
        
        this.setVisible(false);
        wu.setVisible(true);
    }
}
