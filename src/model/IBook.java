package model;

/**
 * This IBook interface contains all operations that all types of IBook should
 * support.
 */
public interface IBook {

  /**
   * Returns the unique id of the BookItem.
   *
   * @return the unique id of the BookItem
   */
  String getId();

  /**
   * Sets the unique id of the BookItem.
   *
   * @param id the unique id of the BookItem to be set
   */
  void setId(String id);

  /**
   * Gets the ISBN of the book
   *
   * @return the ISBN of the book
   */
  String getISBN();

  /**
   * Sets the ISBN of the book
   *
   * @param ISBN the new ISBN of the book
   */
  void setISBN(String ISBN);

  /**
   * Returns the title of the book.
   *
   * @return the title of the book
   */
  String getTitle();

  /**
   * Sets the title of the book.
   *
   * @param title the new title of the book
   */
  void setTitle(String title);

  /**
   * Returns the author of the book.
   *
   * @return the author of the book
   */
  String getAuthor();

  /**
   * Sets the author of the book.
   *
   * @param author the new author of the book
   */
  void setAuthor(String author);

  /**
   * Returns the subject of the book.
   *
   * @return the subject of the book
   */
  String getSubject();

  /**
   * Sets the subject of the book.
   *
   * @param subject the new subject of the book
   */

  void setSubject(String subject);

  /**
   * Returns the price of the book in dollars.
   *
   * @return the price of the book in dollars
   */
  double getPrice();

  /**
   * Sets the price of the book in dollars.
   *
   * @param price the new price of the book in dollars
   */
  void setPrice(double price);

  /**
   * Returns the availability status of the BookItem.
   *
   * @return the availability status of the BookItem
   */
  boolean isAvailable();

  /**
   * Sets the availability status of the BookItem.
   *
   * @param isAvailable the availability status of the BookItem to be set
   */
  void setAvailable(boolean isAvailable);

  /**
   * Returns the borrowed date of the BookItem.
   *
   * @return the borrowed date of the BookItem
   */
  String getLoanedDate();

  /**
   * Sets the borrowed date of the BookItem.
   *
   * @param loanedDate the borrowed date of the BookItem to be set
   */
  void setLoanedDate(String loanedDate);

  /**
   * Returns the due date of the BookItem.
   *
   * @return the due date of the BookItem
   */
  String getDueDate();

  /**
   * Sets the due date for this book item.
   *
   * @param dueDate the new due date for this book item
   */
  void setDueDate(String dueDate);
}
