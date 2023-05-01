package view;

import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import model.BookItem;

/**
 * This class represents the user interface of the library management system for
 * managing books. It extends the JFrame class and contains UI components such
 * as text fields, buttons, and a table. The UI components are used for adding,
 * updating, deleting, searching, borrowing, and returning books.
 */
public class ServicesView extends JFrame implements IServicesView {

  private JLabel idLabel, ISBNLabel, titleLabel, authorLabel, subjectLabel,
      priceLabel;
  private JTextField idTextField, ISBNTextField, titleTextField, authorTextField,
      subjectTextField, priceTextField;

  private JButton resetButton, addButton, updateButton, deleteButton,
      searchButton, loanButton, returnButton;

  private JTable bookTable;

  /**
   * Constructs a new instance of the BooksView class. Initializes the UI
   * components, creates the table model, and sets the layout of the JFrame.
   */

  public ServicesView() {
    setTitle("Library Management System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(900, 700);
    setLayout(new BorderLayout());

    // Initialize UI components
    idLabel = new JLabel("ID:");
    idTextField = new JTextField();
    ISBNLabel = new JLabel("ISBN:");
    ISBNTextField = new JTextField();
    titleLabel = new JLabel("Title:");
    titleTextField = new JTextField();
    authorLabel = new JLabel("Author:");
    authorTextField = new JTextField();
    subjectLabel = new JLabel("Subject:");
    subjectTextField = new JTextField();
    priceLabel = new JLabel("Price:");
    priceTextField = new JTextField();
    resetButton = new JButton("Reset");
    addButton = new JButton("Add");
    updateButton = new JButton("Update");
    deleteButton = new JButton("Delete");
    searchButton = new JButton("Search");
    loanButton = new JButton("Loan");
    returnButton = new JButton("Return");

    // sets the table in the UI
    DefaultTableModel table = new DefaultTableModel(
        new Object[][]{},
        new String[]{"ID", "ISBN", "Title", "Author", "Subject", "Price($)",
            "AvailableStatus", "LoanedDate", "DueDate", "CheckBox"}
    );
    bookTable = new JTable(table);
    TableColumnModel tableColumnModel = bookTable.getColumnModel();

    tableColumnModel.getColumn(9)
        .setCellRenderer(new DefaultTableCellRenderer() {
          @Override
          public Component getTableCellRendererComponent(JTable table,
              Object value, boolean isSelected, boolean hasFocus, int row,
              int column) {
            JCheckBox checkBox = new JCheckBox();
            if (value instanceof Boolean) {
              checkBox.setSelected(((Boolean) value).booleanValue());
            } else {
              checkBox.setSelected(false);
            }
            return checkBox;
          }
        });
    tableColumnModel.getColumn(9)
        .setCellEditor(new DefaultCellEditor(new JCheckBox()));
    bookTable.setFont(new Font("", Font.PLAIN, 13));
    JTableHeader header = bookTable.getTableHeader();
    header.setFont(new Font("", Font.PLAIN, 13));

    // Add UI components to panels
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(10, 10, 10, 10);
    inputPanel.add(idLabel, gbc);
    gbc.gridy++;
    inputPanel.add(ISBNLabel, gbc);
    gbc.gridy++;
    inputPanel.add(titleLabel, gbc);
    gbc.gridy++;
    inputPanel.add(authorLabel, gbc);
    gbc.gridy++;
    inputPanel.add(subjectLabel, gbc);
    gbc.gridy++;
    inputPanel.add(priceLabel, gbc);
    gbc.gridy++;

    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 1;
    inputPanel.add(idTextField, gbc);
    gbc.gridy++;
    inputPanel.add(ISBNTextField, gbc);
    gbc.gridy++;
    inputPanel.add(titleTextField, gbc);
    gbc.gridy++;
    inputPanel.add(authorTextField, gbc);
    gbc.gridy++;
    inputPanel.add(subjectTextField, gbc);
    gbc.gridy++;
    inputPanel.add(priceTextField, gbc);
    gbc.gridy++;

    JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
    buttonPanel.add(resetButton);
    buttonPanel.add(addButton);
    buttonPanel.add(updateButton);
    buttonPanel.add(deleteButton);
    inputPanel.add(buttonPanel, gbc);

    JPanel actionPanel = new JPanel();
    actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    actionPanel.add(searchButton);
    actionPanel.add(loanButton);
    actionPanel.add(returnButton);

    JPanel tablePanel = new JPanel(new BorderLayout());
    tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    tablePanel.add(new JScrollPane(bookTable), BorderLayout.CENTER);

    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(actionPanel, BorderLayout.SOUTH);
    add(tablePanel, BorderLayout.CENTER);

    // recursively iterate through all components in the panel
    for (Component component : inputPanel.getComponents()) {
      if (component instanceof JLabel) {
        JLabel label = (JLabel) component;
        label.setFont(new Font("", Font.PLAIN, 15));
      }
    }
    for (Component component : buttonPanel.getComponents()) {
      if (component instanceof JButton) {
        JButton button = (JButton) component;
        button.setFont(new Font("", Font.PLAIN, 15));
      }
    }
    for (Component component : actionPanel.getComponents()) {
      if (component instanceof JButton) {
        JButton button = (JButton) component;
        button.setFont(new Font("", Font.PLAIN, 15));
      }
    }
    setVisible(true);
  }

  /**
   * Displays an error message dialog box with the given error message.
   *
   * @param errorMessage the error message to display
   */
  public void displayErrorMessage(String errorMessage) {
    JOptionPane.showMessageDialog(this, errorMessage, "Error",
        JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Displays a success message dialog box with the given success message.
   *
   * @param successMessage the success message to display
   */
  public void displaySuccessMessage(String successMessage) {
    JOptionPane.showMessageDialog(this, successMessage, "Success",
        JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Clears the text fields in the GUI.
   */
  public void clearForm() {
    idTextField.setText("");
    ISBNTextField.setText("");
    titleTextField.setText("");
    authorTextField.setText("");
    subjectTextField.setText("");
    priceTextField.setText("");
  }

  /**
   * Returns the JTable used to display the books.
   *
   * @return the JTable used to display the books
   */
  public JTable getTable() {
    return bookTable;
  }

  /**
   * Returns the ID entered in the ID text field.
   *
   * @return the ID entered in the ID text field
   */
  public String getBookItemID() {
    return idTextField.getText();
  }

  /**
   * Returns the ISBN entered in the ISBN text field.
   *
   * @return the ISBN entered in the ISBN text field
   */
  public String getBookItemISBN() {
    return ISBNTextField.getText();
  }

  /**
   * Returns the title entered in the title text field.
   *
   * @return the title entered in the title text field
   */
  public String getBookItemTitle() {
    return titleTextField.getText();
  }

  /**
   * Returns the author entered in the author text field.
   *
   * @return the author entered in the author text field
   */
  public String getBookItemAuthor() {
    return authorTextField.getText();
  }

  /**
   * Returns the subject entered in the subject text field.
   *
   * @return the subject entered in the subject text field
   */
  public String getBookItemSubject() {
    return subjectTextField.getText();
  }

  /**
   * Returns the price entered in the price text field.
   *
   * @return the price entered in the price text field, or -1 if the field is
   * empty
   */
  public double getBookItemPrice() {
    String price = priceTextField.getText();
    double res = -1;
    if (!price.isEmpty()) {
      try {
        res = Double.parseDouble(price);
      }
      catch (NumberFormatException e) {
        displayErrorMessage("Cannot parse price");
      }
    }
    return res;
  }

  /**
   * Returns a list of the selected book item IDs in the table.
   *
   * @return a list of the selected book item IDs in the table
   */
  public List<String> getSelectedBookItemIDs() {
    List<String> selectedBookItemIDs = new ArrayList<>();
    for (int i = 0; i < getTable().getRowCount(); i++) {
      if (getTable().getValueAt(i, 9) == null) {
        continue;
      }
      boolean isSelected = (boolean) getTable().getValueAt(i, 9);
      if (isSelected) {
        String id = (String) getTable().getValueAt(i, 0);
        selectedBookItemIDs.add(id);
      }
    }
    return selectedBookItemIDs;
  }

  /**
   * Displays the given list of books in the table.
   *
   * @param books the list of books to display
   */
  public void displayBooks(ArrayList<BookItem> books) {
    DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
    model.setRowCount(0);
    DecimalFormat decimalFormat = new DecimalFormat("#.#");
    for (BookItem book : books) {
      Object[] rowData = {book.getId(), book.getISBN(),
          book.getTitle(), book.getAuthor(),
          book.getSubject(),
          decimalFormat.format(book.getPrice()),
          book.isAvailable(), book.getLoanedDate(), book.getDueDate()};
      System.out.println(Arrays.toString(rowData));
      model.addRow(rowData);
    }
  }

  /**
   * Adds an action listener to the Add button.
   *
   * @param listener the action listener to add
   */
  public void addBookListener(ActionListener listener) {
    addButton.addActionListener(listener);
  }

  /**
   * Gets the addButton of this UI
   *
   * @return the addButton of this UI
   */
  public JButton getAddButton() {
    return addButton;
  }

  /**
   * Adds an action listener to the Update button.
   *
   * @param listener the action listener to add
   */
  public void updateBookListener(ActionListener listener) {
    updateButton.addActionListener(listener);
  }

  /**
   * Gets the updateButton of this UI
   *
   * @return the updateButton of this UI
   */
  public JButton getUpdateButton() {
    return updateButton;
  }

  /**
   * Adds an action listener to the Delete button.
   *
   * @param listener the action listener to add
   */
  public void deleteBookListener(ActionListener listener) {
    deleteButton.addActionListener(listener);
  }

  /**
   * Gets the deleteButton of this UI
   *
   * @return the deleteButton of this UI
   */
  public JButton getDeleteButton() {
    return deleteButton;
  }

  /**
   * Adds an action listener to the Search button.
   *
   * @param listener the action listener to add
   */
  public void searchBookListener(ActionListener listener) {
    searchButton.addActionListener(listener);
  }

  /**
   * Gets the searchButton of this UI
   *
   * @return the searchButton of this UI
   */
  public JButton getSearchButton() {
    return searchButton;
  }

  /**
   * Adds an action listener to the Reset button.
   *
   * @param listener the action listener to add
   */
  public void resetBookListener(ActionListener listener) {
    resetButton.addActionListener(listener);
  }

  /**
   * Gets the resetButton of this UI
   *
   * @return the resetButton of this UI
   */
  public JButton getResetButton() {
    return resetButton;
  }

  /**
   * Adds an action listener to the Loan button.
   *
   * @param listener the action listener to add
   */
  public void loanBookListener(ActionListener listener) {
    loanButton.addActionListener(listener);
  }

  /**
   * Gets the loanButton of this UI
   *
   * @return the loanButton of this UI
   */
  public JButton getLoanButton() {
    return loanButton;
  }

  /**
   * Adds an action listener to the Return button.
   *
   * @param listener the action listener to add
   */
  public void returnBookListener(ActionListener listener) {
    returnButton.addActionListener(listener);
  }

  /**
   * Gets the returnButton of this UI
   *
   * @return the returnButton of this UI
   */
  public JButton getReturnButton() {
    return returnButton;
  }
}