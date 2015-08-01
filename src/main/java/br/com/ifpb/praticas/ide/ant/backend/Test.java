package br.com.ifpb.praticas.ide.ant.backend;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class Test {
    public static void main(String[] args) {
        ProjectManagerFacade pmf = new ProjectManagerFacade("/home/joaomarcos/NetBeansProjects/IDE-ant");
        System.out.println(pmf.gitCommit("\"Finalizando metodos git\""));
                
    }
}
