package view;

import static org.junit.Assert.*;

import java.awt.event.ActionListener;
import javax.swing.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Junit tests for the ILibrarianLoginView.
 */
public class ILibrarianLoginViewTest {

  private ILibrarianLoginView view1, view2;

  /**
   * Sets up for the two view.
   */
  @Before
  public void setUp() {
    view1 = new LibrarianLoginView();
    view2 = new LibrarianLoginView();
  }

  /**
   * Tests the getUsernameTextField() method.
   */
  @Test
  public void testGetUsernameTextField() {
    JTextField usernameTextField1 = view1.getUsernameTextField();
    assertNotNull(usernameTextField1);
    assertEquals("", usernameTextField1.getText());

    JTextField usernameTextField2 = view2.getUsernameTextField();
    assertNotNull(usernameTextField2);
    assertEquals("", usernameTextField2.getText());
  }

  /**
   * Tests the setUsernameTextField() method.
   */
  @Test
  public void testSetUsernameTextField() {
    JTextField newUsernameTextField1 = new JTextField("new username");
    view1.setUsernameTextField(newUsernameTextField1);
    assertSame(newUsernameTextField1, view1.getUsernameTextField());

    JTextField newUsernameTextField2 = new JTextField("new");
    view2.setUsernameTextField(newUsernameTextField2);
    assertSame(newUsernameTextField2, view2.getUsernameTextField());
  }

  /**
   * Tests the getPasswordField() method.
   */
  @Test
  public void testGetPasswordField() {
    JPasswordField passwordField1 = view1.getPasswordField();
    assertNotNull(passwordField1);
    assertEquals("", new String(passwordField1.getPassword()));

    JPasswordField passwordField2 = view2.getPasswordField();
    assertNotNull(passwordField2);
    assertEquals("", new String(passwordField2.getPassword()));
  }

  /**
   * Tests the setPasswordField() method.
   */
  @Test
  public void testSetPasswordField() {
    JPasswordField newPasswordField1 = new JPasswordField("new password");
    view1.setPasswordField(newPasswordField1);
    assertSame(newPasswordField1, view1.getPasswordField());

    JPasswordField newPasswordField2 = new JPasswordField("new");
    view2.setPasswordField(newPasswordField2);
    assertSame(newPasswordField2, view2.getPasswordField());
  }

  /**
   * Tests the getLoginButton() method.
   */
  @Test
  public void testGetLoginButton() {
    JButton loginButton1 = view1.getLoginButton();
    assertNotNull(loginButton1);
    assertEquals("Login", loginButton1.getText());

    JButton loginButton2 = view2.getLoginButton();
    assertNotNull(loginButton2);
    assertEquals("Login", loginButton2.getText());
  }

  /**
   * Tests the setLoginButton() method.
   */
  @Test
  public void testSetLoginButton() {
    JButton newLoginButton1 = new JButton("New Login");
    view1.setLoginButton(newLoginButton1);
    assertSame(newLoginButton1, view1.getLoginButton());

    JButton newLoginButton2 = new JButton("New");
    view2.setLoginButton(newLoginButton2);
    assertSame(newLoginButton2, view2.getLoginButton());
  }

  /**
   * Tests loginListener() method.
   */
  @Test
  public void testLoginListener() {
    ActionListener[] loginListener = view1.getLoginButton().getActionListeners();
    assertEquals(0, loginListener.length);

    loginListener = view2.getLoginButton().getActionListeners();
    assertEquals(0, loginListener.length);
  }
}