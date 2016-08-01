package checkstyle;

public class Department {

  private String deptName;
  private Student[] studs;

  /**
   * Stuff and stuff.
   * @param deptName ff
   * @param studs ff
   */
  public Department(String deptName, Student[] studs) {
    super();
    this.deptName = deptName;
    this.studs = studs;
  }

  public Department() {
    super();
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public Student[] getStuds() {
    return studs;
  }

  public void setStuds(Student[] studs) {
    this.studs = studs;
  }

  private void printLine() {
    System.out.println("=====================================");
  }

  /**
   * i hate this so much. shoot me. 
   */
  public void printStudentList() {
    printLine();
    System.out.println("=== " + deptName + " ======");
    printLine();
    for (Student stud:studs) {
      System.out.println(stud);
    }
    printLine();
  }
}
