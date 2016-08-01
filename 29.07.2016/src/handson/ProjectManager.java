package handson;

import java.util.ArrayList;

//singleton ;) 
public class ProjectManager {
  
  private ArrayList<AbstractProject> projectList;
  private ProjectManager instance;
  
  public ProjectManager getInstance(){
    if(this.instance == null){
      this.instance = new ProjectManager();
    }
    return this.instance;
  }
  
  public void displayProjects(){
    
  }

}
