package br.com.ifpb.praticas.ide.ant.backend;

import java.io.IOException;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class MavenController {
    public String execute(MvnCommands command){
        try {
            return command.execute();
        } catch (IOException ex) {
            return "Fail :("; //configuration of error message. 
        }       
    }
}
