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
    private String ourBuildPath;

    /**
     * Compile a simple project opened on editor
     *
     * @param path - path of the project
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String compileSimpleProject(String path) throws IOException {                
        String command = "ant -buildfile \""+ourBuildPath+"\" build";
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
        String command = "ant -buildfile \""+ourBuildPath+"\" buildWeb";
        return runAntCommand(command);                
    }

    /**
     * Generate a jar package from the opened project on editor
     * @param path - path of the project
     * @param mainClass - Main class that will be used on Manifest.xml
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String buildSimpleProject(String path, String mainClass) throws IOException {
        String command = "ant -buildfile \""+ourBuildPath+"\" -DMain="+mainClass+" -Dproject.name="+getProjectName(path)+" packageJar";
        return runAntCommand(command);                
    }
    
    /**
     * Execute a jar file
     * @param path
     * @return
     * @throws IOException 
     */
    public String executeJar(String path) throws IOException {
        String command = "ant -buildfile \""+ourBuildPath+"\" -Dproject.name=\""+path+"/"+getProjectName(path)+"\" executeJar";
        return runAntCommand(command);                
    }

    /**
     * Generate a war package from the opened project on editor
     * @param path - path of the project
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String buildWebProject(String path) throws IOException {
        String command = "ant -buildfile \""+ourBuildPath+"\" -Dproject.name="+getProjectName(path)+" packageWar";
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
     * @throws IOException 
     */
    public void copyBuildXmlToProjectPath(String path) throws IOException{
        Path projectDirectory = Paths.get(path+"/"+BUILDXMLNAME);                        
        this.ourBuildPath = Files.copy(PATHBUILDXML, projectDirectory, StandardCopyOption.REPLACE_EXISTING).toString();
    }
    
    private String getProjectName(String path){
        Path name = Paths.get(path);
        return name.getFileName().toString();
    }

}
