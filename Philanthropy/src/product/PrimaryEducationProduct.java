package product;

import java.text.DecimalFormat;
import java.util.ArrayList;

import donor.Donor;
import exceptions.InvalidDonationAmountException;
import project.Donatable;

/**
 * Extention of AbstractProduct and implementer of Donatable. Product related to
 * Primary Education projects.
 * 
 * @author natalieliem
 *
 */
public class PrimaryEducationProduct extends AbstractProduct implements Donatable {

  /**
   * Total donations collected.
   */
  private double donationsCollected;

  /**
   * Costs outstanding after donations.
   */
  private double outstandingCost;

  /**
   * List of donors for this product.
   */
  private ArrayList<Donor> donorList;

  /**
   * Constructor for this product.
   * @param productId Unique id of the product.
   * @param productName Name of the product.
   * @param productDescription Description of the product.
   * @param imagePath Path to the image associated with the product.
   * @param cost Cost of the product.
   */
  public PrimaryEducationProduct(int productId, String productName, String productDescription, String imagePath,
      double cost) {
    super(productId, productName, productDescription, imagePath, cost);
    this.donationsCollected = 0;
    this.outstandingCost = cost;
    this.donorList = new ArrayList<>();
  }

  @Override
  public void acceptDonation(int recipient, double donation, Donor donator) throws InvalidDonationAmountException {
    DecimalFormat df = new DecimalFormat("#.00");

    if (donation < 0) {
      throw new InvalidDonationAmountException("Invalid donation ammount. Negative donations are not accepted.");
    } else if (donation > this.outstandingCost) {
      throw new InvalidDonationAmountException("Invalid donation ammount. Donation ammount exceeds the outstanding "
          + "balance for this product. Outstanding balance is $" + df.format(this.outstandingCost));
    } else {
      this.donationsCollected += donation;
      this.outstandingCost -= donation;
      if (!this.donorList.contains(donator))
        donorList.add(donator);
      donator.noteDonation(donation);
      System.out.println("Donation of $" + df.format(donation) + "for product " + super.productId + " ("
          + super.productName + ") accepted.");
    }

  }

  @Override
  public void displayDonors() {
    System.out.println("Donor list for product " + this.productName + ":");
    for (Donor d : donorList) {
      System.out.println(d.getName());
    }

  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("#.00");
    String result = super.toString();
    result += "Donations collected: $" + df.format(this.donationsCollected) + "\n";
    result += "Outstanding costs: $" + df.format(this.outstandingCost) + "\n";
    return result;
  }

  @Override
  public double getOutstandingCosts() {
    return this.outstandingCost;
  }

}
