package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * The LibrarianTest class contains JUnit tests for the LibrarianLoginModel class.
 */
public class ILibrarianLoginModelTest {

  private ILibrarianLoginModel librarian1, librarian2;

  /**
   * Sets up a new Librarian object with username "lms" and password "123"
   * before each test.
   */
  @Before
  public void setUp() {
    librarian1 = new LibrarianLoginModel("lms", "123");
    librarian2 = new LibrarianLoginModel("vera", "lms");
  }

  /**
   * Tests the getUsername method of the Librarian class.
   */
  @Test
  public void testGetUsername() {
    assertEquals("lms", librarian1.getUsername());
    assertEquals("vera", librarian2.getUsername());
  }

  /**
   * Tests the setUsername method of the Librarian class.
   */
  @Test
  public void testSetUsername() {
    librarian1.setUsername("newusername");
    assertEquals("newusername", librarian1.getUsername());
    librarian2.setUsername("newusername");
    assertEquals("newusername", librarian2.getUsername());
  }

  /**
   * Tests the getPassword method of the Librarian class.
   */
  @Test
  public void testGetPassword() {
    assertEquals("123", librarian1.getPassword());
    assertEquals("lms", librarian2.getPassword());
  }

  /**
   * Tests the setPassword method of the Librarian class.
   */
  @Test
  public void testSetPassword() {
    librarian1.setPassword("newpassword");
    assertEquals("newpassword", librarian1.getPassword());
    librarian2.setPassword("newpassword");
    assertEquals("newpassword", librarian2.getPassword());
  }

  /**
   * Tests the getLoginStatus method of the Librarian class.
   */
  @Test
  public void testGetLoginStatus() {
    librarian1.setPassword("lms");
    assertTrue(librarian1.getLoginStatus());
    assertFalse(librarian2.getLoginStatus());
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    String s1 = "LibrarianLoginModel{username='lms', password='123'}";
    assertEquals(s1, librarian1.toString());
    String s2 = "LibrarianLoginModel{username='vera', password='lms'}";
    assertEquals(s2, librarian2.toString());
  }
}