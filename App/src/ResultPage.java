import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ResultPage extends JFrame {
  private JPanel backgroundPanel;
  private JButton backButton;
  private JButton closeButton;
  private JPanel displayPanel;
  private JLabel nameLabel;
  private JPanel buttonPanel;
  private JTextPane contentTextPane;
  private JLabel msgLabel;

  public ResultPage() {

    setContentPane(backgroundPanel);

    setSize(600, 700);

    nameLabel.setText(MovieName.getMovieName());

    nameLabel.setBorder(new EmptyBorder(20, 20, 0, 20));

    msgLabel.setBorder(new EmptyBorder(0, 20, 20, 20));

    ArrayList<String> list = Main.filterbyGenres(GenreSelection.getGenreList());

    for (int i = 0; i < 15; i++) {
      StyledDocument document = (StyledDocument)contentTextPane.getDocument();
      SimpleAttributeSet attributes = new SimpleAttributeSet();
      StyleConstants.setAlignment(attributes, StyleConstants.ALIGN_CENTER);
      document.setParagraphAttributes(0, document.getLength(), attributes, false);
      try {
        document.insertString(document.getLength(), list.get(i) + "\n", attributes);
      } catch (BadLocationException e) {
        e.printStackTrace();
      }
    }

    backButton.addActionListener(e -> {
      MovieName movieNameWindow = new MovieName();
      movieNameWindow.clearName();
      movieNameWindow.setLocationRelativeTo(null);
      movieNameWindow.setVisible(true);
      dispose();
    });

    closeButton.addActionListener(e -> exitCheck());

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
    nameLabel = new JLabel();
    nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

    msgLabel = new JLabel();
    msgLabel.setHorizontalAlignment(SwingConstants.CENTER);
  }
}
