/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.praticas.ide.ant.backend;

import java.io.IOException;

/**
 * for add others commands is very simple with this strategy, so, the
 * developers should to know well each commmand to be able to use.
 * 
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public enum MvnCommands implements Processable {        
    
    INSTALL{
        @Override
        public String execute() throws IOException {
            return processController.executeCommand("mvn install");
        }
    },
    
    CLEAN{

        @Override
        public String execute() throws IOException {
            return processController.executeCommand("mvn clean");
        }
        
    },
    
    COMPILE{

        @Override
        public String execute() throws IOException {
            return processController.executeCommand("mvn compile");
        }
        
    },
    
    PACKAGE{

        @Override
        public String execute() throws IOException {
            return processController.executeCommand("mvn clean package");
        }
        
    };

    ProcessController processController;    

    MvnCommands() {
        this.processController = new ProcessController();
    }
    
}
