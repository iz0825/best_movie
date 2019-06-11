import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MovieName extends JFrame {
  private JPanel backgroundPanel;
  private JPanel buttonPanel;
  private JButton nextButton;
  private JButton cancelButton;
  private JPanel contentPanel;
  private JLabel titleLabel;
  private JTextField nameField;
  private JButton backButton;
  private String name;

  public MovieName() {
    add(backgroundPanel);

    setSize(600, 350);

    titleLabel.setBorder(new EmptyBorder(20, 20, 0,0));

    backButton.addActionListener(e -> {
      GenreSelection genreSelectionWindow = new GenreSelection();
      genreSelectionWindow.setLocationRelativeTo(null);
      genreSelectionWindow.setVisible(true);
      dispose();
    });

    nextButton.addActionListener(e -> {
      if (nameField.getText().equals("")) {
        nameField.setText("Please enter something");
      } else {
        name = nameField.getText();
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
