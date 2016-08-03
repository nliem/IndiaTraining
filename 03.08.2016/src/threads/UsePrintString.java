package threads;

public class UsePrintString implements Runnable{
	
	private String string1;
	private String string2;

	@Override
	public void run() {
		PrintStrings.print(this.string1, this.string2);
		
	}
	
	public UsePrintString(String s1, String s2){
		this.string1 = s1;
		this.string2 = s2;
		Thread t = new Thread(this);
		t.start();
	}

}
