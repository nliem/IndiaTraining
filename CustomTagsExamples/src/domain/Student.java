package domain;

import java.text.DecimalFormat;

public class Student implements Comparable<Student> {
	
	private int id;
	private String name;
	private double mark;
	private String department;
	
	public Student(int id, String name, double mark, String department){
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.department = department;
	}
	
	public Student(){
		super();
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public double getMark(){
		return this.mark;
	}
	
	public void setMark(double mark){
		this.mark = mark;
	}
	
	public String getDepartment(){
		return this.department;
	}
	
	public void setDepartment(String department){
		this.department = department;
	}
	
	@Override
	public int compareTo(Student other){
		if(this.mark > other.mark) return 1;
		if(this.mark < other.mark) return -1;
		return 0;
	}
	
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00");
		StringBuilder sb = new StringBuilder();
		sb.append("Student Name:\t" + this.name).append("\n");
		sb.append("Student ID #:\t" + this.id).append("\n");
		sb.append("Mark:\t\t" + df.format(this.mark) + "%\n");
		return sb.toString();
	}

}
