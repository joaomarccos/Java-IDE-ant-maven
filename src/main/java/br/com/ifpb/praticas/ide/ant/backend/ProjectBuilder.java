package br.com.ifpb.praticas.ide.ant.backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class ProjectBuilder{
    
    private static final String BUILDXMLNAME = "ourBuilder.xml";
    private static final String BUILDXML_PROPERTIE = "ourBuilder.properties";
    private static final Path PATHBUILDXML = Paths.get("./src/main/resources/"+BUILDXMLNAME);    
    private static final Path PATHBUILDPROP = Paths.get("./src/main/resources/"+BUILDXML_PROPERTIE);    
    private String ourBuildPath;
    private ProcessController processController;

    public ProjectBuilder() {
        this.processController = new ProcessController();
    }
    
    /**
     * Compile a simple project opened on editor
     *    
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String compileSimpleProject() throws IOException {                
        String command = "ant -buildfile \""+ourBuildPath+"\" build";
        return processController.executeCommand(command);                
    }

    /**
     * Compile a web project opened on editor
     *     
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String compileWebProject() throws IOException {
        String command = "ant -buildfile \""+ourBuildPath+"\" buildWeb";
        return processController.executeCommand(command);                
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
        return processController.executeCommand(command);                
    }
    
    /**
     * Execute a jar file
     * @param path
     * @return
     * @throws IOException 
     */
    public String executeJar(String path) throws IOException {
        String command = "ant -buildfile \""+ourBuildPath+"\" -Dproject.name=\""+path+"/"+getProjectName(path)+"\" executeJar";
        return processController.executeCommand(command);                
    }

    /**
     * Generate a war package from the opened project on editor
     * @param path - path of the project
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String buildWebProject(String path) throws IOException {
        String command = "ant -buildfile \""+ourBuildPath+"\" -Dproject.name="+getProjectName(path)+" packageWar";
        return processController.executeCommand(command);                
    }
    
    /**
     * Generate a war and deploy on web container (tomcat)
     * @param path - path of the project
     * @return - String containing a sucess or error message related-project
     * @throws java.io.IOException
     */
    public String deployWebProject(String path) throws IOException {
        String command = "ant -buildfile \""+ourBuildPath+"\" -Dproject.name="+getProjectName(path)+" implantar";
        return processController.executeCommand(command);                
    }
    
    /**
     * Start tomcat container
     * @param path
     * @return
     * @throws IOException 
     */
    public String startTomCat() throws IOException {
        String command = "ant -buildfile \""+ourBuildPath+"\" tomcat-start";
        return processController.executeCommand(command);                
    }
    
    /**
     * Stop tomcat container
     * @param path
     * @return
     * @throws IOException 
     */
    public String stopTomCat() throws IOException {
        String command = "ant -buildfile \""+ourBuildPath+"\" tomcat-stop";
        return processController.executeCommand(command);                
    }
    
    /**
     * Configure path from tomcat
     * @param path
     * @throws IOException 
     */
    public void configureTomcatHome(String path) throws IOException{
        Properties prop = new Properties();
        Path p = Paths.get("./src/main/resources/ourBuilder.properties");        
        prop.setProperty("tomcat.home", path);                
        prop.store(Files.newOutputStream(p), "Configuração tomcat.home");                        
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
        projectDirectory = Paths.get(path+"/"+BUILDXML_PROPERTIE);
        Files.copy(PATHBUILDPROP, projectDirectory, StandardCopyOption.REPLACE_EXISTING);        
    }
    
    private String getProjectName(String path){
        Path name = Paths.get(path);
        return name.getFileName().toString();
    }

}
