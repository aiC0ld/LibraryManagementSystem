package model;

import io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The Services class represents a library service that manages book items. It
 * provides methods for adding, updating, deleting, and searching book items, as
 * well as loading and returning them.
 */
public class ServicesModel implements IServicesModel {

  private ArrayList<BookItem> books;
  private final IO IO;

  /**
   * Constructs a new Services object with an empty list of book items and a new
   * IO object.
   */
  public ServicesModel() {
    this.books = new ArrayList<>();
    this.IO = new IO();
  }

  /**
   * Constructs a new ServicesModel with an arrayList. This construct is used
   * for test only.
   * @param arr the arrayList
   */
  public ServicesModel(ArrayList<BookItem> arr) {
    this.books = arr;
    this.IO = new IO();
  }

  /**
   * Loads the list of BookItems from persistent storage.
   *
   * @return true if the loading was successful, false otherwise
   */
  public boolean loadBooks() {
    // uses for test
    if (!books.isEmpty()) {
      return true;
    }
    // load from txt
    List<BookItem> BookItemList = IO.load();
    if (BookItemList == null) {
      return false;
    }
    books.clear();
    books.addAll(BookItemList);
    return true;
  }

  /**
   * Saves the list of BookItems to persistent storage.
   *
   * @param books the list of BookItems to be saved
   * @return true if the saving was successful, false otherwise
   */
  public boolean saveBooks(List<BookItem> books) {
    return IO.save(books);
  }

  /**
   * Returns the book item with the specified ID, or null if no such book item
   * exists in the list.
   *
   * @param id The ID of the book item to retrieve.
   * @return The book item with the specified ID, or null if no such book item
   * exists in the list.
   */
  public BookItem getBookItemByID(String id) {
    for (BookItem b : books) {
      if (b.getId().equals(id)) {
        return b;
      }
    }
    return null;
  }

  /**
   * Returns a list of book items with the specified IDs.
   *
   * @param ids The list of IDs of the book items to retrieve.
   * @return The list of book items with the specified IDs.
   */
  public List<BookItem> getBookItemsByIDs(List<String> ids) {
    List<BookItem> bookItems = new ArrayList<>();
    for (String id : ids) {
      BookItem bookItem = getBookItemByID(id);
      bookItems.add(bookItem);
    }
    return bookItems;
  }

  /**
   * Returns a list of all book items managed by this service.
   *
   * @return The list of all book items managed by this service.
   */
  public ArrayList<BookItem> getAllBooks() {
    if (books.isEmpty()) {
      return new ArrayList<>();
    }
    return books;
  }

  /**
   * Adds the specified book item to the list of book items managed by this
   * service, if no book item with the same ID already exists in the list.
   *
   * @param bookItem The book item to add.
   * @return true if the book item was successfully added, false otherwise.
   */
  public boolean addBookItem(BookItem bookItem) {
    // check whether the id is exists
    if (getBookItemByID(bookItem.getId()) != null) {
      return false;
    }
    boolean add = books.add(bookItem);
    saveBooks(books);
    return add;
  }

  /**
   * Updates the specified book item with the specified fields, if they are not
   * empty or -1.
   *
   * @param bookItem The book item to update.
   * @param id       The new ID for the book item, or an empty string if the ID
   *                 should not be updated.
   * @param ISBN     The new ISBN for the book item, or an empty string if the
   *                 ISBN should not be updated.
   * @param title    The new title for the book item, or an empty string if the
   *                 title should not be updated.
   * @param author   The new author for the book item, or an empty string if the
   *                 author should not be updated.
   * @param subject  The new subject for the book item, or an empty string if
   *                 the subject should not be updated.
   * @param price    The new price for the book item, or -1 if the price should
   *                 not be updated.
   * @return true if the book item was successfully updated, false otherwise.
   */
  public boolean updateBookItem(BookItem bookItem, String id, String ISBN,
      String title, String author, String subject, double price) {
    if (!id.isEmpty()) {
      // check whether the id is exists
      if (getBookItemByID(id) != null) {
        return false;
      }
      bookItem.setId(id);
    }
    if (!ISBN.isEmpty()) {
      bookItem.setISBN(ISBN);
    }
    if (!title.isEmpty()) {
      bookItem.setTitle(title);
    }
    if (!author.isEmpty()) {
      bookItem.setAuthor(author);
    }
    if (!subject.isEmpty()) {
      bookItem.setSubject(subject);
    }
    if (price != -1) {
      bookItem.setPrice(price);
    }
    saveBooks(books);
    return true;
  }

