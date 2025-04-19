package student.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 * A JPanel that contains all buttons, dropdowns, and input fields
 * used for user interaction at the top of the movie application.
 */
public class ButtonCommands extends JPanel {
    // Store all "Add" listeners (used when a movie card is clicked)
    private final List<ActionListener> addListeners = new ArrayList<>();


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
    private final JButton addAllBtn;
    private final JButton resetBtn;
    private final JButton helpBtn;

     /**
     * Constructs a new ButtonCommands panel with all interactive components.
     */
    public ButtonCommands(){

        setLayout(new GridLayout(3, 1)); // Two rows: top (filters), bottom (actions)

    // initialize components 
    searchField = new JTextField(15);
    filterDropdown = new JComboBox<>(new String[]{"Title", "Genre", "Year", "Description"});
    operatorDropdown = new JComboBox<>(new String[]{"==", "!=", ">=", "<=", ">", "<", "~="});
    sortDropdown = new JComboBox<>(new String []{"Title","Rating", "Year"});
    sortAscCheckbox = new JCheckBox("Ascending");
    sortDecCheckbox = new JCheckBox("Descending");


    filterBtn = new JButton("Filter");
    sortBtn = new JButton("Sort");
    addAllBtn = new JButton("Add All");
    resetBtn = new JButton("Reset Collection");
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

    // if the Asc button is checked, then set dec button to disable
    sortAscCheckbox.addActionListener(e->{
        if (sortAscCheckbox.isSelected()){
            sortDecCheckbox.setEnabled(false);
        } else {
            sortDecCheckbox.setEnabled(true);
        }
    });

    // if the Dec button is checked, then set Asc button to disable
    sortDecCheckbox.addActionListener(e->{
        if(sortDecCheckbox.isSelected()){
            sortAscCheckbox.setEnabled(false);
        }else {
            sortAscCheckbox.setEnabled(true);
        }
    });


    JPanel actionRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
    actionRow.add(addAllBtn);
    actionRow.add(resetBtn);
    
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
* Returns the selected sort filter type (e.g., IMDB Rating, Year).
* @return selected sorted filter as a String
*/
public String getSelectedSort() {
        return sortDropdown.getSelectedItem().toString();
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

public boolean notAscDec() {
    if (!sortAscCheckbox.isSelected() && !sortDecCheckbox.isSelected()) {
        return true;
    } else {
        return false;
    }
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
/* public void addAddMovieListener(ActionListener listener) {
    addAllBtn.addActionListener(listener);
} */

/**
 * Adds an ActionListener to the "Remove from List" button.
 *
 * @param listener the ActionListener to be notified when the remove button is clicked
 */
public void addRemoveMovieListener(ActionListener listener) {
    resetBtn.addActionListener(listener);
}


/**
 * Adds an ActionListener to the Help button.
 *
 * @param listener the ActionListener to be notified when the help button is clicked
 */
public void addHelpListener(ActionListener listener) {
    helpBtn.addActionListener(listener);
}

/**
 * Adds an ActionListener to the "Add All" button.
 *
 * @param listener the ActionListener to be notified when the add all button is clicked
 */
public void addAddAllListener(ActionListener listener) {
    addAllBtn.addActionListener(listener);
}

public void setSearchQuery(String query) {
    searchField.setText(query);
}

public void addAddMovieListener(ActionListener listener) {
    addListeners.add(listener);
}

public List<ActionListener> getAddListeners() {
    return addListeners;
}





}