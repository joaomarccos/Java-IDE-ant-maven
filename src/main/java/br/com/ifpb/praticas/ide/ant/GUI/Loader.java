package br.com.ifpb.praticas.ide.ant.GUI;

import br.com.ifpb.praticas.ide.ant.backend.ProjectBuilder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class Loader {
    public static void main(String[] args) {
        try {
//        Editor editor = new Editor();
//        editor.setVisible(true);
            ProjectBuilder p = new ProjectBuilder();
            System.out.println(p.compileSimpleProject("/home/joaomarcos/Desktop/Project"));
        } catch (IOException ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
