
package ups.edu.ec;

import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.trim;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.CLIPSLoadException;
import net.sf.clipsrules.jni.CaptureRouter;
import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.Router;

/**
 *
 * @author Rakrad07
 */
public class Controlador {
    
    private final Environment clips;
    
    public Controlador() throws CLIPSLoadException{
        clips = new Environment();
        clips.load("baseCompleta.clp");
    }
    
    String nombResul;
    String textResul;
    
    public void mandarCuestionario(String a1,String a2,String a3,String a4,String a5, 
            String a6,String a7,String a8,String a9,String a10,String a11,String nombre,
            String apellido, String fondo){  
        
        try {
            clips.reset();
            
            String nada_sinV = "(make-instance Nada of sinVehiculo (nombre \"Nada\")(tipo \"nada\")(precio 0)(tiempoAhorrado bajo)(ventaja \"gratis y una caminata no hace mal a nadie\")(desventaja \"lento\"))";
            String bicicleta_sinV = "(make-instance Bicicleta of sinVehiculo (nombre \"Bicicleta\")(tipo \"nada\")(precio 500)(tiempoAhorrado medio)(ventaja \"costo bajo y no contamina\")(desventaja \"es para una sola persona\"))";
            
            String xtz_V = "(make-instance XTZ-125 of vehiculo (nombre \"XTZ-125\")(tipo \"moto\")(precio 1790)(tiempoAhorrado alto)(cFuerza 10)(velocidadM 90)(capacidad 2))";
            String r3a_V = "(make-instance R3A of vehiculo (nombre \"R3A\")(tipo \"moto\")(precio 4790)(tiempoAhorrado alto)(cFuerza 42)(velocidadM 170)(capacidad 2))";
            String fz_V = "(make-instance FZ-25 of vehiculo (nombre \"FZ-25\")(tipo \"moto\")(precio 2490)(tiempoAhorrado alto)(cFuerza 25)(velocidadM 140)(capacidad 2))";
            String xa_V = "(make-instance XA-125 of vehiculo (nombre \"XA-125\")(tipo \"moto\")(precio 1490)(tiempoAhorrado alto)(cFuerza 8)(velocidadM 100)(capacidad 2))";
            
            String spark_V = "(make-instance SparkGT of vehiculo (nombre \"SparkGT\")(tipo \"carro\")(precio 13399)(tiempoAhorrado alto)(cFuerza 80)(velocidadM 156)(capacidad 5))";
            String tracker_V = "(make-instance Tracker of vehiculo (nombre \"Tracker\")(tipo \"carro\")(precio 25499)(tiempoAhorrado alto)(cFuerza 138)(velocidadM 180)(capacidad 5))";
            String dmax_V = "(make-instance D-Max-High-Power of vehiculo (nombre \"D-Max-High-Power\")(tipo \"carro\")(precio 27499)(tiempoAhorrado alto)(cFuerza 136)(velocidadM 170)(capacidad 5))";
            String sail_V = "(make-instance SailSedan of vehiculo (nombre \"SailSedan\")(tipo \"carro\")(precio 17499)(tiempoAhorrado alto)(cFuerza 109)(velocidadM 170)(capacidad 5))";
            
            clips.eval(nada_sinV);
            clips.eval(bicicleta_sinV);
            clips.eval(xtz_V);
            clips.eval(r3a_V);
            clips.eval(fz_V);
            clips.eval(xa_V);
            clips.eval(spark_V);
            clips.eval(tracker_V);
            clips.eval(dmax_V);
            clips.eval(sail_V);
            
            clips.eval("(make-instance " + nombre + " of persona "
                    + "(nombre \""+ nombre + "\")"
                    + "(apellido \""+ apellido + "\")"
                    + "(fondos "+ fondo + ")"  
                    + "(tipoR \" \")"
                    + "(vrecomendado \" \")"
                    + ")");
            
            clips.eval("(bind ?*usuario* "+nombre+")");
            clips.eval("(bind ?*nombreusu* \""+ nombre+"\")");
            
            clips.eval("(assert (cuestionario (transportepop \"" + a1 + "\") "
                    + "(viajes \"" + a2 + "\") "
                    + "(compras \"" + a3 + "\") "
                    + "(comprasacomp \"" + a4 + "\") "
                    + "(cargarcomp \"" + a5 + "\") "
                    + "(irtrabajo \"" + a6 + "\") "
                    + "(ruralurbano \"" + a7 + "\") "
                    + "(trabajocerca \"" + a8 + "\") "
                    + "(facilidadtranspub \"" + a9 + "\") "
                    + "(licencia \"" + a10 + "\") "
                    + "(rango \"" + a11 + "\") "
                    + "))");
            
            CaptureRouter mensaje = new CaptureRouter(clips, new String[] {Router.STDOUT});
            
            clips.run();
            
            //clips.eval("(send ["+nombre+"] resultado)");
            //JOptionPane.showMessageDialog(null, mensaje.getOutput());
            textResul = mensaje.getOutput();
            
        } catch (CLIPSException e) {
            e.printStackTrace();
        }   
    }
    
    public String obtenerDatoImagen(){
        String resul[] = textResul.split(":");
        
        String dec = "";
        
        if(trim(resul[1]).equals("caminar")){
            dec = trim(resul[1]);
            
            System.out.println("Entra al if");
        }else{
            String resul2[] = textResul.split(":");
            System.out.println("No debe entrar");
            dec = trim(resul2[2]);
        }
        
        return dec;
    }
    
    public String obtenerResultado(){
        return textResul;
    }
    
}
