package project;

import donor.Donor;
import exceptions.InvalidDonationAmountException;
import exceptions.UnknownProductException;

/**
 * Interface defining the ability for something to accept donations.
 * @author natalieliem
 *
 */
public interface Donatable {
	
  /**
   * Method for accepting a donation from a donor.
   * @param recipient Id indicating which product or project is the recipient of the donation.
   * @param donation The amount being donated.
   * @param donator Donor making the donation.
   * @throws InvalidDonationAmountException Thrown if the donation amount is negative or exceeds the outstanding costs.
   * @throws UnknownProductException Thrown if the recipient id is unknown.
   */
	public void acceptDonation(int recipient, double donation, Donor donator) throws InvalidDonationAmountException, UnknownProductException;
	
	/**
	 * Displays all donors. 
	 */
	public void displayDonors();
	
	/**
	 * Returs the amount still outstanding.
	 * @return double - the amount still outstanding.
	 */
	public double getOutstandingCosts();

}
