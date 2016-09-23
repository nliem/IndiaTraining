package noDuplicateCode;

public class Information {
	
	private long contactPhone;
	private String contactEmail;
	private Address contact;
	private Address delivery;
	private Address invoice;
	
	public Information(){
		super();
	}
	
	public Information(long contactPhone, String contactEmail, Address contact, Address delivery,
			Address invoice) {
		super();
		this.contactPhone = contactPhone;
		this.contactEmail = contactEmail;
		this.contact = contact;
		this.delivery = delivery;
		this.invoice = invoice;
	}

	public long getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(long contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Address getContact() {
		return contact;
	}

	public void setContact(Address contact) {
		this.contact = contact;
	}

	public Address getDelivery() {
		return delivery;
	}

	public void setDelivery(Address delivery) {
		this.delivery = delivery;
	}

	public Address getInvoice() {
		return invoice;
	}

	public void setInvoice(Address invoice) {
		this.invoice = invoice;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Contact Address\n");
		sb.append(contact.toString() + "\n");
		sb.append("Deliver Address\n");
		sb.append(delivery.toString()+"\n");
		sb.append("Invoice Address\n");
		sb.append(invoice.toString());
		sb.append("Contact phone: " + contactPhone);
		sb.append("/tContact Email: " + contactEmail + "\n");
		return sb.toString();
	}

}
