package br.com.ifpb.praticas.ide.ant.backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class ProjectBuilder {
    
    private static final String BUILDXMLNAME = "ourBuilder.xml";
    private static final Path PATHBUILDXML = Paths.get("./src/main/resources/"+BUILDXMLNAME);    

    /**
     * Compile a simple project opened on editor
     *
     * @param path - path of the project
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String compileSimpleProject(String path) throws IOException {                
        String command = "ant -buildfile \""+copyBuildXmlToProjectPath(path).toString()+"\" build";        
        return runAntCommand(command);                
    }

    /**
     * Compile a web project opened on editor
     *
     * @param path - path of the project
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String compileWebProject(String path) throws IOException {
        String command = "ant -buildfile \""+copyBuildXmlToProjectPath(path).toString()+"\" buildWeb";
        return runAntCommand(command);                
    }

    /**
     * Generate a jar package from the opened project on editor
     * @param path - path of the project
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String buildSimpleProject(String path) throws IOException {
        String command = "ant -buildfile \""+copyBuildXmlToProjectPath(path).toString()+"\" packageJar";
        return runAntCommand(command);                
    }

    /**
     * Generate a war package from the opened project on editor
     * @param path - path of the project
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String executeWebProject(String path) throws IOException {
        String command = "ant -buildfile \""+copyBuildXmlToProjectPath(path).toString()+"\" packageWar";
        return runAntCommand(command);                
    }
    
    /**
     * Run a command. In other words creates a process and takes care of manage it.
     * @param command
     * @return - Out of the command
     * @throws IOException 
     */
    private static String runAntCommand(String command) throws IOException{
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
     * Copy the xml file used for this application to the project directory
     * opened on editor
     * @param path
     * @return - Path of the xml file copied
     * @throws IOException 
     */
    private static Path copyBuildXmlToProjectPath(String path) throws IOException{
        Path projectDirectory = Paths.get(path+"/"+BUILDXMLNAME);                        
        return Files.copy(PATHBUILDXML, projectDirectory, StandardCopyOption.REPLACE_EXISTING);
    }

}
