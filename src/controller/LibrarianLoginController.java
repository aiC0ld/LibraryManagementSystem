package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.*;
import view.*;

/**
 * The LibrarianLoginController class is responsible for controlling the login
 * functionality of the application. It listens to the events from the LoginView
 * and updates the Librarian model based on the user inputs. It also launches
 * the BooksView if the login is successful, and displays an error message
 * otherwise.
 */
public class LibrarianLoginController {

  private LibrarianLoginView view;
  private LibrarianLoginModel model;

  /**
   * Constructs a LoginController object with the given model and view.
   *
   * @param model the Librarian model used by the LoginController
   * @param view  the LoginView used by the LoginController
   */
  public LibrarianLoginController(LibrarianLoginModel model,
      LibrarianLoginView view) {
    this.model = model;
    this.view = view;
    view.loginListener(new LoginListener());
  }

  /**
   * The ActionListener class for the login button in the LoginView. It
   * retrieves the user inputs from the view and updates the model accordingly.
   * If the login is successful, it launches the BooksView and the
   * BookController. If the login fails, it displays an error message in the
   * view.
   */
  class LoginListener implements ActionListener {

    /**
     * The actionPerformed method handles the login button event in the view.
     *
     * @param e the ActionEvent object
     */
    public void actionPerformed(ActionEvent e) {
      String username = view.getUsernameTextField().getText();
      String password = view.getPasswordField().getText();
      model.setUsername(username);
      model.setPassword(password);
      boolean check = model.getLoginStatus();
      // if the username and password are both right, open the management view
      if (check) {
        view.dispose();
        ServicesModel model = new ServicesModel();
        ServicesView view = new ServicesView();
        ServicesController controller = new ServicesController(model, view);
      }
      // if username or password is wrong, pop an error message and clear form
      else {
        JOptionPane.showMessageDialog(view, "Sorry, Username or Password Error",
            "Login Error!", JOptionPane.ERROR_MESSAGE);
        view.getUsernameTextField().setText("");
        view.getPasswordField().setText("");
      }
    }
  }
}