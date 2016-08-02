package project;

import java.text.DecimalFormat;
import java.util.ArrayList;

import donor.Donor;
import exceptions.InvalidDonationAmountException;
import exceptions.UnknownProductException;
import product.AbstractProduct;

/**
 * A type of project focused on Cancer related issues.
 * 
 * @author natalieliem
 *
 */
public class PrimaryEducationProject extends AbstractProject implements Donatable {

  /**
   * Total amount of donations collected.
   */
  private double collectedDonations;

  /**
   * The costs still outstanding after donations.
   */
  private double oustandingCosts = super.projectCost - this.collectedDonations;

  /**
   * List of Donors who have donated to this project.
   */
  private ArrayList<Donor> donorList;

  /**
   * Constructor for this class.
   * 
   * @param projectId
   *          Unique id for this project.
   * @param name
   *          Name of this project.
   * @param description
   *          Brief description of the project.
   * @param cost
   *          Total cost of the project.
   */
  public PrimaryEducationProject(int projectId, String name, String description, double cost) {
    super(projectId, name, description, cost);
    this.collectedDonations = 0;
    this.oustandingCosts = cost;
    this.donorList = new ArrayList<Donor>();
  }

  /**
   * Accepts donation and applies it the the total collected. Adds the donor to
   * the donor list if necessary.
   */
  @Override
  public void acceptDonation(int recipient, double donation, Donor donator)
      throws InvalidDonationAmountException, UnknownProductException {
    DecimalFormat df = new DecimalFormat("#.00");

    if (donation < 0) {
      throw new InvalidDonationAmountException("Invalid donation ammount. Negative donations are not accepted.");
    } else if (donation > this.oustandingCosts) {
      throw new InvalidDonationAmountException("Invalid donation ammount. Donation ammount exceeds the outstanding "
          + "balance for this project. Outstanding balance is $" + df.format(this.oustandingCosts));
    } else {
      if (recipient == 0) {
        this.collectedDonations += donation;
        this.oustandingCosts -= donation;
        donator.noteDonation(donation);
        System.out.println("Donation of $" + df.format(donation) + " for project " + super.name + " (" + super.projectId
            + ") accepted.");
      } else {
        AbstractProduct p = this.products.get(recipient);
        if (p == null)
          throw new UnknownProductException("Product with id " + recipient + " does not exist.");
        Donatable donateableProduct = (Donatable) p;
        donateableProduct.acceptDonation(recipient, donation, donator);
      }
      if (!this.donorList.contains(donator)) {
        this.donorList.add(donator);
      }
    }

  }

  /**
   * Displays information about this project.
   */
  @Override
  public void displayInformation() {
    System.out.println(this);
  }

  /**
   * Displays all the donors to this project.
   */
  @Override
  public void displayDonors() {
    System.out.println(this.name + " Donor List");
    for (Donor donator : donorList) {
      System.out.println(donator);
    }

  }

  /**
   * To string method displaying info encapsulated by this class.
   */
  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("#.00");
    String result = super.toString();
    result += "\tTotal Donations: $" + df.format(this.collectedDonations) + "\tOutstanding Cost: $"
        + df.format(this.oustandingCosts) + "\n";
    return result;
  }

  /**
   * Returns the costs still outstanding for this project.
   */
  @Override
  public double getOutstandingCosts() {
    return this.oustandingCosts;
  }

}
