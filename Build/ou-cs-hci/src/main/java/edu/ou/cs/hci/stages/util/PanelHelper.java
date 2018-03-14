package edu.ou.cs.hci.stages.util;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

/**
 * The <CODE>PanelHelper</CODE> class which contains helper methods to speed up the creation of JPanels. It also adds
 * specialty functionality for quickly creating things such as metadata fields/areas in the editor and filter panels
 * in the browser.
 * <p/>
 * *********************************************************************************************************************
 * Major Modification History:
 * 20180313 [tyler]:  Original file created.
 */
public class PanelHelper {

    /**
     * Helper method which encapsulates the updating of the multiple GridBagConstraints variables in a single method
     * call. This exists largely for the purpose of keeping panel code cleaner as blocks of GBC code are no longer
     * necessary.
     * NOTE: This method DOES NOT update the 'insets' or 'anchor' variables.
     *
     * @param gbc        - The GridBagConstraints to update
     * @param gridx      - The column in the GridBagLayout to place the component
     * @param gridy      - The row in the GridBagLayout to place the component
     * @param gridwidth  - The number of columns the component should take up in the GridBagLayout
     * @param gridheight - The number of rows the component should take up in the GridBagLayout
     * @param fill       - The type of fill to use when the panel is re-sized past the size of the component
     * @param ipadx      - The internal padding along the x-axis of the component within its specified grid boxes
     * @param ipady      - The internal padding along the y-axis of the component within its specified grid boxes
     * @param weightx    - The weight of the x-axis when resizing the component
     * @param weighty    - The weight of the y-axis when resizing the component
     */
    public static void updateGBConstraints(GridBagConstraints gbc, int gridx, int gridy, int gridwidth, int gridheight,
                                           int fill, int ipadx, int ipady, double weightx, double weighty) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.fill = fill;
        gbc.ipadx = ipadx;
        gbc.ipady = ipady;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
    }

    // TODO - Work-around for JTextField shrinking when window re-sized

    /**
     * Makes a metadata field for the editor panel. Takes care of creating the label, then the text field that is created
     * next to it. A field is a one line entry, for multiple line entry see makeMetadataArea.
     * NOTE: Returns the array of created components in the following order:
     * 1) The created JPanel which holds the label and text field.
     * 2) The created JLabel which is the title for the field.
     * 3) The created JTextField which is the text field for entering data.
     *
     * @param fieldTitle - The title of the metadata field (can be blank)
     * @param fieldText  - The text to populate the metadata field with (can be blank)
     * @return - The list of created components, useful for customization and adding to panel
     */
    public static Component[] makeMetadataField(String fieldTitle, String fieldText) {
        // Construct the panel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.WHITE);
        JLabel label = new JLabel(fieldTitle);
        panel.add(label);
        JTextArea textArea = new JTextArea(fieldText);
        textArea.setBackground(Color.WHITE);
        textArea.setEditable(true);
        textArea.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel.add(textArea);

        // Return created components
        return new Component[]{panel, label, textArea};
    }

    /**
     * Makes a metadata area for the editor panel. Takes care of creating the label, then the text area that is created
     * next to it. A area is a multiple line entry, for single line entry see makeMetadataField.
     * NOTE: Returns the array of created components in the following order:
     * 1) The created JPanel which holds the label and text area.
     * 2) The created JLabel which is the title for the area.
     * 3) The created JTextArea which is the text area for entering data.
     *
     * @param areaTitle - The title of the metadata area (can be blank)
     * @param areaText  - The text to populate the metadata area with (can be blank)
     * @return - The array of created components, useful for customization and adding to panel
     */
    public static Component[] makeMetadataArea(String areaTitle, String areaText) {
        // Construct the panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        JLabel label = new JLabel(areaTitle, SwingConstants.LEFT);
        panel.add(label, BorderLayout.NORTH);
        JTextArea textArea = new JTextArea(areaText);
        textArea.setBackground(Color.WHITE);
        textArea.setEditable(true);
        textArea.setBorder(new EmptyBorder(0, 0, 0, 0));
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setEnabled(false);
        textArea.setRows(2);

        // Return created components
        return new Component[]{panel, label, textArea, scrollPane};
    }

    // TODO - Action listener implementation

    /**
     * A helper method creating a filter section within the filter panel. It creates a label to act as the title of the
     * section and list of check-boxes which function as the options for the filter.
     * NOTE: Returns the array of created components in the following order.
     * 1) The JPanel which holds the label and check boxes.
     * 2) The JLabel which is the title for the filter section.
     * 3 to n) The n JCheckBoxes which are specified by the options parameter. The number of the is determined by the number
     * of supplied options.
     *
     * @param filterTitle - The title of the filter section
     * @param options     - The options for the filter section, in the order that they will appear
     * @return - The array of created components, useful for customization and adding to panel
     */
    public static Component[] makeFilterSection(String filterTitle, String[] options) {
        // Construct the panel
        JPanel panel = new JPanel(new GridLayout(1 + options.length, 1));
        panel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel(filterTitle, SwingConstants.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(titleLabel);
        JCheckBox[] optionCheckBoxes = new JCheckBox[options.length];
        for (int i = 0; i < options.length; i++) {
            optionCheckBoxes[i] = new JCheckBox(options[i]);
            optionCheckBoxes[i].setBackground(Color.WHITE);
            panel.add(optionCheckBoxes[i]);
        }

        // Return created components
        Component[] components = new Component[2 + optionCheckBoxes.length];
        components[0] = panel;
        components[1] = titleLabel;
        System.arraycopy(optionCheckBoxes, 0, components, 2, optionCheckBoxes.length);
        return components;
    }

    /**
     * Helper method which takes a font, and returns the same font but with the underline attribute enabled.
     *
     * @param font      - The target font to underline
     * @param underline - Whether or not to underline the font
     * @return - The font with the underline attribute turned on
     */
    @SuppressWarnings("unchecked")
    public static Font underlineFont(Font font, boolean underline) {
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        return font.deriveFont(attributes);
    }
}
