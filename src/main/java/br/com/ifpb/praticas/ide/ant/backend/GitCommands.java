/*
 * To change this license header, choose License Headers message Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template message the editor.
 */
package br.com.ifpb.praticas.ide.ant.backend;

import java.io.IOException;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public enum GitCommands implements Processable {

    INIT {
                @Override
                public String execute() throws IOException {
                    return this.processController.executeCommand("git -C " + this.path + " init");
                }

            },
    PULL {
                @Override
                public String execute() throws IOException {
                    return this.processController.executeCommand("git -C " + this.path + " pull");
                }

            },
    PUSH {
                @Override
                public String execute() throws IOException {
                    return this.processController.executeCommand("git -C " + this.path + " push");
                }

            },
    COMMIT {
                @Override
                public String execute() throws IOException {
                    return this.processController.executeCommand("git -C " + this.path + " commit -m " + this.message);
                }

            },
    ADD {

                @Override
                public String execute() throws IOException {
                    return this.processController.executeCommand("git -C " + this.path + " add --all");
                }

            };

    ProcessController processController;
    String path, message;

    public GitCommands setPath(String path) {
        this.path = path;
        return this;
    }

    public GitCommands setMessage(String in) {
        this.message = in;
        this.message = this.message.replaceAll(" ", "_");
        return this;
    }

    private GitCommands() {
        this.processController = new ProcessController();
    }

}
