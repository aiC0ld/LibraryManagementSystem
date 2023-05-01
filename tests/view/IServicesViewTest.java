package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import org.junit.Test;
import org.junit.Before;

/**
 * Junit tests for IServicesView.
 */
public class IServicesViewTest {

  private IServicesView servicesView1, servicesView2;

  /**
   * Sets up the IServicesView.
   */
  @Before
  public void setUp() {
    servicesView1 = new ServicesView();
    servicesView2 = new ServicesView();
  }

  /**
   * Tests the clearForm() method
   */
  @Test
  public void testClearForm() {
    servicesView1.clearForm();

    assertNotNull(servicesView1);
    assertEquals("", servicesView1.getBookItemID());
    assertEquals("", servicesView1.getBookItemISBN());
    assertEquals("", servicesView1.getBookItemTitle());
    assertEquals("", servicesView1.getBookItemAuthor());
    assertEquals("", servicesView1.getBookItemSubject());
    assertEquals(-1, servicesView1.getBookItemPrice(), 0.01);
  }

  /**
   * Tests the getTable() method
   */
  @Test
  public void testGetTable() {
    JTable table1 = servicesView1.getTable();
    assertNotNull(table1); // check if not null
    assertTrue(table1 instanceof JTable); // check if of correct type

    JTable table2 = servicesView2.getTable();
    assertNotNull(table2);
    assertTrue(table2 instanceof JTable);
  }

  /**
   * Tests the getBookItemID() method
   */
  @Test
  public void testGetBookItemID() {
    String bookItemID1 = servicesView1.getBookItemID();
    assertEquals("", bookItemID1);

    String bookItemID2 = servicesView2.getBookItemID();
    assertEquals("", bookItemID2);
  }

  /**
   * Tests the getBookItemISBN() method
   */
  @Test
  public void testGetBookItemISBN() {
    String ISBN1 = servicesView1.getBookItemISBN();
    assertEquals("", ISBN1);

    String ISBN2 = servicesView2.getBookItemISBN();
    assertEquals("", ISBN2);
  }

  /**
   * Tests the getBookItemTitle() method
   */
  @Test
  public void testGetBookItemTitle() {
    String title1 = servicesView1.getBookItemTitle();
    assertEquals("", title1);

    String title2 = servicesView2.getBookItemTitle();
    assertEquals("", title2);
  }

  /**
   * Tests the getBookItemAuthor() method
   */
  @Test
  public void testGetBookItemAuthor() {
    String author1 = servicesView1.getBookItemAuthor();
    assertEquals("", author1);

    String author2 = servicesView2.getBookItemAuthor();
    assertEquals("", author2);
  }

  /**
   * Tests the getBookItemSubject() method
   */
  @Test
  public void testGetBookItemSubject() {
    String subject1 = servicesView1.getBookItemSubject();
    assertEquals("", subject1);

    String subject2 = servicesView2.getBookItemSubject();
    assertEquals("", subject2);
  }

  /**
   * Tests the getBookItemPrice() method
   */
  @Test
  public void testGetBookItemPrice() {
    double price1 = servicesView1.getBookItemPrice();
    assertEquals(-1., price1, 0.01);

    double price2 = servicesView2.getBookItemPrice();
    assertEquals(-1, price2, 0.01);
  }

  /**
   * Tests the getSelectedBookItemIDs() method
   */
  @Test
  public void testGetSelectedBookItemIDs() {
    List<String> bookItemIDs = new ArrayList<>();
    assertNotNull(servicesView1);
    assertEquals(bookItemIDs, servicesView1.getSelectedBookItemIDs());
    assertEquals(bookItemIDs, servicesView2.getSelectedBookItemIDs());
  }

  /**
   * Tests displayBooks() method.
   */
  @Test
  public void testDisplayBooks() {
    // Create a mock list of books
    ArrayList<BookItem> books = new ArrayList<>();
    books.add(
        new BookItem("1", "1234567890", "Book 1", "Author 1", "Subject 1", 10,
            true, null, null));
    books.add(
        new BookItem("2", "0987654321", "Book 2", "Author 2", "Subject 2", 20,
            false, "2023-04-28", "2023-05-05"));

    // Call the displayBooks() method with the mock list of books
    servicesView1.displayBooks(books);

    // Verify that the bookTable has the correct data
    DefaultTableModel model = (DefaultTableModel) servicesView1.getTable()
        .getModel();
    assertEquals(2, model.getRowCount());
    assertEquals("1", model.getValueAt(0, 0));
    assertEquals("1234567890", model.getValueAt(0, 1));
    assertEquals("Book 1", model.getValueAt(0, 2));
    assertEquals("Author 1", model.getValueAt(0, 3));
    assertEquals("Subject 1", model.getValueAt(0, 4));
    assertEquals("10", model.getValueAt(0, 5));
    assertEquals(true, model.getValueAt(0, 6));
    assertEquals(null, model.getValueAt(0, 7));
    assertEquals(null, model.getValueAt(0, 8));

    assertEquals("2", model.getValueAt(1, 0));
    assertEquals("0987654321", model.getValueAt(1, 1));
    assertEquals("Book 2", model.getValueAt(1, 2));
    assertEquals("Author 2", model.getValueAt(1, 3));
    assertEquals("Subject 2", model.getValueAt(1, 4));
    assertEquals("20", model.getValueAt(1, 5));
    assertEquals(false, model.getValueAt(1, 6));
    assertEquals("2023-04-28", model.getValueAt(1, 7));
    assertEquals("2023-05-05", model.getValueAt(1, 8));
  }

