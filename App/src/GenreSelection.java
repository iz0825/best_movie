import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GenreSelection extends JFrame {
  private JPanel backgroundPanel;
  private JLabel titleLabel;
  private JComboBox comboBox1;
  private JButton cancelButton;
  private JButton nextButton;

  public GenreSelection() {

    setSize(550, 300);

    setContentPane(backgroundPanel);

    titleLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
    comboBox1.setBorder(new EmptyBorder(20, 20, 20, 20));

    nextButton.addActionListener(
        e -> {
          switch (String.valueOf(comboBox1.getSelectedItem())) {
            case "- Select form below -":
              titleLabel.setForeground(Color.red);
              break;
            case "Action":
              MovieName movieNameWindow = new MovieName();
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
    exitWindow.setVisible(true);
  }
}
