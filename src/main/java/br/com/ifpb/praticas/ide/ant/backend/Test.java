package br.com.ifpb.praticas.ide.ant.backend;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class Test {
    public static void main(String[] args) {
        try {
            ProjectBuilder p = new ProjectBuilder();
            String path = "/home/joaomarcos/Desktop/Project";
            System.out.println(p.compileSimpleProject(path));
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
