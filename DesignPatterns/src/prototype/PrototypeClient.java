package prototype;

public class PrototypeClient {
	
	public static void main(String[] args){
		
		CreditCard card = new CreditCard();
		
		CardCache cache = new CardCache();
		
		System.out.println("Original Card Hash Code := " + card.hashCode());
		cache.loadProduct(card);
		
		try {
			CreditCard cachedCard = cache.getCachedCard();
			System.out.println("Cached Card Hash Code := " + cachedCard.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
