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
    private final JCheckBox sortAscCheckbox;

    // command Buttons
    private final JButton searchBtn;
    private final JButton filterBtn;
    private final JButton sortBtn;
    private final JButton addBtn;
    private final JButton removeBtn;
    private final JButton saveBtn;
}
