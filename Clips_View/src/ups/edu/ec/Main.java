
package ups.edu.ec;

import net.sf.clipsrules.jni.CLIPSLoadException;

/**
 *
 * @author Rakrad07
 */
public class Main {
    
    public static void main(String [] args) throws CLIPSLoadException{
        
        Controlador con = new Controlador();
        
        WindowUser wu = new WindowUser(con);
        wu.setVisible(true);
    } 
}
