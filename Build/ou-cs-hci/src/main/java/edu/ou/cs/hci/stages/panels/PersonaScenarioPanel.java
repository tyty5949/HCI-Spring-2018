package edu.ou.cs.hci.stages.panels;

import edu.ou.cs.hci.resources.Resources;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

/**
 * The <CODE>PanelHelper</CODE> class which contains the code for creating the Personas and Scenarios panel for stage 3
 * of the project.
 * <p/>
 * *********************************************************************************************************************
 * Major Modification History:
 * 20180313 [tyler]:  Original file created.
 */
public class PersonaScenarioPanel extends JPanel {

    /**
     * The list component to display the different scenario titles.
     */
    private JList<String> scenariosList;

    /**
     * The text area to display the description of the selected scenario.
     */
    private JTextArea scenariosTextArea;

    /**
     * The list of loaded scenario titles.
     */
    private ArrayList<String> scenarioTitles;

    /**
     * The list of loaded scenario descriptions, mapped to their corresponding titles.
     */
    private ArrayList<String> scenarioDescriptions;

    /**
     * Constructor which initializes all of the components and lays them out within the panel.
     */
    public PersonaScenarioPanel() {
        // Setup panel
        setBackground(Color.WHITE);

        // Create scenarios JList
        scenariosList = new JList<>();
        scenariosList.addListSelectionListener(new ScenariosListSelectionListener());
        add(scenariosList, BorderLayout.LINE_START);

        // Create JTextArea for displaying selected scenario
        scenariosTextArea = new JTextArea(20, 35);
        scenariosTextArea.setEditable(false);
        scenariosTextArea.setWrapStyleWord(true);
        scenariosTextArea.setLineWrap(true);
        add(scenariosTextArea, BorderLayout.LINE_END);

        // Load data
        scenarioTitles = Resources.getLines("/edu/ou/cs/hci/resources/scenarios/titles.txt");
        scenarioDescriptions = Resources.getLines("/edu/ou/cs/hci/resources/scenarios/" +
                "descriptions.txt");

        // Error checking load functions
        boolean isError = false;
        if (scenarioTitles == null || scenarioTitles.size() == 0) {
            scenariosTextArea.setText("Error! Unable to load scenario titles...");
            isError = true;
        }
        if (scenarioDescriptions == null || scenarioDescriptions.size() == 0) {
            scenariosTextArea.setText("Error! Unable to load scenario descriptions...");
            isError = true;
        }

        // Link data to components
        if (!isError) {
            scenariosList.setListData(scenarioTitles.toArray(new String[]{}));
            scenariosList.setSelectedIndex(0);
            scenariosTextArea.setText(scenarioDescriptions.get(0));
        }
    }

    /**
     * Private inner class which handles the events when a new value is selected in the title JList.
     */
    private class ScenariosListSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // Update the text area
            // NOTE: Error checking is not required as the JList will not even be populated if there was any error.
            scenariosTextArea.setText(scenarioDescriptions.get(scenariosList.getSelectedIndex()));
        }
    }
}
