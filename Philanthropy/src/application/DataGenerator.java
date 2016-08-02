package application;

import project.*;
import donor.Donor;
import donor.DonorManager;
import product.*;

/**
 * Class used for generating test data.
 * 
 * @author natalieliem
 *
 */
public class DataGenerator {

  /**
   * Generates test project data.
   */
  private static void generateProjects() {
    CancerCureProject breastCancer = new CancerCureProject(101, "Combatting Breast Cancer Abroad", null, 40000);
    breastCancer.udateProjectDetails(
        "Through education and early detection, we hope to put an end to breast cancer around the globe.");

    CancerCureProject throatCancer = new CancerCureProject(102, "Throat Cancer Mitigation Initiative", null, 25000);
    throatCancer.udateProjectDetails(
        "We will combat throat cancer by targetting activities and behaviors which cause the disease.");

    OldAgeHomeProject careHome = new OldAgeHomeProject(201, "Affordable Care Homes", null, 32000);
    careHome.udateProjectDetails("The high cost of care homes for the elderly is a problem and we should fix it!");

    PrimaryEducationProject villageEducation = new PrimaryEducationProject(301, "Bringing Education to Villages", null,
        57000);
    villageEducation.udateProjectDetails(
        "Let's educate children around the world by bringing primary school programs to remote villages.");

    PrimaryEducationProject adultLiteracy = new PrimaryEducationProject(302, "Adult Literacy", null, 28000);
    adultLiteracy.udateProjectDetails(
        "Adult literacy plagues more people than you think. By helping adults learn to read we can increase opportunities for all.");

    ProjectManager.getInstance().addProject(breastCancer);
    ProjectManager.getInstance().addProject(throatCancer);
    ProjectManager.getInstance().addProject(careHome);
    ProjectManager.getInstance().addProject(villageEducation);
    ProjectManager.getInstance().addProject(adultLiteracy);

    CancerCureProduct doctors = new CancerCureProduct(1011, "Full-Time Doctors",
        "Doctors needed for full-time patient care.", "doctors.jpg", 3000);
    CancerCureProduct mamogramMachines = new CancerCureProduct(1012, "Mamogram Machine",
        "Mamogram machines are essential for early detection of breast cancer.", "mam.jpg", 1500);
    CancerCureProduct technicians = new CancerCureProduct(1021, "Clinic Technicians",
        "Technicians for opperating lab machinery and performing tests.", "tech.jpg", 2500);

    OldAgeHomeProduct wheelchairs = new OldAgeHomeProduct(2011, "Wheelchairs", "To help elderly navigate easily.",
        "wheels.jpg", 3300);
    OldAgeHomeProduct specialBeds = new OldAgeHomeProduct(2012, "Reclining Beds",
        "Special beds to help elderly rest comfortably.", "bed.jpg", 6000);
    OldAgeHomeProduct kneelingVan = new OldAgeHomeProduct(2013, "Kneeling Van",
        "Special van allowing seniors to board and unboard easily.", "van.jpg", 2000);

    PrimaryEducationProduct workbooks = new PrimaryEducationProduct(3011, "Workbooks",
        "Practice books written in the native language of the students.", "books.jpg", 1500);
    PrimaryEducationProduct teachers = new PrimaryEducationProduct(3012, "Teachers",
        "Teachers who will travel to villages to teach.", "teach.jpg", 3400);

    try {
      ProjectManager.getInstance().addProductToProject(101, doctors);
      ProjectManager.getInstance().addProductToProject(101, mamogramMachines);

      ProjectManager.getInstance().addProductToProject(102, technicians);

      ProjectManager.getInstance().addProductToProject(201, wheelchairs);
      ProjectManager.getInstance().addProductToProject(201, specialBeds);
      ProjectManager.getInstance().addProductToProject(201, kneelingVan);

      ProjectManager.getInstance().addProductToProject(301, workbooks);
      ProjectManager.getInstance().addProductToProject(301, teachers);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Generates test donor data.
   */
  private static void generateDonors() {
    Donor natalie = new Donor(1, "Natalie Liem", "nliem2@sapient.com");
    Donor alyssa = new Donor(2, "Alyssa Liem", "aliem95@gmail.com");
    Donor nicole = new Donor(3, "Nicole Kobayashi", "nkobayashi@domain.com");
    Donor ash = new Donor(4, "Ash Ketchum", "catchemall@poke.com");

    DonorManager.getInstance().addDonor(natalie);
    DonorManager.getInstance().addDonor(alyssa);
    DonorManager.getInstance().addDonor(nicole);
    DonorManager.getInstance().addDonor(ash);
  }

  /**
   * Does set up for project and donor data.
   */
  public static void setUp() {
    generateProjects();
    generateDonors();
  }

}
