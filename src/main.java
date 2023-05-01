import model.*;
import view.*;
import controller.*;

/**
 * The main class is responsible for launching the book management system by
 * creating instances of the LibrarianLoginModel, LibrarianLoginView, and
 * LibrarianLoginController classes.
 */
public class main {

  /**
   * The main method initializes the model, view, and controller classes and
   * creates an instance of the LibrarianLoginController to allow the librarian
   * to log in to the system.
   *
   * @param args an array of command-line arguments passed to the program
   */
  public static void main(String[] args) {
    LibrarianLoginModel model = new LibrarianLoginModel();
    LibrarianLoginView view = new LibrarianLoginView();
    LibrarianLoginController controller = new LibrarianLoginController(model,
        view);
  }
}
