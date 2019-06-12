import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App extends JFrame {
  private JPanel backgroundPanel;
  private JPanel buttonPanel;
  private JButton cancelButton;
  private JButton startButton;
  private JPanel contentPanel;
  private JLabel titleLabel;
  private JLabel msgLabel;
  private JPanel test;

  public App() {
    setSize(800, 550);

    setContentPane(backgroundPanel);

    titleLabel.setBorder(new EmptyBorder(20, 40, 0, 20));
    msgLabel.setBorder(new EmptyBorder(0, 50, 50, 20));

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

  private void createUIComponents() {
    test = new JPanel();
    BufferedImage myPicture = null;
    try {
      myPicture = ImageIO.read(new File("App/src/img.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    JLabel picLabel = new JLabel(new ImageIcon(myPicture));
    test.add(picLabel);
  }
}