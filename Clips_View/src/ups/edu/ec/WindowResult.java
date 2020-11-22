
package ups.edu.ec;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Rakrad07
 */
public class WindowResult extends JFrame implements ActionListener{
    
    String imagen;
    String resultado;
    Controlador con;
    
    public WindowResult(Controlador control){
        this.con = control;
        resultado = con.obtenerResultado();
        imagen = con.obtenerDatoImagen();
        initComponents();
    }

    private void initComponents() {
        setSize(1000, 450);
        setTitle("Resultado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentsWindowResult();
    }
    
    JLabel l1,limg;
    JButton b1;
    
    public void componentsWindowResult(){
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        
            l1 = new JLabel(resultado, SwingConstants.CENTER);
            
            p1.add(l1);

        cp.add(p1, BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
            
            String path = "src/imagenes/"+imagen+".jpg";
            System.out.println(path);
            
            ImageIcon foto = new ImageIcon(path);

            limg = new JLabel(foto);
            
            p2.add(limg);

        cp.add(p2, BorderLayout.CENTER);        
        
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        
            b1 = new JButton("Aceptar");
            b1.addActionListener(this);
            b1.setActionCommand("aceptar");
            p3.add(b1);

        cp.add(p3, BorderLayout.SOUTH);
    }
    
            
    @Override
    public void actionPerformed(ActionEvent e) {
        if("aceptar".equals(e.getActionCommand())){
            this.setVisible(false);
        }
    }
    
}
