package br.com.ifpb.praticas.ide.ant.backend;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class ProcessController {

    /**
     * Run a command. In other words creates a process and takes care of manage
     * it.
     *
     * @param command
     * @return - Out of the command
     * @throws IOException
     */
    public String executeCommand(String command) throws IOException {

        Runtime r = Runtime.getRuntime();
        Process p = r.exec(command);
        Scanner out = new Scanner(p.getInputStream());
        StringBuilder result = new StringBuilder();
        while (out.hasNext()) {
            result.append(out.nextLine()).append("\n");
        }

        out = new Scanner(p.getErrorStream());
        while (out.hasNext()) {
            result.append(out.nextLine()).append("\n");
        }

        p.destroy();
        return result.toString();
    }

    /**
     * Run a command that require a password. In other words creates a process
     * and takes care of manage it.
     *
     * @param command
     * @return - Out of the command
     * @throws IOException
     */
    public String executeRestrictedCommand(String command, String password) throws IOException {

        Runtime r = Runtime.getRuntime();
        Process p = r.exec(command);
        Scanner out = new Scanner(p.getInputStream());
        StringBuilder result = new StringBuilder();
        
        /**
         * Sa'porra nun funfa
         */
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(p.getOutputStream()));
        writer.println(password);
        writer.close();
        
        while (out.hasNext()) {
            result.append(out.nextLine()).append("\n");
        }

        out = new Scanner(p.getErrorStream());
        while (out.hasNext()) {
            result.append(out.nextLine()).append("\n");
        }

        p.destroy();
        return result.toString();
    }

}
