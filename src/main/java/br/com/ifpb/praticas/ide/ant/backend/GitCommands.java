/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
                    return this.processController.executeCommand("git -C \"" + this.path + "\" init");
                }

            },
    PULL {
                @Override
                public String execute() throws IOException {
                    return this.processController.executeRestrictedCommand("git -C " + this.path + " pull", this.in);
                }

            },
    PUSH {
                @Override
                public String execute() throws IOException {
                    return this.processController.executeRestrictedCommand("git -C \"" + this.path + "\" push", this.in);
                }

            },
    COMMIT {
                @Override
                public String execute() throws IOException {
                    return this.processController.executeCommand("git -C \"" + this.path + "\" commit -m \"" + this.in + "\"");
                }

            },
    ADD {

                @Override
                public String execute() throws IOException {
                    return this.processController.executeCommand("git -C \"" + this.path + "\" add --all");
                }

            };

    ProcessController processController;
    String path, in;

    public GitCommands setPath(String path) {
        this.path = path;
        return this;
    }

    public GitCommands setDataIn(String in) {
        this.in = in;
        return this;
    }

    private GitCommands() {
        this.processController = new ProcessController();
    }

}
