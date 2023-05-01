package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * The ILibrarianLoginView interface represents the graphical user interface
 * (GUI) of the * login window for the Library Management System.
 */
public interface ILibrarianLoginView {

  /**
   * Returns the username text field.
   *
   * @return the username text field
   */
  JTextField getUsernameTextField();

  /**
   * Sets the username text field.
   *
   * @param usernameTextField the username text field
   */
  void setUsernameTextField(JTextField usernameTextField);

  /**
   * Returns the password field.
   *
   * @return the password field
   */
  JPasswordField getPasswordField();

  /**
   * Sets the password field.
   *
   * @param passwordField the password field
   */
  void setPasswordField(JPasswordField passwordField);

  /**
   * Returns the login button.
   *
   * @return the login button
   */
  JButton getLoginButton();

  /**
   * Sets the login button.
   *
   * @param loginButton the login button
   */
  void setLoginButton(JButton loginButton);

  /**
   * Adds a login button listener.
   *
   * @param listener the ActionListener for the login button
   */
  void loginListener(ActionListener listener);
}