  /**
   * Deletes the specified list of book items from the list of book items
   * managed by this service.
   *
   * @param bookItems The list of book items to delete.
   * @return true if any book items were successfully deleted, false otherwise.
   */
  public boolean deleteBookItem(List<BookItem> bookItems) {
    boolean deleted = false;
    for (BookItem bookItem : bookItems) {
      boolean delete = books.remove(bookItem);
      if (delete) {
        deleted = true;
      }
    }
    saveBooks(books);
    return deleted;
  }

  /**
   * Searches for book items based on the given parameters.
   *
   * @param id      the ID of the book item to search for
   * @param ISBN    the ISBN of the book to search for
   * @param title   the title of the book to search for
   * @param author  the author of the book to search for
   * @param subject the subject of the book to search for
   * @param price   the price of the book to search for
   * @return an ArrayList of BookItems that match the search criteria
   */
  public ArrayList<BookItem> searchBookItem(String id, String ISBN,
      String title, String author, String subject, double price) {
    ArrayList<BookItem> list1 = new ArrayList<>(getAllBooks());
    ArrayList<BookItem> list2 = new ArrayList<>();
    if (!id.isEmpty()) {
      for (BookItem b : list1) {
        if (b.getId().equals(id)) {
          list2.add(b);
        }
      }
      list1 = new ArrayList<>(list2);
      list2 = new ArrayList<>();
    }
    if (!ISBN.isEmpty()) {
      for (BookItem b : list1) {
        if (b.getISBN().equals(ISBN)) {
          list2.add(b);
        }
      }
      list1 = new ArrayList<>(list2);
      list2 = new ArrayList<>();
    }
    if (!title.isEmpty()) {
      for (BookItem b : list1) {
        if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
          list2.add(b);
        }
      }
      list1 = new ArrayList<>(list2);
      list2 = new ArrayList<>();
    }
    if (!author.isEmpty()) {
      for (BookItem b : list1) {
        if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
          list2.add(b);
        }
      }
      list1 = new ArrayList<>(list2);
      list2 = new ArrayList<>();
    }
    if (!subject.isEmpty()) {
      for (BookItem b : list1) {
        if (b.getSubject().toLowerCase().contains(subject.toLowerCase())) {
          list2.add(b);
        }
      }
      list1 = new ArrayList<>(list2);
      list2 = new ArrayList<>();
    }
    if (price != -1) {
      for (BookItem b : list1) {
        if (Math.abs(b.getPrice() - price) <= 0.1) {
          list2.add(b);
        }
      }
      list1 = new ArrayList<>(list2);
    }
    return list1;
  }

  /**
   * Implements how should we update the bookItem for loan action. Marks the
   * given BookItem as borrowed and updates its borrowed and due dates.
   * The step of checking whether the bookItem is available is belongs to the
   * controller class.
   *
   * @param bookItem the BookItem to be borrowed
   */
  public void loanBookItem(BookItem bookItem) {
    // update status as "false"
    bookItem.setAvailable(false);
    // set LoanDate
    Date date = Calendar.getInstance().getTime();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    bookItem.setLoanedDate(dateFormat.format(date));
    // set DueDate
    Calendar now = Calendar.getInstance();
    now.add(Calendar.MONTH, 1);
    Date dueDate = now.getTime();
    bookItem.setDueDate(dateFormat.format(dueDate));
    saveBooks(books);
  }

  /**
   * Marks the given BookItem as returned and clears its borrowed and due
   * dates.
   *
   * @param bookItem the BookItem to be returned
   */
  public void returnBookItem(BookItem bookItem) {
    bookItem.setAvailable(true);
    bookItem.setLoanedDate("");
    bookItem.setDueDate("");
    saveBooks(books);
  }
}
