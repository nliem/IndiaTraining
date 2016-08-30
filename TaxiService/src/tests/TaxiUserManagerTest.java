package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import user.TaxiUser;
import user.TaxiUserManager;

/**
 * Test class. Tests the methods of the TaxiUserManager class.
 * 
 * @author nliem
 *
 */
public class TaxiUserManagerTest {

  /**
   * static TaxiUserManager variable.
   * Tests use this instance to call methods for testing.
   */
  private static TaxiUserManager manager;

  @BeforeClass
  public static void createInstance() {
    manager = TaxiUserManager.getInstance();
  }

  @Test
  public void testAddValid() {
    boolean result = manager.add(new TaxiUser("nataliemegumi@gmail.com", 
        "Natalie Liem", "password", 4295726, "Honolulu"));
    assertTrue(result);
  }

  @Test
  public void testAddNull() {
    boolean result = manager.add(null);
    assertFalse(result);
  }

  @Test
  public void testRemoveValid() {
    boolean result = manager.remove("nataliemegumi@gmail.com");
    assertTrue(result);
  }

  @Test
  public void testRemoveInvalid() {
    boolean result = manager.remove("nonrealemail@test.com");
    assertFalse(result);
  }

  @Test
  public void testRemoveNull() {
    boolean result = manager.remove(null);
    assertFalse(result);
  }

  @Test
  public void testShowInformationValid() {
    TaxiUser user = new TaxiUser("nliem@mail.depaul.edu", 
        "Natalie Liem", "password", 4295726, "Honolulu");
    manager.add(user);
    String result = manager.showInformation("nliem@mail.depaul.edu");
    System.out.println(user);
    System.out.println(result);
    assertEquals(user.toString(), result);
  }

  @Test
  public void testShowInformationInvalid() {
    String result = manager.showInformation("nonrealemail@test.com");
    assertNull(result);
  }

  @Test 
  public void testShowInformationNull() {
    String result = manager.showInformation(null);
    assertNull(result);
  }

  @Test
  public void testFindEntryValid() {
    TaxiUser user = new TaxiUser("nliem@gmail.com", 
        "Natalie Liem", "pass", 4295726, "Chicago");
    manager.add(user);
    TaxiUser result = manager.findEntry("nliem@gmail.com");
    assertEquals(result, user);
  }

  @Test
  public void testFindEntryInvalid() {
    TaxiUser result = manager.findEntry("nonrealmail@test.com");
    assertNull(result);
  }

  @Test
  public void testFindEntryNull() {
    TaxiUser result = manager.findEntry(null);
    assertNull(result);
  }
  
  @Test
  public void testValidateUserValid(){
    TaxiUser user = new TaxiUser();
    user.setEmail("nataliemegumi@gmail.com");
    user.setPassword("password");
    boolean result = manager.validateUser(user);
    assertTrue(result);
  }
  
  @Test
  public void testValidateUserInvalidEmail(){
    TaxiUser user = new TaxiUser();
    user.setEmail("nonrealemail@test.com");
    user.setPassword("pass");
    boolean result = manager.validateUser(user);
    assertFalse(result);
  }
  
  @Test
  public void testValidateUserInvalidPassword(){
    TaxiUser user = new TaxiUser();
    user.setEmail("nataliemegumi@gmail.com");
    user.setPassword("wrong");
    boolean result = manager.validateUser(user);
    assertFalse(result);
  }
  
  @Test
  public void testValidateUserNullEmail(){
    TaxiUser user = new TaxiUser();
    user.setEmail(null);
    user.setPassword("password");
    boolean result = manager.validateUser(user);
    assertFalse(result);
  }
  
  @Test
  public void testValidateUserNullPassword(){
    TaxiUser user = new TaxiUser();
    user.setEmail("nataliemegumi@gmail.com");
    user.setPassword(null);
    boolean result = manager.validateUser(user);
    assertFalse(result);
  }
}
