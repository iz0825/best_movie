import javax.swing.*;
import java.awt.*;

public class ExitCheck extends JFrame {
  private JPanel backgroundPanel;
  private JButton yesButton;
  private JButton noButton;

  public ExitCheck() {
    setSize(350, 200);

    setContentPane(backgroundPanel);

    yesButton.addActionListener(e -> System.exit(0));
    noButton.addActionListener(e -> dispose());
  }

}
