import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends JFrame {
  private JPanel backgroundPanel;
  private JPanel buttonPanel;
  private JButton cancelButton;
  private JButton startButton;
  private JPanel contentPanel;
  private JLabel titleLabel;
  private JLabel msgLabel;

  public App() {
    setSize(new Dimension(600, 350));

    setContentPane(backgroundPanel);

    titleLabel.setBorder(new EmptyBorder(20, 20, 0, 20));
    msgLabel.setBorder(new EmptyBorder(0, 30, 0, 20));

    startButton.addActionListener(e -> {
      GenreSelection genreWindow = new GenreSelection();
      genreWindow.setLocationRelativeTo(null);
      genreWindow.setVisible(true);
      dispose();
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