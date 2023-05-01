package controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import model.LibrarianLoginModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import view.LibrarianLoginView;

/**
 * Junit tests for LibrarianLoginController.
 */
public class LibrarianLoginControllerTest {
  @Mock
  private LibrarianLoginModel model;
  @Mock
  private LibrarianLoginView view;
  @Mock
  private JOptionPane jOptionPane;

  private LibrarianLoginController controller;

  /**
   * Sets up part.
   */
  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    view = org.mockito.Mockito.mock(LibrarianLoginView.class);
    jOptionPane = org.mockito.Mockito.mock(JOptionPane.class);
    UIManager.put("OptionPane", jOptionPane);
    controller = new LibrarianLoginController(model, view);
  }

  /**
   * Tests the LibrarianLoginController successfully login.
   */
  @Test
  public void testLoginListenerActionPerformedSuccessfulLogin() {
    JTextField userNameTextField = new JTextField("testUser");
    JPasswordField passwordTextField = new JPasswordField("testPassword");
    when(view.getUsernameTextField()).thenReturn(userNameTextField);
    when(view.getPasswordField()).thenReturn(passwordTextField);
    when(model.getLoginStatus()).thenReturn(true);

    ActionEvent e = new ActionEvent(view, ActionEvent.ACTION_PERFORMED, "login");
    controller.new LoginListener().actionPerformed(e);

    verify(model).setUsername("testUser");
    verify(model).setPassword("testPassword");
    verify(view).dispose();
  }
}