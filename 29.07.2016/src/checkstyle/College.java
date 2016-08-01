package checkstyle;

import java.util.Arrays;

/**
 * Class representing a college.
 * @author nliem
 *
 */

public class College {

  /**
   * college unique id.
   */
  private int collegeCode;
  
  /**
   * name of college.
   */
  private String collegeName;
  
  /**
   * list of departments in college.
   */
  private Department[] depts;
  
  /**
   * it's a constructor.
   * @param collegeNumber ll
   * @param collegeName pppp
   * @param deptartments iii
   */
  public College(final int collegeNumber, final String collegeName, 
      final Department... deptartments) {
    this.collegeCode = collegeNumber;
    this.collegeName = collegeName;
    this.depts = deptartments;
  }

  /**
   * method returning college code to user.
   * @return int representing college code
   */
  public int getCollegeCode() {
    return collegeCode;
  }

  /**
   * sets college code.
   * @param collegeCode kkkkkk
   */
  public void setCollegeCode(final int collegeCode) {
    this.collegeCode = collegeCode;
  }

  /**
   * returns college name. 
   * @return String representing college name
   */
  public String getCollegeName() {
    return collegeName;
  }

  /**
   * set college name.
   * @param collegeName ohhh
   */
  public void setCollegeName(final String collegeName) {
    this.collegeName = collegeName;
  }

  /**
   * get departments.
   * @return Department array of Departments
   */
  public Department[] getDepts() {
    return depts.clone();
  }

  /**
   * set departments.
   * @param depts omg
   */
  public void setDepts(final Department... depts) {
    this.depts = depts;
  }

  /**
   * turns into pretty string yay.
   */
  @Override
  public String toString() {
    return  Arrays.toString(depts) ;
  }

  /**
   * Method for doing stuff.
   */

  public void printDepartments() {
    for (final Department department:depts) {
      department.printStudentList();
    }
  }
}
