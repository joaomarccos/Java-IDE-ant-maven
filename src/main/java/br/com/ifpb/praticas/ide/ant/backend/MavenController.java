package br.com.ifpb.praticas.ide.ant.backend;

import java.io.IOException;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class MavenController {
    
    public String compile(String path){
        return execute(MvnCommands.COMPILE.setPath(path));
    }
    
    public String clean(String path){
        return execute(MvnCommands.CLEAN.setPath(path));
    }
    
    public String pacKage(String path){
        return execute(MvnCommands.PACKAGE.setPath(path));
    }
    
    public String install(String path){
        return execute(MvnCommands.INSTALL.setPath(path));
    }
    
    private String execute(MvnCommands command){
        try {
            return command.execute();
        } catch (IOException ex) {
            return ex.getMessage();
        }       
    }
    
}
