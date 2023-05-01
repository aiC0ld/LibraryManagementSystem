package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The IServicesModel interface represents the services offered by a model that
 * manages a collection of book items. It defines methods for retrieving,
 * adding, updating, and deleting book items, as well as for searching and
 * loaning/returning book items.
 */
public interface IServicesModel {

  /**
   * Loads the list of BookItems from persistent storage.
   *
   * @return true if the loading was successful, false otherwise
   */
  boolean loadBooks();

  /**
   * Saves the list of BookItems to persistent storage.
   *
   * @param books the list of BookItems to be saved
   * @return true if the saving was successful, false otherwise
   */
  boolean saveBooks(List<BookItem> books);

  /**
   * Returns the book item with the specified ID, or null if no such book item
   * exists in the list.
   *
   * @param id The ID of the book item to retrieve.
   * @return The book item with the specified ID, or null if no such book item
   * exists in the list.
   */
  BookItem getBookItemByID(String id);

  /**
   * Returns a list of book items with the specified IDs.
   *
   * @param ids The list of IDs of the book items to retrieve.
   * @return The list of book items with the specified IDs.
   */
  List<BookItem> getBookItemsByIDs(List<String> ids);

  /**
   * Returns a list of all book items managed by this service.
   *
   * @return The list of all book items managed by this service.
   */
  List<BookItem> getAllBooks();

  /**
   * Adds the specified book item to the list of book items managed by this
   * service, if no book item with the same ID already exists in the list.
   *
   * @param bookItem The book item to add.
   * @return true if the book item was successfully added, false otherwise.
   */
  boolean addBookItem(BookItem bookItem);

  /**
   * Updates the specified book item with the specified fields, if they are not
   * empty or -1.
   *
   * @param bookItem The book item to update.
   * @param id       The new ID for the book item, or an empty string if the ID
   *                 should not be updated.
   * @param ISBN     The new ISBN for the book item, or an empty string
   * @param title    The new title for the book item, or an empty string
   * @param author   The new author for the book item, or an empty string
   * @param subject  The new subject for the book item, or an empty string
   * @param price    The new price for the book item, or -1 if the price should
   *                 not be updated.
   * @return true if the book item was successfully updated, false otherwise.
   */
  boolean updateBookItem(BookItem bookItem, String id, String ISBN,
      String title, String author, String subject, double price);

  /**
   * Deletes the specified list of book items from the list of book items
   * managed by this service.
   *
   * @param bookItems The list of book items to delete.
   * @return true if any book items were successfully deleted, false otherwise.
   */
  boolean deleteBookItem(List<BookItem> bookItems);

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
  ArrayList<BookItem> searchBookItem(String id, String ISBN,
      String title, String author, String subject, double price);

  /**
   * Marks the given BookItem as borrowed and updates its borrowed and due
   * dates.
   *
   * @param bookItem the BookItem to be borrowed
   */
  void loanBookItem(BookItem bookItem);

  /**
   * Marks the given BookItem as returned and clears its borrowed and due
   * dates.
   *
   * @param bookItem the BookItem to be returned
   */
  void returnBookItem(BookItem bookItem);
}