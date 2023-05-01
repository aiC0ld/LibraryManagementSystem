package view;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

/**
 * The LoginView class represents the graphical user interface (GUI) of the
 * login window for the Library Management System. It extends the JFrame class
 * and contains labels, text fields, and buttons for username, password, and
 * login.
 */
public class LibrarianLoginView extends JFrame implements ILibrarianLoginView{

  private JLabel usernameLabel, passwordLabel;
  private JTextField usernameTextField;
  private JPasswordField passwordField;
  private JButton loginButton;

  /**
   * Constructs the LoginView object and sets the default properties of the
   * login window. It sets the title, size, layout, and position of the
   * components of the login window. It creates and initializes the username,
   * password, and login button components of the login window.
   */
  public LibrarianLoginView() {
    setTitle("Library Management System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(550, 260);
    setLayout(new BorderLayout());

    usernameLabel = new JLabel("Enter username:");
    usernameTextField = new JTextField();
    passwordLabel = new JLabel("Enter password:");
    passwordField = new JPasswordField();
    loginButton = new JButton("Login");

    // set the position
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(20, 5, 20, 5);
    inputPanel.add(usernameLabel, gbc);
    gbc.gridy++;
    inputPanel.add(passwordLabel, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 1;
    inputPanel.add(usernameTextField, gbc);
    gbc.gridy++;
    inputPanel.add(passwordField, gbc);
    gbc.gridy++;

    JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
    buttonPanel.add(loginButton);
    inputPanel.add(buttonPanel, gbc);
    add(inputPanel, BorderLayout.NORTH);

    // set the font style and size
    for (Component component : inputPanel.getComponents()) {
      if (component instanceof JLabel) {
        JLabel label = (JLabel) component;
        label.setFont(new Font("", Font.PLAIN, 16));
      }
    }
    for (Component component : buttonPanel.getComponents()) {
      if (component instanceof JButton) {
        JButton button = (JButton) component;
        button.setFont(new Font("", Font.PLAIN, 16));
      }
    }

    setVisible(true);
  }

  /**
   * Returns the username text field.
   *
   * @return the username text field
   */
  public JTextField getUsernameTextField() {
    return usernameTextField;
  }

  /**
   * Sets the username text field.
   *
   * @param usernameTextField the username text field
   */
  public void setUsernameTextField(JTextField usernameTextField) {
    this.usernameTextField = usernameTextField;
  }

  /**
   * Returns the password field.
   *
   * @return the password field
   */
  public JPasswordField getPasswordField() {
    return passwordField;
  }

  /**
   * Sets the password field.
   *
   * @param passwordField the password field
   */
  public void setPasswordField(JPasswordField passwordField) {
    this.passwordField = passwordField;
  }

  /**
   * Returns the login button.
   *
   * @return the login button
   */
  public JButton getLoginButton() {
    return loginButton;
  }

  /**
   * Sets the login button.
   *
   * @param loginButton the login button
   */
  public void setLoginButton(JButton loginButton) {
    this.loginButton = loginButton;
  }

  /**
   * Adds a login button listener.
   *
   * @param listener the ActionListener for the login button
   */
  public void loginListener(ActionListener listener) {
    loginButton.addActionListener(listener);
  }
}
