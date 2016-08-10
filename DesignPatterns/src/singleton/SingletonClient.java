package singleton;

public class SingletonClient {
	
	public static void main(String[] args){
	
		RequestHandler rh1 = RequestHandler.getInstance();
		RequestHandler rh2 = RequestHandler.getInstance();
		
		
		System.out.println(rh1.hashCode());
		System.out.println(rh2.hashCode());
		
		Runnable runnable = new Runnable(){
			@Override
			public void run(){
				RequestHandler handler = RequestHandler.getInstance();
				System.out.println(Thread.currentThread().getName() + " " + handler.hashCode());
			}
		};
		
		Thread th1 = new Thread(runnable, "a");
		Thread th2 = new Thread(runnable, "b");
		Thread th3 = new Thread(runnable, "c");
		
		th1.start();
		th2.start();
		th3.start();
		
		
	}

}
