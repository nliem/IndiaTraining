package problemsolving;

public class A {
  static{
    System.out.println("static");
  }
  
  
  
  public A(){
    //var setting and stuff
    
    
    //block contents
    System.out.println("block");
  }
  
  
  public static void main(String[] args){
    A a = new A();
    A b = new A();
    A c = new A();
  }

}
