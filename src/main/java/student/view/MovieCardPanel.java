package student.view;

import student.model.Movie;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * MovieCardPanel is a JPanel that displays a movie card with an image and title.
 */
public class MovieCardPanel extends JPanel {
    private final Movie movie;

    /**
     * Constructor for MovieCardPanel.
     * Sets up the layout and initializes components.
     *
     * @param movie The movie object to display.
     */
    public MovieCardPanel(Movie movie) {
        this.movie = movie;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(150, 250));
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // === Poster image
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        try {
            if (movie.getImageUrl() != null && !movie.getImageUrl().isEmpty()) {
                ImageIcon poster = new ImageIcon(new URL(movie.getImageUrl()));
                Image scaled = poster.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaled));
            } else {
                imageLabel.setText("No Image");
            }
        } catch (Exception e) {
            imageLabel.setText("Image Error");
        }

        // === Movie title
        JLabel titleLabel = new JLabel("<html><center>" + movie.getTitle() + "</center></html>");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));

        add(imageLabel, BorderLayout.CENTER);
        add(titleLabel, BorderLayout.SOUTH);

        // === On click: open MovieDisplay popup
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                showFullDetails();
            }
        });
    }

    /**
     * Sets the movie for this panel.
     *
     * @param movie The movie object to set.
     */
    private void showFullDetails() {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), movie.getTitle(), true);
        dialog.setSize(500, 600);
        dialog.setLocationRelativeTo(this);

        MovieDisplay display = new MovieDisplay();
        display.setMovie(movie);

        dialog.add(display);
        dialog.setVisible(true);
    }
}
