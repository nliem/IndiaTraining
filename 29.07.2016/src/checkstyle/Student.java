package checkstyle;

public class Student {

  private int studentId;
  private String studentName;
  private String batchCode;

  public Student() {
    super();

  }

  /**
   * Thank you, Shorab. 
   * @param studentId you
   * @param studentName are
   * @param batchCode ok
   */
  public Student(int studentId, String studentName, String batchCode) {
    super();
    this.studentId = studentId;
    this.studentName = studentName;
    this.batchCode = batchCode;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getBatchCode() {
    return batchCode;
  }

  public void setBatchCode(String batchCode) {
    this.batchCode = batchCode;
  }

  @Override
  public String toString() {
    return studentId + "," + studentName + " ," + batchCode;
  }

}
