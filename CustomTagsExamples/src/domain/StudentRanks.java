package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class StudentRanks {
	
	private HashMap<String, List<Student>> students;
	
	public StudentRanks(){
		this.students = new HashMap<>();
		initialize();
	}
	
	private void initialize(){
		Student s1 = new Student(1, "Natalie", 98.5, "CS");
		Student s2 = new Student(2, "Shorab", 99.0, "CS");
		Student s3 = new Student(3, "Sonny", 94.6, "CS");
		Student s4 = new Student(4, "Lil' D", 80.4, "CS");
		
		ArrayList<Student> csStudents = new ArrayList<>();
		csStudents.add(s1);
		csStudents.add(s2);
		csStudents.add(s3);
		csStudents.add(s4);
		
		this.students.put("CS", csStudents);
		
		s1 = new Student(5, "Michelle", 80.5, "ART");
		s2 = new Student(6, "Nate", 76.0, "ART");
		s3 = new Student(7, "Hina", 98.0, "ART");
		s4 = new Student(8, "Chrissy", 92, "ART");
		
		ArrayList<Student> artStudents = new ArrayList<>();
		artStudents.add(s1);
		artStudents.add(s2);
		artStudents.add(s3);
		artStudents.add(s4);
		
		this.students.put("ART", artStudents);
	}
	
	public List<Student> findTopRankers(String department, double minMark){
		System.out.println("DEPARTMENT RECEIVED = " + department + " (in StudentRanker.java)");
		
		List<Student> departmentStudents = students.get(department);
		
		ArrayList<Student> topStudents = new ArrayList<>();
		
		System.out.println(departmentStudents);
		
		if(departmentStudents == null) return null;
		
		for(Student s : departmentStudents){
			if(s.getMark() > minMark){
				topStudents.add(s);
			}
		}
		
		Collections.sort(topStudents);
		Collections.reverse(topStudents);
		
		return topStudents;
	}

}
