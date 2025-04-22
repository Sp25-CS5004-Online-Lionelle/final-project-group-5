package student.view;

import student.model.Movie;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.List;

/**
 * MovieDisplay is a JPanel that displays movie details including title, year, genre,
 * rating, cast, description, and an image.
 */
public class MovieDisplay extends JPanel {
    private final JLabel imageLabel;
    private final JLabel titleLabel;
    private final JLabel yearLabel;
    private final JLabel genreLabel;
    private final JLabel ratingLabel;
    private final JLabel castLabel;
    private final JTextArea descriptionArea;

    /**
     * Constructor for MovieDisplay.
     * Sets up the layout and initializes components.
     */
    public MovieDisplay() {
        setLayout(new BorderLayout());

        // === Content Panel with vertical layout ===
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20)); //  padding
        contentPanel.setOpaque(false);

        // === Image Panel (currently I have it centered) ===
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        imagePanel.setOpaque(false);
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(150, 220));
        imagePanel.add(imageLabel);
        contentPanel.add(imagePanel);

        // Spacer and separator
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        contentPanel.add(separator);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        // === Info Panel (text left-aligned) ===
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.setOpaque(false);

        titleLabel = new JLabel("Title: ");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(titleLabel);

        yearLabel = new JLabel("Year: ");
        yearLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(yearLabel);

        genreLabel = new JLabel("Genre: ");
        genreLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(genreLabel);

        ratingLabel = new JLabel("Rating: ");
        ratingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(ratingLabel);

        castLabel = new JLabel("Cast: ");
        castLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(castLabel);

        // Add separator before the description section -- not sure why this is shorter, I can't seem to get it to match the width of the separator above
        JSeparator descSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        descSeparator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        descSeparator.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        infoPanel.add(descSeparator);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 15)));


        infoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel descLabel = new JLabel("Description:");
        descLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(descLabel);

        descriptionArea = new JTextArea(5, 40);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setOpaque(false);
        descriptionArea.setBorder(null);
        descriptionArea.setFocusable(false);
        descriptionArea.setFont(UIManager.getFont("Label.font"));
        descriptionArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.add(descriptionArea);

        contentPanel.add(infoPanel);
        add(contentPanel, BorderLayout.NORTH); // Align everything to top
    }

    /**
     * Sets the movie details in the display.
     *
     * @param movie the Movie object containing details to display
     */
    public void setMovie(Movie movie) {
        if (movie == null) return;

        titleLabel.setText("Title: " + movie.getTitle());
        yearLabel.setText("Year: " + movie.getYear());
        genreLabel.setText("Genre: " + movie.getGenre());
        ratingLabel.setText("Rating: " + movie.getAverageRating());

        List<String> cast = movie.getCast();
        String castLine = (cast != null && !cast.isEmpty()) ? String.join(", ", cast) : "N/A";
        castLabel.setText("Cast: " + castLine);
        
        descriptionArea.setText(movie.getDescription());

        // Load the image
        try {
            String url = movie.getImageUrl();
            if (url != null && !url.isEmpty()) {
                ImageIcon poster = new ImageIcon(new URL(url));
                Image scaled = poster.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(scaled));
            } else {
                imageLabel.setIcon(null);
            }
        } catch (Exception e) {
            imageLabel.setIcon(null);
            System.err.println("Image load failed: " + e.getMessage());
        }
    }
}
