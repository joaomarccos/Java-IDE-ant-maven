package br.com.ifpb.praticas.ide.ant.backend;

import java.io.IOException;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class GitController {

    public String push(String path, String password){
        return execute(GitCommands.PUSH.setPath(path).setDataIn(password));
    }
    
    public String pull(String path, String password){
        return execute(GitCommands.PULL.setPath(path).setDataIn(password));
    }
    
    public String init(String path){
        return execute(GitCommands.INIT.setPath(path));
    }
    
    public String add(String path){
        return execute(GitCommands.ADD.setPath(path));
    }
    
    public String commit(String path, String message){
        return execute(GitCommands.COMMIT.setPath(path).setDataIn(message));
    }
    
    private String execute(GitCommands command){
        try {
            return command.execute();
        } catch (IOException ex) {
            return ex.getMessage();
        }       
    }
}
