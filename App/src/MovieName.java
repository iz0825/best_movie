import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class MovieName extends JFrame {
  private JPanel backgroundPanel;
  private JPanel buttonPanel;
  private JButton nextButton;
  private JButton cancelButton;
  private JPanel contentPanel;
  private JLabel titleLabel;
  private JTextField nameField;
  private JButton backButton;
  private static String name;

  public static String getMovieName() {
    return name;
  }

  public void clearName() {
    name = null;
  }

  public MovieName() {
    add(backgroundPanel);

    setSize(600, 350);

    titleLabel.setBorder(new EmptyBorder(20, 40, 0, 0));

    backButton.addActionListener(e -> {
      GenreSelection genreSelectionWindow = new GenreSelection();
      genreSelectionWindow.clearGenreList();
      genreSelectionWindow.setLocationRelativeTo(null);
      genreSelectionWindow.setVisible(true);
      dispose();
    });

    nextButton.addActionListener(e -> {
      if (nameField.getText().equals("") || nameField.getText().equals("Please enter something")) {
        nameField.setText("Please enter something");
      } else {
        name = nameField.getText();
        ResultPage resultPageWindow = null;
        try {
          resultPageWindow = new ResultPage();
        } catch (BadLocationException e1) {
          e1.printStackTrace();
        }
        resultPageWindow.setLocationRelativeTo(null);
        resultPageWindow.setVisible(true);
        dispose();
      }
    });

    cancelButton.addActionListener(e -> exitCheck());

    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        exitCheck();
      }
    });
  }

  private void exitCheck() {
    ExitCheck exitWindow = new ExitCheck();
    exitWindow.setLocationRelativeTo(null);
    exitWindow.setVisible(true);
  }

}
