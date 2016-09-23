package openClosedPrinciple;

public class Circle implements Shape {
	
	private double radius;
	
	public Circle(){
		super();
	}
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public double getRadius(){
		return this.radius;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}

	@Override
	public double getArea() {
		double area = 0;
		
		area = Math.PI * radius * radius;

		return area;
	}

}
