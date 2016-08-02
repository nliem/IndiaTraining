package application;

import java.util.Scanner;

import donor.DonorManager;
import project.ProjectManager;

/**
 * Class which connects user input to donor and project information/functionality.
 * @author natalieliem
 *
 */
public class Portal {

  /**
   * Session relating to this user interaction.
   */
  private static Session session;

  /**
   * Displays the menu options and processes the user input.
   */
  public static void displayMenuOptions() {
    String menu = "Please enter one of the following commands:\n";
    menu += "1 - To view a complete list of projects.\n";
    menu += "2 - To view a complete list of donors.\n";
    menu += "3 - To make a donation.\n";
    menu += "4 - To view a project's donor list.\n";
    menu += "5 - To view a project's list of associated products.\n";
    menu += "6 - To exit.\n";
    System.out.println(menu);

    Scanner in = new Scanner(System.in);

    System.out.println("Please input your choice.");

    int choice = in.nextInt();

    switch (choice) {
    case 1:
      ProjectManager.getInstance().displayAllProjects();
      displayMenuOptions();
      break;
    case 2:
      DonorManager.getInstance().displayAllDonors();
      displayMenuOptions();
      break;
    case 3:
      Portal.executeDonation();
      displayMenuOptions();
      break;
    case 4:
      displayProjectDonors();
      displayMenuOptions();
      break;
    case 5:
      displayProjectProducts();
      displayMenuOptions();
      break;
    case 6:
      System.out.println("Thank you for using Philanthropy Portal. Bye bye.");
      in.close();
      return;
    default:
      System.out.println("Invalid choice. Please enter a value 1-6.");
      displayMenuOptions();
      break;
    }

    in.close();

  }

  /**
   * Finds which project the user wants to view and displays that project's donors.
   */
  public static void displayProjectDonors() {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the id of the project whose donors you wish to view.");

    try {
      int projectId = in.nextInt();
      ProjectManager.getInstance().displayProjectDonors(projectId);
    } catch (Exception e) {
      System.out.println("Something went wrong..." + e.getMessage());
    } finally {
      // in.close();
    }
  }

  /**
   * Finds which project the user wants to view and displays that project's products.
   */
  public static void displayProjectProducts() {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter the id of the project whose products you wish to view.");

    try {
      int projectId = in.nextInt();
      ProjectManager.getInstance().displayProjectProducts(projectId);
    } catch (Exception e) {
      System.out.println("Something went wrong... " + e.getMessage());
    } finally {
      // in.close();
    }
  }

  /**
   * Executes the donation process. 
   */
  public static void executeDonation() {
    session = new Session();

    System.out.println("Please enter the id of the donor who wishes to make a donation.");

    Scanner in = new Scanner(System.in);

    int donorId = in.nextInt();
    session.setDonorId(donorId);

    if (DonorManager.getInstance().getDonor(donorId) == null) {
      System.out.println("Something went wrong... No donor found with id " + donorId);
      return;
    }

    System.out.println("Please enter the id of the project receiving the donation.");

    int projectId = in.nextInt();
    session.setReceivingProjectId(projectId);

    boolean hasProducts = false;
    try {
      hasProducts = ProjectManager.getInstance().projectHasAssociatedProducts(projectId);
    } catch (Exception e) {
      System.out.println("Something went wrong..." + e.getMessage());
      return;
    }

    if (hasProducts) {
      System.out.println(
          "This project has associated products shown below. Please enter the product id of the product you wish to donate to, or 0 to donate to the project in general.");
      try {
        ProjectManager.getInstance().displayOutstandingProducts(projectId);
      } catch (Exception e) {
        System.out.println("Something went wrong..." + e.getMessage());
        in.close();
        return;
      }

      int productId = in.nextInt();
      session.setReceivingProductId(productId);

      System.out.println("Enter the ammount to donate. (ex: 3400 or 4500.50)");
      double amount = in.nextDouble();
      session.setAmmount(amount);

    } else {
      session.setReceivingProductId(0);
      System.out.println("Enter the ammount to donate. (ex: 3400 or 4500.50)");
      double amount = in.nextDouble();
      session.setAmmount(amount);
    }

    try {
      ProjectManager.getInstance().applyDonationToProject(projectId, session.getReceivingProductId(),
          session.getDonorId(), session.getAmmount());
    } catch (Exception e) {
      // e.printStackTrace(System.out);
      System.out.println("Something went wrong..." + e.getMessage());
      return;
    } finally {
      // in.close();
    }
  }

}
