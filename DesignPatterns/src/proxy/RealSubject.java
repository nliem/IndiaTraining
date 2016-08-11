package proxy;

public class RealSubject implements Subject{

	@Override
	public void grantPermision() {
		System.out.println("Permision granted.");
		
	}

	@Override
	public void setEmpGrade(int empGrade) {
		System.out.println("Employee grade set to " + empGrade);
		
	}

}
