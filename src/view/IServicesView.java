package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import model.BookItem;

/**
 * The IServicesView interface contains all the operations IServicesView should
 * have.
 */
public interface IServicesView {

  /**
   * Displays an error message dialog box with the given error message.
   *
   * @param errorMessage the error message to display
   */
  void displayErrorMessage(String errorMessage);

  /**
   * Displays a success message dialog box with the given success message.
   *
   * @param successMessage the success message to display
   */
  void displaySuccessMessage(String successMessage);

  /**
   * Clears the text fields in the GUI.
   */
  void clearForm();

  /**
   * Returns the JTable used to display the books.
   *
   * @return the JTable used to display the books
   */
  JTable getTable();

  /**
   * Returns the ID entered in the ID text field.
   *
   * @return the ID entered in the ID text field
   */
  String getBookItemID();

  /**
   * Returns the ISBN entered in the ISBN text field.
   *
   * @return the ISBN entered in the ISBN text field
   */
  String getBookItemISBN();

  /**
   * Returns the title entered in the title text field.
   *
   * @return the title entered in the title text field
   */
  String getBookItemTitle();

  /**
   * Returns the author entered in the author text field.
   *
   * @return the author entered in the author text field
   */
  String getBookItemAuthor();

  /**
   * Returns the subject entered in the subject text field.
   *
   * @return the subject entered in the subject text field
   */
  String getBookItemSubject();

  /**
   * Returns the price entered in the price text field.
   *
   * @return the price entered in the price text field, or -1 if the field is
   * empty
   */
  double getBookItemPrice();

  /**
   * Returns a list of the selected book item IDs in the table.
   *
   * @return a list of the selected book item IDs in the table
   */
  List<String> getSelectedBookItemIDs();

  /**
   * Displays the given list of books in the table.
   *
   * @param books the list of books to display
   */
  void displayBooks(ArrayList<BookItem> books);

  /**
   * Adds an action listener to the Add button.
   *
   * @param listener the action listener to add
   */
  void addBookListener(ActionListener listener);

  /**
   * Gets the addButton of this UI
   *
   * @return the addButton of this UI
   */
  JButton getAddButton();

  /**
   * Adds an action listener to the Update button.
   *
   * @param listener the action listener to add
   */
  void updateBookListener(ActionListener listener);

  /**
   * Gets the updateButton of this UI
   *
   * @return the updateButton of this UI
   */
  JButton getUpdateButton();

  /**
   * Adds an action listener to the Delete button.
   *
   * @param listener the action listener to add
   */
  void deleteBookListener(ActionListener listener);

  /**
   * Gets the deleteButton of this UI
   *
   * @return the deleteButton of this UI
   */
  JButton getDeleteButton();

  /**
   * Adds an action listener to the Search button.
   *
   * @param listener the action listener to add
   */
  void searchBookListener(ActionListener listener);

  /**
   * Gets the searchButton of this UI
   *
   * @return the searchButton of this UI
   */
  JButton getSearchButton();

  /**
   * Adds an action listener to the Reset button.
   *
   * @param listener the action listener to add
   */
  void resetBookListener(ActionListener listener);

  /**
   * Gets the resetButton of this UI
   *
   * @return the resetButton of this UI
   */
  JButton getResetButton();

  /**
   * Adds an action listener to the Borrow button.
   *
   * @param listener the action listener to add
   */
  void loanBookListener(ActionListener listener);

  /**
   * Gets the loanButton of this UI
   *
   * @return the loanButton of this UI
   */
  JButton getLoanButton();

  /**
   * Adds an action listener to the Return button.
   *
   * @param listener the action listener to add
   */
  void returnBookListener(ActionListener listener);

  /**
   * Gets the returnButton of this UI
   *
   * @return the returnButton of this UI
   */
  JButton getReturnButton();
}
