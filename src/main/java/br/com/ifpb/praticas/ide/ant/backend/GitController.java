package br.com.ifpb.praticas.ide.ant.backend;

import java.io.IOException;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class GitController {

    public String push(String path){
        return execute(GitCommands.PUSH.setPath(path));
    }
    
    public String pull(String path){
        return execute(GitCommands.PULL.setPath(path));
    }
    
    public String init(String path){
        return execute(GitCommands.INIT.setPath(path));
    }
    
    public String add(String path){
        return execute(GitCommands.ADD.setPath(path));
    }
    
    public String commit(String path, String message){
        return execute(GitCommands.COMMIT.setPath(path).setMessage(message));
    }
    
    private String execute(GitCommands command){
        try {
            return command.execute();
        } catch (IOException ex) {
            return ex.getMessage();
        }       
    }
}
