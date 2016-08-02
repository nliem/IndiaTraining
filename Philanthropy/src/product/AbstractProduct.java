package product;

import java.text.DecimalFormat;

/**
 * Abstract class providing the template for products.
 * @author natalieliem
 *
 */
public abstract class AbstractProduct {
  
	/**
	 * Unique id of the product.
	 */
	protected int productId;
	
	/**
	 * Name of the product.
	 */
	protected String productName;
	
	/**
	 * Description of the product.
	 */
	protected String productDescription;
	
	/**
	 * String path of an associated image.
	 */
	protected String imagePath;
	
	/**
	 * Total cost of the product.
	 */
	protected double cost;
	
	/**
	 * Constructor for the product.
	 * @param productId Unique id of the product.
	 * @param productName Name of the product.
	 * @param productDescription Description of the product.
	 * @param imagePath Path to the associated image for this product.
	 * @param cost Cost of the product. 
	 */
	public AbstractProduct(int productId, String productName, String productDescription, String imagePath, double cost){
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.imagePath = imagePath;
		this.cost = cost;
	}
	
	/**
	 * Returns the product's unique id.
	 * @return Returns the product's unique id.
	 */
	public int getProductId(){
		return this.productId;
	}

	
	@Override
	public String toString(){
	  DecimalFormat df = new DecimalFormat("#.00");
	  String result = "";
	  result += this.productName + " (" + this.productId + ")\n" + this.productDescription + "\n";
	  result += "Product Cost: $" + df.format(this.cost) + "\n";
	  return result;
    }

}
