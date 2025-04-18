package student.view;

import student.model.Movie;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;


//this is the JPanel that holds the Movielist on the right side of the GUI
public class UserMovieListPanel extends JPanel {
    private JButton saveButton;
    private JButton clearButton;
    private JPanel cardPanel;
    private Consumer<Movie> removeAction;

    public UserMovieListPanel(List<Movie> movies, String buttonLabel, Consumer<Movie> removeAction) {
        this.removeAction = removeAction;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY),
            "My Movie List",
            TitledBorder.CENTER,
            TitledBorder.TOP
        ));

        // === Movie cards panel
        cardPanel = new JPanel(new GridLayout(0, 3, 20, 20)); ;
        cardPanel.setBackground(Color.WHITE);

        for (Movie movie : movies) {
            MovieCardPanel card = new MovieCardPanel(movie, buttonLabel);
            card.getActionButton().addActionListener(e -> removeAction.accept(movie));
            cardPanel.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        add(scrollPane, BorderLayout.CENTER);

        // === Buttons panel
        saveButton = new JButton("Save List");
        clearButton = new JButton("Clear List");

        JPanel bottomButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomButtons.add(clearButton);
        bottomButtons.add(saveButton);
        add(bottomButtons, BorderLayout.SOUTH);
    }

    public void updateMovieList(List<Movie> movies) {
        cardPanel.removeAll();

        for (Movie movie : movies) {
            MovieCardPanel card = new MovieCardPanel(movie, "Remove");
            cardPanel.add(card);
        }

        cardPanel.revalidate();
        cardPanel.repaint();
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}
