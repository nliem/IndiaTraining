package project;

import java.util.HashMap;

import donor.DonorManager;
import exceptions.InvalidDonationAmountException;
import exceptions.UnknownProductException;
import exceptions.UnknownProjectException;
import product.AbstractProduct;

/**
 * Singleton manager of all Projects. Handles all interactions with projects. 
 * @author natalieliem
 *
 */
public class ProjectManager {
  
  /**
   * Structure mapping project unique id's to AbstractProject objects.
   */
  private HashMap<Integer, AbstractProject> projectList;
  
  /**
   * Private instance of the ProjectManager used to implement singleton design.
   */
  private static ProjectManager instance;
  
  /**
   * Public static method that returns ProjectManager instance. Used to implement singleton design.
   * @return Returns instance of ProjectManager which can be used to call non-static methods.
   */
  public static ProjectManager getInstance(){
    if(instance == null){
      instance = new ProjectManager();
    }
    return instance;
  }
  
  /**
   * Private constructor. Only accessible in the class and only called in the getInstance method.
   */
  private ProjectManager(){
	  projectList = new HashMap<>();
  }
  
  /**
   * Displays all projects stored by the manager.
   */
  public void displayAllProjects(){
    for(int key : projectList.keySet()){
    	projectList.get(key).displayInformation();
    }
  }
  
  /**
   * Adds a new project to the structure of stored projects.
   * @param proj AbstractProject object to be added.
   */
  public void addProject(AbstractProject proj){
	  if(!projectList.containsKey(proj.getProjectId())){
		  projectList.put(proj.getProjectId(), proj);
	  }
  }
  
  /**
   * Adds a product to a project contained in the manager.
   * @param projectId The id of the project the product belongs to.
   * @param product The AbstractProduct to be added.
   * @throws UnknownProjectException Thrown if no project is found with the project id specified.
   */
  public void addProductToProject(int projectId, AbstractProduct product) throws UnknownProjectException{
	  AbstractProject project = this.projectList.get(projectId);
	  if(project == null){
		  throw new UnknownProjectException("No project found with id " + projectId);
	  }
	  else{
		  project.addProduct(product);
	  }
  }
  
  /**
   * Displays all the fully funded projects held by the manager.
   */
  public void displayFundedProjects(){
	  for(int key : projectList.keySet()){
		  AbstractProject p = projectList.get(key);
		  if(p instanceof Donatable){
			  Donatable donatableProject = (Donatable) p;
			  if(donatableProject.getOutstandingCosts() == 0){
				  System.out.println(donatableProject);
			  }
		  }
	  }
  }
  
  /**
   * Displays all the projects with outstanding costs held by the manager.
   */
  public void displayOutstandingProjects(){
	  for(int key : projectList.keySet()){
		  AbstractProject p = projectList.get(key);
		  if(p instanceof Donatable){
			  Donatable donatableProject = (Donatable) p;
			  if(donatableProject.getOutstandingCosts() != 0 && !p.hasOutstandingProducts()){
				  System.out.println(donatableProject);
			  }
		  }
	  }
  }
  
  /**
   * Applies a donation to a specific project held by the manager.
   * @param projectId The id of the project being donated to.
   * @param recipient The id of the product being donated to.
   * @param donorId The id of the donor.
   * @param ammount The amount of money being donated.
   * @throws UnknownProjectException Thrown if the project id is not recognized by the manager.
   * @throws UnknownProductException Thrown if the product id is not recognized by the project.
   * @throws InvalidDonationAmountException Thrown if the donation amount is negative or greater than the outstanding cost.
   */
  public void applyDonationToProject(int projectId, int recipient, int donorId, double ammount) 
		  throws UnknownProjectException, UnknownProductException, InvalidDonationAmountException{
	  AbstractProject project = this.projectList.get(projectId);
	  if(project == null) throw new UnknownProjectException("No project found with id " + projectId);
	  if(project instanceof Donatable){
		  Donatable donatableProject = (Donatable) project;
		  donatableProject.acceptDonation(recipient, ammount, DonorManager.getInstance().getDonor(donorId));
	  }
  }
  
  public boolean projectHasAssociatedProducts(int projectId) throws UnknownProjectException{
	  AbstractProject project = this.projectList.get(projectId);
	  if(project == null) throw new UnknownProjectException("No project found with id " + projectId);
	  return project.getNumberProducts() != 0;
  }
  
  public void displayOutstandingProducts(int projectId) throws UnknownProjectException{
	  AbstractProject project = projectList.get(projectId);
	  if(project == null) throw new UnknownProjectException("No project found with id " + projectId);
	  project.displayOutstandingProducts();
  }
  
  public void displayProjectDonors(int projectId) throws UnknownProjectException{
	  AbstractProject project = projectList.get(projectId);
	  if(project == null) throw new UnknownProjectException("No project found with id " + projectId);
	  if(project instanceof Donatable){
		  Donatable donatableProject = (Donatable) project;
		  donatableProject.displayDonors();
	  }
  }
  
  public void displayProjectProducts(int projectId) throws UnknownProjectException{
	  AbstractProject project = projectList.get(projectId);
	  if(project == null) throw new UnknownProjectException("No project found with id " + projectId);
	  project.displayProducts();
  }

}
