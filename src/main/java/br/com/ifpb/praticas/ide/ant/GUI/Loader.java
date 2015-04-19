package br.com.ifpb.praticas.ide.ant.GUI;

import br.com.ifpb.praticas.ide.ant.backend.ProjectBuilder;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class Loader {
    public static void main(String[] args) {
        Editor editor = new Editor();
        ProjectBuilder pb = new ProjectBuilder();
        editor.setProjectBuilder(pb);
        editor.setVisible(true);     
        
    }
}
