import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GenreSelection extends JFrame {

  private JPanel backgroundPanel;
  private JButton nextButton;
  private JButton cancelButton;
  private JPanel buttonPanel;
  private JPanel contentPanel;
  private JLabel titleLabel;
  private JComboBox comboBox1;
  private String type;

  public GenreSelection() {

    setSize(600, 350);

    add(backgroundPanel);

    titleLabel.setBorder(new EmptyBorder(20, 20, 0, 20));
    comboBox1.setBorder(new EmptyBorder(0, 20, 20, 20));

    nextButton.addActionListener(
        e -> {
          switch (String.valueOf(comboBox1.getSelectedItem())) {
            case "- Select from below -":
              titleLabel.setForeground(Color.red);
              break;
            default:
              type = String.valueOf(comboBox1.getSelectedItem());
              MovieName movieNameWindow = new MovieName();
              movieNameWindow.setLocationRelativeTo(null);
              movieNameWindow.setVisible(true);
              dispose();
              break;
          }
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
}
