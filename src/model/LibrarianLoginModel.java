package model;

/**
 * The Librarian class represents a librarian user in the Library Management
 * System. It contains information about the librarian's username and password
 * for login authentication.
 */
public class LibrarianLoginModel implements ILibrarianLoginModel {

  private String username;
  private String password;

  /**
   * Constructs a new LibrarianLoginModel object with empty username and
   * password.
   */
  public LibrarianLoginModel() {

  }

  /**
   * Constructs a new instance of the Librarian class with the specified
   * username and password.
   *
   * @param username the username of the librarian
   * @param password the password of the librarian
   */
  public LibrarianLoginModel(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   * Returns the username of the librarian.
   *
   * @return the username of the librarian
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the username of the librarian.
   *
   * @param username the new username of the librarian
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Returns the password of the librarian.
   *
   * @return the password of the librarian
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password of the librarian.
   *
   * @param password the new password of the librarian
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Returns the login status of the librarian. Checks if the username and
   * password match the predefined values for login authentication.
   *
   * @return true if the username and password match the predefined values,
   * false otherwise
   */
  public boolean getLoginStatus() {
    if (this.username.equals("lms") && this.password.equals("lms")) {
      return true;
    }
    return false;
  }

  /**
   * Returns a string representation of this LibrarianLogInModel
   *
   * @return a string representation of this LibrarianLogInModel
   */
  @Override
  public String toString() {
    return "LibrarianLoginModel{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
