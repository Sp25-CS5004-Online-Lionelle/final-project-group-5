package student.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * A JPanel that contains all buttons, dropdowns, and input fields
 * used for user interaction in the movie application.
 */
public class ButtonCommands extends JPanel {
    

    // Input & dropdowns
    private final JTextField searchField;
    private final JComboBox<String> filterDropdown;
    private final JComboBox<String> operatorDropdown;
    private final JComboBox<String> sortDropdown;
    private final JCheckBox sortAscCheckbox;
    private final JCheckBox sortDecCheckbox;

    // command Buttons
    private final JButton filterBtn;
    private final JButton sortBtn;
    private final JButton addBtn;
    private final JButton removeBtn;
    private final JButton saveBtn;
    private final JButton helpBtn;

     /**
     * Constructs a new ButtonCommands panel with all interactive components.
     */
    public ButtonCommands() {
        setLayout(new GridLayout(3, 1)); // Two rows: top (filters), bottom (actions)

    // initialize components 
    searchField = new JTextField(15);
    filterDropdown = new JComboBox<>(new String[]{"Title","IMDB Rating", "Genre", "Year", "Cast", "Plot"});
    operatorDropdown = new JComboBox<>(new String[]{"==", "!=", ">=", "<=", ">", "<", "~="});
    sortDropdown = new JComboBox<>(new String []{"Title","IMDB Rating", "Genre", "Year"});
    sortAscCheckbox = new JCheckBox("Ascending");
    sortDecCheckbox = new JCheckBox("Descending");

    filterBtn = new JButton("Filter");
    sortBtn = new JButton("Sort");
    addBtn = new JButton("Add to List");
    removeBtn = new JButton("Remove from List");
    saveBtn = new JButton("Save to File");
    helpBtn = new JButton( "Help");

    // layout all the components
    JPanel filterRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
    filterRow.add(new JLabel("Filter:"));
    filterRow.add(searchField);
    filterRow.add(filterDropdown);
    filterRow.add(operatorDropdown);
    filterRow.add(filterBtn);

    JPanel sortRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
    sortRow.add(new JLabel("Sort:"));
    sortRow.add(sortDropdown);
    sortRow.add(sortAscCheckbox);
    sortRow.add(sortDecCheckbox);
    sortRow.add(sortBtn);

    JPanel actionRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
    actionRow.add(addBtn);
    actionRow.add(removeBtn);
    actionRow.add(saveBtn);
    actionRow.add(helpBtn);

    //add to the main panel?
    add(filterRow);
    add(sortRow);
    add(actionRow);
}
/**
 * Returns the user's search query from the text field.
 * @return search input as a String
 */
public String getSearchQuery() {
    return searchField.getText();
}
/**
 * Returns the selected filter type (e.g., Title, Genre, Year).
 * @return selected filter as a String
 */
public String getSelectedFilter() {
    return filterDropdown.getSelectedItem().toString();
}

/**
 * Returns the selected filter operator (e.g., ==, >=, ~=).
 * @return selected operator as a String
 */
public String getSelectedOperator() {
    return operatorDropdown.getSelectedItem().toString();
}

/**
 * Returns true if the "Sort Ascending" checkbox is selected.
 * @return true for ascending, false otherwise
 */
public boolean isSortAscending() {
    return sortAscCheckbox.isSelected();
}



/**
 * Adds an ActionListener to the Filter button.
 *
 * @param listener the ActionListener to be notified when the filter button is clicked
 */
public void addFilterListener(ActionListener listener) {
    filterBtn.addActionListener(listener);
}

/**
 * Adds an ActionListener to the Sort button.
 *
 * @param listener the ActionListener to be notified when the sort button is clicked
 */
public void addSortListener(ActionListener listener) {
    sortBtn.addActionListener(listener);
}

/**
 * Adds an ActionListener to the "Add to List" button.
 *
 * @param listener the ActionListener to be notified when the add button is clicked
 */
public void addAddMovieListener(ActionListener listener) {
    addBtn.addActionListener(listener);
}

/**
 * Adds an ActionListener to the "Remove from List" button.
 *
 * @param listener the ActionListener to be notified when the remove button is clicked
 */
public void addRemoveMovieListener(ActionListener listener) {
    removeBtn.addActionListener(listener);
}

/**
 * Adds an ActionListener to the "Save to File" button.
 *
 * @param listener the ActionListener to be notified when the save button is clicked
 */
public void addSaveListener(ActionListener listener) {
    saveBtn.addActionListener(listener);
}

/**
 * Adds an ActionListener to the Help button.
 *
 * @param listener the ActionListener to be notified when the help button is clicked
 */
public void addHelpListener(ActionListener listener) {
    helpBtn.addActionListener(listener);
}


}