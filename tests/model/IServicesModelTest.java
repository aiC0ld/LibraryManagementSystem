package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class IServicesModelTest {

  private ServicesModel services;
  private BookItem bookItem1, bookItem2, bookItem3, bookItem4;

  @Before
  public void setUp() {
    services = new ServicesModel();
    bookItem1 = new BookItem("12345", "1234567890", "The Great Gatsby",
        "F. Scott Fitzgerald", "Classic Literature", 10.99);
    bookItem2 = new BookItem("0987654321", "1234567899",
        "To Kill a Mockingbird", "Harper Lee", "Classic Literature", 12.99,
        false, "04/28/2023", "05/28/2023");
    bookItem3 = new BookItem("12345", "1234567890", "The Great Gatsby",
        "F. Scott Fitzgerald", "Classic Literature", 10.99);
    bookItem4 = new BookItem("1234567890", "1234567890", "The Great Gatsby",
        "F. Scott Fitzgerald", "Classic Literature", 13.99);
    services.addBookItem(bookItem1);
    services.addBookItem(bookItem2);
  }

  /**
   * Tests getBookItemByID() method.
   */
  @Test
  public void testGetBookItemByID() {
    assertNull(services.getBookItemByID("12"));
    assertEquals(bookItem1, services.getBookItemByID("12345"));
  }

  /**
   * Tests getBookItemsByIDs() method. In this method, all the id in the list
   * are valid.
   */
  @Test
  public void testGetBookItemsByIDs() {
    List<String> l1 = new ArrayList<>();
    l1.add("12345");
    List<BookItem> bookItems = new ArrayList<>();
    bookItems.add(bookItem1);
    assertEquals(bookItems, services.getBookItemsByIDs(l1));

    l1.add("0987654321");
    bookItems.add(bookItem2);
    assertEquals(bookItems, services.getBookItemsByIDs(l1));
  }

  /**
   * Tests getAllBooks() method.
   */
  @Test
  public void testGetAllBooks() {
    List<BookItem> bookItems = new ArrayList<>();
    bookItems.add(bookItem1);
    bookItems.add(bookItem2);
    assertEquals(bookItems, services.getAllBooks());
    // test null (empty books)
    IServicesModel service1 = new ServicesModel();
    List<BookItem> bookItems1 = new ArrayList<>();
    assertEquals(bookItems1, service1.getAllBooks());
  }

  /**
   * Tests the addBookItem() method.
   */
  @Test
  public void testAddBookItem() {
    // test the ID of new BookItem is already exists
    assertFalse(services.addBookItem(bookItem3));
    // test add a bookItem successfully
    assertTrue(services.addBookItem(bookItem4));
  }

  /**
   * Tests the updateBookItem() method.
   */
  @Test
  public void testUpdateBookItem() {
    // id is already exists
    boolean updated1 = services.updateBookItem(bookItem1, "1234567890",
        "0987654321", "Updated Book", "", "", 19.99);
    assertTrue(updated1);

    // update bookItem1's ISBN, title, author and price
    boolean updated2 = services.updateBookItem(bookItem2, "", "0987654321",
        "Updated Book", "Test Author", "", 19.99);
    assertTrue(updated2);
    BookItem updatedBookItem = services.getBookItemByID("0987654321");
    assertEquals("0987654321", updatedBookItem.getISBN());
    assertEquals("Updated Book", updatedBookItem.getTitle());
    assertEquals("Test Author", updatedBookItem.getAuthor());
    assertEquals("Classic Literature", updatedBookItem.getSubject());
    assertEquals(19.99, updatedBookItem.getPrice(), 0.01);
  }

  /**
   * Tests the deleteBookItem() method.
   */
  @Test
  public void testDeleteBookItem() {
    List<BookItem> bookItemsToDelete = new ArrayList<>();
    bookItemsToDelete.add(bookItem1);
    bookItemsToDelete.add(bookItem2);
    boolean deleted = services.deleteBookItem(bookItemsToDelete);
    assertTrue(deleted);
    assertEquals(0, services.getAllBooks().size());

    services.addBookItem(bookItem4);
    bookItemsToDelete.add(bookItem4);
    boolean deleted1 = services.deleteBookItem(bookItemsToDelete);
    assertTrue(deleted1);
    assertEquals(0, services.getAllBooks().size());
  }

  /**
   * Tests the searchBookItem() method.
   */
  @Test
  public void testSearchBookItem() {
    ArrayList<BookItem> res1 = new ArrayList<>();
    res1.add(bookItem1);
    // search by ID
    ArrayList<BookItem> res2 = services.searchBookItem("12345", "", "",
        "", "", -1);
    assertEquals(res1, res2);

    // search by author (which is not exactly match)
    res2 = services.searchBookItem("", "", "",
        "F. Scott", "", -1);
    assertEquals(res1, res2);

    // search by subject and author (which is not exactly match)
    res2 = services.searchBookItem("", "", "",
        "F. Scott", "Literature", -1);
    assertEquals(res1, res2);

    // search by price
    res2 = services.searchBookItem("", "", "",
        "", "", 10.99);
    assertEquals(res1, res2);
  }

  /**
   * Tests the loanBookItem() method.
   */
  @Test
  public void testLoanBookItem() {
    services.loanBookItem(bookItem1);
    assertFalse(bookItem1.isAvailable());
    assertEquals("04/28/2023", bookItem1.getLoanedDate());
    assertEquals("05/28/2023", bookItem1.getDueDate());

    services.returnBookItem(bookItem2);
    services.loanBookItem(bookItem2);
    assertFalse(bookItem2.isAvailable());
    assertEquals("04/28/2023", bookItem2.getLoanedDate());
    assertEquals("05/28/2023", bookItem2.getDueDate());
  }

  /**
   * Tests the returnBookItem() method.
   */
  @Test
  public void testReturnBookItem() {
    services.returnBookItem(bookItem2);
    assertTrue(bookItem2.isAvailable());
    assertEquals("", bookItem2.getLoanedDate());
    assertEquals("", bookItem2.getDueDate());

    services.loanBookItem(bookItem1);
    services.returnBookItem(bookItem1);
    assertTrue(bookItem1.isAvailable());
    assertEquals("", bookItem1.getLoanedDate());
    assertEquals("", bookItem1.getDueDate());
  }
}
