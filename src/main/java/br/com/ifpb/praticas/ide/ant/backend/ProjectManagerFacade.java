package br.com.ifpb.praticas.ide.ant.backend;

/**
 *
 * @author João Marcos F <joaomarccos.ads@gmail.com>
 */
public class ProjectManagerFacade {
    private MavenController mvnController;
    private GitController gitController;
    private String projectPath;

    /**   
     * @param path represents the directory path from project
     */
    public ProjectManagerFacade(String path) {
        this.mvnController = new MavenController();
        this.gitController = new GitController();
        this.projectPath = path;
    }
    
    public String compileProject(){
        return mvnController.compile(projectPath);
    }
    
    public String packageProject(){
        return mvnController.pacKage(projectPath);
    }
    
    public String cleanProject(){
        return mvnController.clean(projectPath);
    }
    
    public String installProject(){
        return mvnController.install(projectPath);
    }
    
    public String gitPush(){
        return gitController.push(projectPath);
    }
    
    public String gitPull(){
        return gitController.pull(projectPath);
    }
    
    public String gitAdd(){
        return gitController.add(projectPath);
    }
    
    public String gitCommit(String message){
        return gitController.commit(projectPath, message);
    }
    
    public String gitInit(){
        return gitController.init(projectPath);
    }
    
}
    
