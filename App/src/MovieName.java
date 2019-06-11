import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MovieName extends JFrame {
  private JTextField nameTextField;
  private JPanel backgroundPanel;
  private JLabel titleLabel;
  private JButton nextButton;
  private JButton cancelButton;

  public MovieName() {
    setContentPane(backgroundPanel);

    nextButton.addActionListener(e -> {

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
    exitWindow.setVisible(true);
  }
  }
