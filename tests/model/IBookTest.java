package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Junit test class for the IBook.
 */
public class IBookTest {

  private BookItem bookItem1, bookItem2;

  /**
   * Sets up a new book and book item for each test case.
   */
  @Before
  public void setUp() {
    bookItem1 = new BookItem("12345", "1234567890", "The Great Gatsby",
        "F. Scott Fitzgerald", "Classic Literature", 10.99);
    bookItem2 = new BookItem("0987654321", "1234567899",
        "To Kill a Mockingbird", "Harper Lee", "Classic Literature", 12.99,
        false, "04/28/2023", "05/28/2023");
  }

  /**
   * Tests the getISBN() method.
   */
  @Test
  public void testGetISBN() {
    assertEquals("1234567890", bookItem1.getISBN());
    assertEquals("1234567899", bookItem2.getISBN());
  }

  /**
   * Tests the setISBN() method.
   */
  @Test
  public void testSetISBN() {
    bookItem1.setISBN("1111111111");
    assertEquals("1111111111", bookItem1.getISBN());
    bookItem2.setISBN("2222222222");
    assertEquals("2222222222", bookItem2.getISBN());
  }

  /**
   * Tests the getTitle() method.
   */
  @Test
  public void testGetTitle() {
    assertEquals("The Great Gatsby", bookItem1.getTitle());
    assertEquals("To Kill a Mockingbird", bookItem2.getTitle());
  }

  /**
   * Tests the setTitle(String) method.
   */
  @Test
  public void testSetTitle() {
    bookItem1.setTitle("The Catcher in the Rye");
    assertEquals("The Catcher in the Rye", bookItem1.getTitle());
    bookItem2.setTitle("Pride and Prejudice");
    assertEquals("Pride and Prejudice", bookItem2.getTitle());
  }

  /**
   * Tests the getAuthor() method.
   */
  @Test
  public void testGetAuthor() {
    assertEquals("F. Scott Fitzgerald", bookItem1.getAuthor());
    assertEquals("Harper Lee", bookItem2.getAuthor());
  }

  /**
   * Tests the setAuthor() method.
   */
  @Test
  public void testSetAuthor() {
    bookItem1.setAuthor("J.D. Salinger");
    assertEquals("J.D. Salinger", bookItem1.getAuthor());
    bookItem2.setAuthor("Jane Austen");
    assertEquals("Jane Austen", bookItem2.getAuthor());
  }

  /**
   * Tests the getSubject() method.
   */
  @Test
  public void testGetSubject() {
    assertEquals("Classic Literature", bookItem1.getSubject());
    assertEquals("Classic Literature", bookItem2.getSubject());
  }

  /**
   * Tests the setSubject() method.
   */
  @Test
  public void testSetSubject() {
    bookItem1.setSubject("Modern Literature");
    assertEquals("Modern Literature", bookItem1.getSubject());
    bookItem2.setSubject("Romance");
    assertEquals("Romance", bookItem2.getSubject());
  }

  /**
   * Tests the getPrice() method.
   */
  @Test
  public void testGetPrice() {
    assertEquals(10.99, bookItem1.getPrice(), 0.01);
    assertEquals(12.99, bookItem2.getPrice(), 0.01);
  }

  /**
   * Tests the setPrice() method.
   */
  @Test
  public void testSetPrice() {
    bookItem1.setPrice(11.99);
    assertEquals(11.99, bookItem1.getPrice(), 0.01);
    bookItem2.setPrice(10.99);
    assertEquals(10.99, bookItem2.getPrice(), 0.01);
  }

  /**
   * Tests the getId() method of the BookItem class.
   */
  @Test
  public void testGetId() {
    assertEquals("12345", bookItem1.getId());
    assertEquals("0987654321", bookItem2.getId());
  }

  /**
   * Tests the setId method of the BookItem class.
   */
  @Test
  public void testSetId() {
    bookItem1.setId("67890");
    assertEquals("67890", bookItem1.getId());
    bookItem2.setId("67890");
    assertEquals("67890", bookItem2.getId());
  }

  /**
   * Tests the isAvailable method of the BookItem class.
   */
  @Test
  public void testIsAvailable() {
    assertTrue(bookItem1.isAvailable());
    assertFalse(bookItem2.isAvailable());
  }

  /**
   * Tests the setAvailable method of the BookItem class.
   */
  @Test
  public void testSetAvailable() {
    bookItem1.setAvailable(false);
    assertFalse(bookItem1.isAvailable());
    bookItem2.setAvailable(true);
    assertTrue(bookItem2.isAvailable());
  }

  /**
   * Tests the getLoanDate() methods of the BookItem class.
   */
  @Test
  public void testGetLoanedDate() {
    assertNull(bookItem1.getLoanedDate());
    assertEquals("04/28/2023", bookItem2.getLoanedDate());
  }

  /**
   * Tests the setLoanDate() methods of the BookItem class.
   */
  @Test
  public void testSetLoanedDate() {
    bookItem1.setLoanedDate("04/24/2023");
    assertEquals("04/24/2023", bookItem1.getLoanedDate());
    bookItem2.setLoanedDate("04/24/2023");
    assertEquals("04/24/2023", bookItem2.getLoanedDate());
  }

  /**
   * Tests the getDueDate() methods of the BookItem class.
   */
  @Test
  public void testGetDueDate() {
    assertNull(bookItem1.getDueDate());
    assertEquals("05/28/2023", bookItem2.getDueDate());
  }

  /**
   * Tests the setDueDate() methods of the BookItem class.
   */
  @Test
  public void testSetDueDate() {
    bookItem1.setDueDate("05/28/2023");
    assertEquals("05/28/2023", bookItem1.getDueDate());
    bookItem2.setDueDate("05/25/2023");
    assertEquals("05/25/2023", bookItem2.getDueDate());
  }

  /**
   * Tests the toString() method of the BookItem class.
   */
  @Test
  public void testToString() {
    String expected1 =
        "BookItem{id='12345', isAvailable=true, loanedDate='null'"
            + ", dueDate='null', selected=false, ISBN='1234567890', title='The Great"
            + " Gatsby', author='F. Scott Fitzgerald', subject='Classic Literature',"
            + " price=10.99}";
    assertEquals(expected1, bookItem1.toString());
    String expected2 =
        "BookItem{id='0987654321', isAvailable=false, loanedDate="
            + "'04/28/2023', dueDate='05/28/2023', selected=false, ISBN='1234567899',"
            + " title='To Kill a Mockingbird', author='Harper Lee', subject='Classic"
            + " Literature', price=12.99}";
    assertEquals(expected2, bookItem2.toString());
  }

  /**
   * Tests the equals() of the BookItem class.
   */
  @Test
  public void testEquals() {
    BookItem bookItem3 = new BookItem("12345", "1234567890", "The Great Gatsby",
        "F. Scott Fitzgerald", "Classic Literature", 10.99);
    assertTrue(bookItem1.equals(bookItem3));
    assertFalse(bookItem2.equals(bookItem3));
  }
}