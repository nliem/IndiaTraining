package proxy;

public class Proxy implements Subject {
	
	private RealSubject rs;

	@Override
	public void grantPermision() {
		if(rs == null){
			rs = new RealSubject();
		}
		rs.grantPermision();
		
	}

	@Override
	public void setEmpGrade(int empGrade) {
		if(rs == null){
			rs = new RealSubject();
		}
		rs.setEmpGrade(empGrade);
		
	}
	
	

}
