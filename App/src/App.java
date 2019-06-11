import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends JFrame{

  private JPanel backgroundPanel;
  private JButton startButton;
  private JButton cancelButton;
  private JLabel welcomeLabel;
  private JLabel textLabel;

  public App() {
    setSize(new Dimension(550, 300));

    add(backgroundPanel);

    welcomeLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
    textLabel.setBorder(new EmptyBorder(30, 30, 0, 20));

    startButton.addActionListener(e -> {
      GenreSelection genreWindow = new GenreSelection();
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
    exitWindow.setVisible(true);
  }
}
