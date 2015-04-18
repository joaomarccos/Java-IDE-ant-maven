package br.com.ifpb.praticas.ide.ant.GUI;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class Loader {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }
}
