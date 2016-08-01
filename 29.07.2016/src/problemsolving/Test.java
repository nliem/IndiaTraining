package problemsolving;

import java.util.ArrayList;

public class Test {
  
  public static void main(String[] args){
    Cat c = new Cat();
    Cat c2 = new Cat();
    Elephant e = new Elephant();
    Turtle t = new Turtle();
    
    ArrayList<Animal> zoo = new ArrayList<>();
    zoo.add(c);
    zoo.add(c2);
    zoo.add(e);
    zoo.add(t);
    
    for(Animal a : zoo){
      a.printName();
    }
  }

}
