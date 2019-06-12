import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;

public class GenreSelection extends JFrame {

  private JPanel backgroundPanel;
  private JButton nextButton;
  private JButton cancelButton;
  private JPanel buttonPanel;
  private JPanel contentPanel;
  private JLabel titleLabel;
  private JPanel optionPanel;
  private JCheckBox actionCheckBox;
  private JCheckBox romanceCheckBox;
  private JCheckBox adventureCheckBox;
  private JCheckBox sciFiCheckBox;
  private JCheckBox animationCheckBox;
  private JCheckBox thrillerCheckBox;
  private JCheckBox comedyCheckBox;
  private JCheckBox crimeCheckBox;
  private JCheckBox idkCheckBox;
  private JCheckBox somethingCheckBox;
  private JCheckBox dramaCheckBox;
  private JCheckBox mysteryCheckBox;
  private JCheckBox somethingElseCheckBox;
  private static List<String> genreList = new ArrayList<>();
  private JCheckBox[] checkBoxList = {
    actionCheckBox,
    romanceCheckBox,
    adventureCheckBox,
    sciFiCheckBox,
    animationCheckBox,
    thrillerCheckBox,
    comedyCheckBox,
    crimeCheckBox,
    idkCheckBox,
    somethingCheckBox,
    dramaCheckBox,
    mysteryCheckBox,
    somethingElseCheckBox
  };

  public static List<String> getGenreList() {
    return genreList;
  }

  public void clearGenreList() {
    genreList.clear();
  }

  private boolean validGenre(JCheckBox box) {
    return !box.equals(idkCheckBox)
        && !box.equals(somethingCheckBox)
        && !box.equals(somethingElseCheckBox);
  }

  public GenreSelection() {

    setSize(600, 400);

    add(backgroundPanel);

    titleLabel.setBorder(new EmptyBorder(20, 20, 0, 20));

    nextButton.addActionListener(
        e -> {
          for (JCheckBox box : checkBoxList) {
            if (box.isSelected() && validGenre(box)) {
              genreList.add(box.getText());
            }
          }
          if (genreList.size() == 0) {
            titleLabel.setForeground(Color.red);
          } else {
            MovieName movieNameWindow = new MovieName();
            movieNameWindow.setLocationRelativeTo(null);
            movieNameWindow.setVisible(true);
            dispose();
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
