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
  private JLabel test;

  public App() {
    setSize(500, 500);

    setContentPane(backgroundPanel);

    titleLabel.setBorder(new EmptyBorder(20, 40, 0, 0));
//    msgLabel.setBorder(new EmptyBorder(0, 30, 20, 30));

    startButton.addActionListener(
        e -> {
          GenreSelection genreWindow = new GenreSelection();
          genreWindow.setLocationRelativeTo(null);
          genreWindow.setVisible(true);
          dispose();
        });
    cancelButton.addActionListener(e -> exitCheck());

    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(
        new WindowAdapter() {
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
    titleLabel = new JLabel();
//    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

    msgLabel = new JLabel();
    msgLabel.setHorizontalAlignment(SwingConstants.CENTER);

    test = new JLabel("");
    test.setSize(500, 185);
    test.setHorizontalAlignment(SwingConstants.CENTER);
    BufferedImage img = null;
    try {
      img = ImageIO.read(new File("App/src/logo.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    assert img != null;
    Image dimg = img.getScaledInstance(test.getWidth(), test.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon imageIcon = new ImageIcon(dimg);
    test.setIcon(imageIcon);
  }
}