  /**
   * Tests the getAddButton() method
   */
  @Test
  public void testGetAddButton() {
    assertEquals("Add", servicesView1.getAddButton().getText());
    assertEquals("Add", servicesView2.getAddButton().getText());
  }

  /**
   * Tests addBookListener() method.
   */
  @Test
  public void testAddListener() {
    ActionListener mockListener = mock(ActionListener.class);
    servicesView1.addBookListener(mockListener);
    servicesView1.getAddButton().doClick();
    verify(mockListener, times(1)).actionPerformed(any(ActionEvent.class));
  }

  /**
   * Tests the getUpdateButton() method
   */
  @Test
  public void testGetUpdateButton() {
    assertEquals("Update", servicesView1.getUpdateButton().getText());
    assertEquals("Update", servicesView2.getUpdateButton().getText());
  }

  /**
   * Tests updateBookListener() method.
   */
  @Test
  public void testUpdateListener() {
    ActionListener mockListener = mock(ActionListener.class);
    servicesView1.updateBookListener(mockListener);
    servicesView1.getUpdateButton().doClick();
    verify(mockListener, times(1)).actionPerformed(any(ActionEvent.class));
  }

  /**
   * Tests the getDeleteButton() method
   */
  @Test
  public void testGetDeleteButton() {
    assertEquals("Delete", servicesView1.getDeleteButton().getText());
    assertEquals("Delete", servicesView2.getDeleteButton().getText());
  }

  /**
   * Tests deleteBookListener() method.
   */
  @Test
  public void testDeleteListener() {
    ActionListener mockListener = mock(ActionListener.class);
    servicesView1.deleteBookListener(mockListener);
    servicesView1.getDeleteButton().doClick();
    verify(mockListener, times(1)).actionPerformed(any(ActionEvent.class));
  }

  /**
   * Tests the getSearchButton() method
   */
  @Test
  public void testGetSearchButton() {
    assertEquals("Search", servicesView1.getSearchButton().getText());
    assertEquals("Search", servicesView2.getSearchButton().getText());
  }

  /**
   * Tests searchBookListener() method.
   */
  @Test
  public void testSearchListener() {
    ActionListener mockListener = mock(ActionListener.class);
    servicesView1.searchBookListener(mockListener);
    servicesView1.getSearchButton().doClick();
    verify(mockListener, times(1)).actionPerformed(any(ActionEvent.class));
  }

  /**
   * Tests the getResetButton() method
   */
  @Test
  public void testGetResetButton() {
    assertEquals("Reset", servicesView1.getResetButton().getText());
    assertEquals("Reset", servicesView2.getResetButton().getText());
  }

  /**
   * Tests resetBookListener() method.
   */
  @Test
  public void testResetListener() {
    ActionListener mockListener = mock(ActionListener.class);
    servicesView1.resetBookListener(mockListener);
    servicesView1.getResetButton().doClick();
    verify(mockListener, times(1)).actionPerformed(any(ActionEvent.class));
  }

  /**
   * Tests the getLoanButton() method
   */
  @Test
  public void testGetLoanButton() {
    assertEquals("Loan", servicesView1.getLoanButton().getText());
    assertEquals("Loan", servicesView2.getLoanButton().getText());
  }

  /**
   * Tests loanBookListener() method.
   */
  @Test
  public void testLoanListener() {
    ActionListener mockListener = mock(ActionListener.class);
    servicesView1.loanBookListener(mockListener);
    servicesView1.getLoanButton().doClick();
    verify(mockListener, times(1)).actionPerformed(any(ActionEvent.class));
  }

  /**
   * Tests the getReturnButton() method
   */
  @Test
  public void testGetReturnButton() {
    assertEquals("Return", servicesView1.getReturnButton().getText());
    assertEquals("Return", servicesView2.getReturnButton().getText());
  }

  /**
   * Tests returnBookListener() method.
   */
  @Test
  public void testReturnListener() {
    ActionListener mockListener = mock(ActionListener.class);
    servicesView1.returnBookListener(mockListener);
    servicesView1.getReturnButton().doClick();
    verify(mockListener, times(1)).actionPerformed(any(ActionEvent.class));
  }
}