package controller;

import java.util.List;
import model.*;
import view.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * The Junit tests for ServicesController.
 */
public class ServicesControllerTest {
  private ServicesModel model;
  private ServicesView view;
  private ServicesController controller;
  private ArrayList<BookItem> bookItems;
  private BookItem bookItem1, bookItem2, bookItem3;

  /**
   * Sets up for the system.
   */
  @Before
  public void setUp() {
    bookItem1 = new BookItem("001","0001","Dune","Frank Herbert",
        "Science Fiction",10.99);
    bookItem2 = new BookItem("002","0002","1984","George Orwell",
        "Dystopian Fiction",9.99, false, "04/28/2023", "05/28/2023");
    bookItem3 = new BookItem("003","0003","To Kill a Mockingbird","Harper Lee",
        "Coming of Age Fiction",8.99);
    bookItems = new ArrayList<>();
    bookItems.add(bookItem1);
    bookItems.add(bookItem2);
    bookItems.add(bookItem3);
    model = new ServicesModel(bookItems);
    view = org.mockito.Mockito.mock(ServicesView.class);
    controller = new ServicesController(model, view);
  }

  /**
   * Tests the addBookListener in this system.
   */
  @Test
  public void testAddBookListener() {
    controller.new AddBookListener().actionPerformed(null);
    ArrayList<BookItem> books = model.getAllBooks();
    assertEquals(4, books.size());
    assertEquals("001", books.get(0).getId());
    assertEquals("002", books.get(1).getId());
  }

  /**
   * Tests the loanBookListener in this system.
   */
  @Test
  public void testLoanBookListener() {
    List<String> l1 = new ArrayList<>();
    l1.add("001");
    when(view.getSelectedBookItemIDs()).thenReturn(l1);
    controller.new LoanBookListener().actionPerformed(null);
    ArrayList<BookItem> books = model.getAllBooks();
    assertEquals(3, books.size());
    assertEquals(false, bookItem1.isAvailable());
  }

  /**
   * Tests the returnBookListener in this system.
   */
  @Test
  public void testReturnBookListener() {
    List<String> l1 = new ArrayList<>();
    l1.add("002");
    when(view.getSelectedBookItemIDs()).thenReturn(l1);
    controller.new ReturnBookListener().actionPerformed(null);
    ArrayList<BookItem> books = model.getAllBooks();
    assertEquals(3, books.size());
    assertEquals(true, bookItem2.isAvailable());
  }

  /**
   * Tests the deleteBookListener in this system.
   */
  @Test
  public void testDeleteBookListener() {
    List<String> l1 = new ArrayList<>();
    l1.add("001");
    when(view.getSelectedBookItemIDs()).thenReturn(l1);
    controller.new DeleteBookListener().actionPerformed(null);
    ArrayList<BookItem> books = model.getAllBooks();
    assertEquals(2, books.size());
    assertEquals("002", books.get(0).getId());
    assertEquals("003", books.get(1).getId());
  }

  /**
   * Tests the resetBookListener in this system.
   */
  @Test
  public void testResetBookListener() {
    controller.new ResetBookListener().actionPerformed(null);
    ArrayList<BookItem> books = model.getAllBooks();
    assertEquals(3, books.size());
    assertEquals("001", books.get(0).getId());
    assertEquals("002", books.get(1).getId());
    assertEquals("003", books.get(2).getId());
  }

  /**
   * Tests the getSelectedBookItems() method
   */
  @Test
  public void testGetSelectedBookItems() {
    List<String> l1 = new ArrayList<>();
    l1.add("001");
    when(view.getSelectedBookItemIDs()).thenReturn(l1);
    List<BookItem> arr = new ArrayList<>();
    arr.add(bookItem1);
    assertEquals(arr, controller.getSelectedBookItems());
  }
}