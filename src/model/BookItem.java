package model;

import java.util.Objects;

/**
 * The BookItem class extends the Book class and represents a single physical
 * copy of a book in the library.
 */
public class BookItem extends Book {

  private String id;
  private boolean isAvailable;
  private String loanedDate;
  private String dueDate;
  private boolean selected;

  /**
   * Creates a new BookItem object with the specified id, ISBN, title, author,
   * subject, and price. The BookItem is initially marked as available.
   *
   * @param id      the unique identifier of this BookItem
   * @param ISBN    the ISBN of the book
   * @param title   the title of the book
   * @param author  the author of the book
   * @param subject the subject of the book
   * @param price   the price of the book
   */
  public BookItem(String id, String ISBN, String title, String author,
      String subject, double price) {
    super(ISBN, title, author, subject, price);
    this.id = id;
    this.isAvailable = true;
  }

  /**
   * Creates a new BookItem object with the specified id, ISBN, title, author,
   * subject, price, availability, loaned date, and due date.
   *
   * @param id          the unique identifier of this BookItem
   * @param ISBN        the ISBN of the book
   * @param title       the title of the book
   * @param author      the author of the book
   * @param price       the price of the book
   * @param isAvailable true if this BookItem is available for loan, false
   *                    otherwise
   * @param loanedDate  the date this BookItem was loaned out, or null if it is
   *                    not currently loaned out
   * @param dueDate     the due date for this BookItem, or null if it is not
   *                    currently loaned out
   */
  public BookItem(String id, String ISBN, String title, String author,
      String subject, double price, boolean isAvailable, String loanedDate,
      String dueDate) {
    super(ISBN, title, author, subject, price);
    this.id = id;
    this.isAvailable = isAvailable;
    this.loanedDate = loanedDate;
    this.dueDate = dueDate;
  }

  /**
   * Returns the unique id of the BookItem.
   *
   * @return the unique id of the BookItem
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the unique id of the BookItem.
   *
   * @param id the unique id of the BookItem to be set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Returns the availability status of the BookItem.
   *
   * @return the availability status of the BookItem
   */
  public boolean isAvailable() {
    return isAvailable;
  }

  /**
   * Sets the availability status of the BookItem.
   *
   * @param isAvailable the availability status of the BookItem to be set
   */
  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  /**
   * Returns the borrowed date of the BookItem.
   *
   * @return the borrowed date of the BookItem
   */
  public String getLoanedDate() {
    return loanedDate;
  }

  /**
   * Sets the borrowed date of the BookItem.
   *
   * @param loanedDate the borrowed date of the BookItem to be set
   */
  public void setLoanedDate(String loanedDate) {
    this.loanedDate = loanedDate;
  }

  /**
   * Returns the due date of the BookItem.
   *
   * @return the due date of the BookItem
   */
  public String getDueDate() {
    return dueDate;
  }

  /**
   * Sets the due date for this book item.
   *
   * @param dueDate the new due date for this book item
   */
  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  /**
   * Returns a string representation of this book item.
   *
   * @return a string representation of this book item
   */
  @Override
  public String toString() {
    return "BookItem{" +
        "id='" + id + '\'' +
        ", isAvailable=" + isAvailable +
        ", loanedDate='" + loanedDate + '\'' +
        ", dueDate='" + dueDate + '\'' +
        ", selected=" + selected +
        ", ISBN='" + ISBN + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", subject='" + subject + '\'' +
        ", price=" + price +
        '}';
  }

  /**
   * Overrides the equals of the Object class
   *
   * @param object the object to compare
   * @return true if this BookItem is equal to the specified object, false
   * otherwise
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || !(object instanceof BookItem)) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    BookItem bookItem = (BookItem) object;
    return isAvailable == bookItem.isAvailable && selected == bookItem.selected
        && Objects.equals(id, bookItem.id) && Objects.equals(
        loanedDate, bookItem.loanedDate) && Objects.equals(dueDate,
        bookItem.dueDate);
  }

  /**
   * The hashCode method of the BookItem class.
   *
   * @return the hash code of this BookItem object
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), id, isAvailable, loanedDate, dueDate,
        selected);
  }
}
