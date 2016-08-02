package project;

import java.text.DecimalFormat;
import java.util.HashMap;

import product.AbstractProduct;

/**
 * Abstract class provided template for concrete project classes.
 * 
 * @author natalieliem
 *
 */
public abstract class AbstractProject {

  /**
   * Unique identifier for projects.
   */
  protected int projectId;
  
  /**
   * Name/title of the project.
   */
  protected String name;
  
  /**
   * A short description elaborating on the purpose of the project.
   */
  protected String description;
  
  /**
   * Total cost of the project.
   */
  protected double projectCost;
  
  /**
   * A structure mapping product unique id's to AbstractProduct objects.
   */
  protected HashMap<Integer, AbstractProduct> products;

  /**
   * Basic constructor for the abstract project. Used by concrete classes extending AbstractProject to set protected variables.
   * 
   * @param projectId The unique identifier for the project.
   * @param name The name of the project.
   * @param description The project's description.
   * @param cost Total cost of the project.
   */
  public AbstractProject(int projectId, String name, String description, double cost) {
    this.projectId = projectId;
    this.name = name;
    this.description = description;
    this.projectCost = cost;
    this.products = new HashMap<>();
  }

  /**
   * Displays the information about this project using the project's toString method.
   */
  public void displayInformation() {
    System.out.println(this);

  }

  /**
   * Updates the project's description.
   * @param details Updated project description.
   */
  public void udateProjectDetails(String details) {
    this.description = details;
  }

  /**
   * Returns the project id.
   * @return Returns the unique project identifier. An int.
   */
  public int getProjectId() {
    return this.projectId;
  }

  /**
   * Adds an AbstractProduct to the project's map of products.
   * @param p AbstractProduct object to be added.
   */
  public void addProduct(AbstractProduct p) {
    if (!products.containsKey(p.getProductId())) {
      products.put(p.getProductId(), p);
    }
  }

  /**
   * Prints out all of the products associated with the project.
   */
  public void displayProducts() {
    if (this.products.isEmpty()) {
      System.out.println("This project contains no associated products.");
    } else {
      for (int key : this.products.keySet()) {
        System.out.println(products.get(key));
      }
    }
  }

  
  /**
   * Returns the number of products associated with this project.
   * @return int representing the number of products associated with this project.
   */
  public int getNumberProducts() {
    return this.products.size();
  }

  /**
   * Prints out only those products associated with this project that have outstanding costs.
   */
  public void displayOutstandingProducts() {
    if (this.products.isEmpty()) {
      System.out.println("This project contains no associated products.");
    } else {
      for (int key : this.products.keySet()) {
        AbstractProduct product = products.get(key);
        if (product instanceof Donatable) {
          Donatable donatableProduct = (Donatable) product;
          if (donatableProduct.getOutstandingCosts() != 0) {
            System.out.println(donatableProduct.toString());
          }
        }
      }
    }
  }

  /**
   * Custom toString method that displays the data encapsulated by this project.
   */
  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("#.00");
    String result = "";
    result += this.name + " (" + this.projectId + ")\n" + this.description + "\n";
    result += "Project Cost: $" + df.format(this.projectCost);
    return result;
  }
  
  public boolean hasOutstandingProducts(){
    for(int key : this.products.keySet()){
      AbstractProduct product = this.products.get(key);
      if(product instanceof Donatable){
        Donatable donatableProduct = (Donatable) product;
        if(donatableProduct.getOutstandingCosts() !=0) return true;
      }
    }
    return false;
  }

}
