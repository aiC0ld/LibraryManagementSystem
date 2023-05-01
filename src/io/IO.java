package io;

import model.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides input/output functionality for the library management
 * system.
 */
public class IO {

  /**
   * Saves a list of BookItems to the "BookItem" text file.
   *
   * @param list the list of BookItems to be saved
   * @return true if the save operation is successful, false otherwise
   */
  public boolean save(List<BookItem> list) {
    PrintStream printStream = null;
    try {
      printStream = new PrintStream(new FileOutputStream("src/io/BookItem.txt"));
      for (BookItem b : list) {
        printStream.println(b.getId() + "," + b.getISBN() + "," + b.getTitle() + "," +
            b.getAuthor() + "," + b.getSubject() + "," + b.getPrice() + ","
            + b.isAvailable() + "," + b.getLoanedDate() + "," + b.getDueDate());
      }
      return true;
    } 
    catch (FileNotFoundException e) {
      System.out.println("File not found");
      return false;
    } 
    finally {
      printStream.close();
    }
  }

  /**
   * Loads a list of BookItems from the "BookItem" text file.
   *
   * @return the list of BookItems loaded from the file
   */
  public List<BookItem> load() {
    List<BookItem> bookItems = new ArrayList<>();
    File file = new File("src/io/BookItem.txt");
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] arr = line.split(",");
        double price = Float.parseFloat(arr[5]);
        boolean status = Boolean.parseBoolean(arr[6]);
        BookItem b;
        if (arr.length == 9) {
          b = new BookItem(arr[0], arr[1], arr[2], arr[3], arr[4], price,
              status, arr[7], arr[8]);
        } else {
          b = new BookItem(arr[0], arr[1], arr[2], arr[3], arr[4], price);
        }
        bookItems.add(b);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (IOException e) {
      System.out.println("Fail to read");
    }
    return bookItems;
  }
}