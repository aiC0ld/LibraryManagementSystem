package model;

import java.util.Objects;

/**
 * Represents a book in the library system. The abstract class Book implements
 * the IBook interface.
 */
public abstract class Book implements IBook {

  protected String ISBN;
  protected String title;
  protected String author;
  protected String subject;
  protected double price;

  /**
   * Constructs a new Book object with the specified ISBN, title, author,
   * subject, and price.
   *
   * @param ISBN    the ISBN of the book
   * @param title   the title of the book
   * @param author  the author of the book
   * @param subject the subject of the book
   * @param price   the price of the book
   */
  public Book(String ISBN, String title, String author, String subject,
      double price) {
    this.ISBN = ISBN;
    this.title = title;
    this.author = author;
    this.subject = subject;
    this.price = price;
  }

  /**
   * Gets the ISBN of the book
   *
   * @return the ISBN of the book
   */
  public String getISBN() {
    return ISBN;
  }


  /**
   * Sets the ISBN of the book
   *
   * @param ISBN the new ISBN of the book
   */
  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  /**
   * Returns the title of the book.
   *
   * @return the title of the book
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title of the book.
   *
   * @param title the new title of the book
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Returns the author of the book.
   *
   * @return the author of the book
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Sets the author of the book.
   *
   * @param author the new author of the book
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Returns the subject of the book.
   *
   * @return the subject of the book
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Sets the subject of the book.
   *
   * @param subject the new subject of the book
   */

  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Returns the price of the book in dollars.
   *
   * @return the price of the book in dollars
   */
  public double getPrice() {
    return price;
  }

  /**
   * Sets the price of the book in dollars.
   *
   * @param price the new price of the book in dollars
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * Returns a string representation of the Book object.
   *
   * @return a string representation of the Book object
   */
  @Override
  public String toString() {
    return "Book{" +
        "ISBN='" + ISBN + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", subject='" + subject + '\'' +
        ", price=" + price +
        '}';
  }

  /**
   * Determines whether this Book object is equal to another object.
   *
   * @param object the object to compare to
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || !(object instanceof Book)) {
      return false;
    }
    Book book = (Book) object;
    return Double.compare(book.price, price) == 0
        && Objects.equals(ISBN, book.ISBN) && Objects.equals(
        title, book.title) && Objects.equals(author, book.author)
        && Objects.equals(subject, book.subject);
  }

  /**
   * Generates a hash code for this Book object.
   *
   * @return the hash code for this Book object
   */
  @Override
  public int hashCode() {
    return Objects.hash(ISBN, title, author, subject, price);
  }
}
