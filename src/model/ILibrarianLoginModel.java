package model;

/**
 * The ILibrarianLoginModel interface represents a librarian user in the Library
 * Management System.
 */
public interface ILibrarianLoginModel {

  /**
   * Returns the username of the librarian.
   *
   * @return the username of the librarian
   */
  String getUsername();

  /**
   * Sets the username of the librarian.
   *
   * @param username the new username of the librarian
   */
  void setUsername(String username);

  /**
   * Returns the password of the librarian.
   *
   * @return the password of the librarian
   */
  String getPassword();

  /**
   * Sets the password of the librarian.
   *
   * @param password the new password of the librarian
   */
  void setPassword(String password);

  /**
   * Returns the login status of the librarian. Checks if the username and
   * password match the predefined values for login authentication.
   *
   * @return true if the username and password match the predefined values,
   * false otherwise
   */
  boolean getLoginStatus();
}
