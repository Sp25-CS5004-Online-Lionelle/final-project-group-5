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
    private JButton actionButton;

    /**
     * Constructor for MovieCardPanel.
     * Sets up the layout and initializes components.
     *
     * @param movie The movie object to display.
     */
    public MovieCardPanel(Movie movie, String buttonLabel) {
        this.movie = movie; // Movie object
        setLayout(new BorderLayout()); // Set layout manager
        setPreferredSize(new Dimension(180, 280)); // Set preferred size
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Set border
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Set cursor to hand

        // Poster image
        JLabel imageLabel = new JLabel(); // Set up image label
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the image

        try {
            if (movie.getImageUrl() != null && !movie.getImageUrl().isEmpty()) { // Check if image URL is not null or empty
                ImageIcon poster = new ImageIcon(new URL(movie.getImageUrl())); // Create ImageIcon from URL
                Image scaled = poster.getImage().getScaledInstance(160, 220, Image.SCALE_SMOOTH); // Scale the image
                imageLabel.setIcon(new ImageIcon(scaled)); // Set the scaled image
            } else {
                imageLabel.setText("No Image");
            }
        } catch (Exception e) {
            imageLabel.setText("Image Error");
        }

        add(imageLabel, BorderLayout.CENTER); // Add image label to center of card

        // Bottom panel with vertical layout
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setOpaque(false);

        //  Movie title
        JLabel titleLabel = new JLabel("<html><center>" + movie.getTitle() + "</center></html>");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text inside the JLabel
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));


        // add or remove button
        actionButton = new JButton(buttonLabel); //default label
        actionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        actionButton.setForeground(Color.BLACK);
        actionButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
        


        // Add title and button to bottom moviecardpanel
        bottomPanel.add(titleLabel);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 5))); 
        bottomPanel.add(actionButton);

        // Add that bottom panel to the bottom of the card
        add(bottomPanel, BorderLayout.SOUTH);

        // On click: open MovieDisplay popup
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                showFullDetails();
            }
        });
    }

    /**
     * Sets the action button label.
     *
     * @param label The label to set for the action button.
     */
    public JButton getActionButton() {
        return actionButton;
    }

   
    /**
     * Sets the movie for this panel and displays more verbose details.
     *
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
