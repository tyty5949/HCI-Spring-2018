package edu.ou.cs.hci.stages.panels;

import edu.ou.cs.hci.stages.util.PanelHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * The <CODE>Stage5Panel</CODE> class which is the JPanel for displaying stage 7 on a frame. Split up this way so that
 * the stages can be kept separate. Almost exactly the same as stage 6.
 * *********************************************************************************************************************
 * Major Modification History:
 * 20180404 [tyler]:  Original file created.
 * 20180404 [tyler]:  Copied from Stage6Panel
 */
public class Stage7Panel extends JPanel {

    private JPanel workspacePanel;
    private EditorPanel editorPanel;
    private BrowserPanel browserPanel;

    // TODO - Add implementation for storing CSV files in here!

    /**
     * Opening up access to the internal panels so actions can access data within them.
     *
     * @return - The EditorPanel instance running on the main window.
     */
    public EditorPanel getEditorPanel() {
        return editorPanel;
    }

    /**
     * Opening up access to the internal panels so actions can access data within them.
     *
     * @return - The BrowserPanel instance running on the main window.
     */
    public BrowserPanel getBrowserPanel() {
        return browserPanel;
    }

    public Stage7Panel() {
        // Setup panel
        setLayout(new GridBagLayout());
        setBackground(new Color(231, 202, 177));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();

        // Title bar panel
        JPanel titlePanel = makeTitlePanel();
        PanelHelper.updateGBConstraints(gbc, 0, 0, 1, 1, GridBagConstraints.HORIZONTAL,
                0, 0, 1.0, 0.0);
        add(titlePanel, gbc);

        // Editor panel
        editorPanel = new EditorPanel(this);

        // Browser panel
        browserPanel = new BrowserPanel(this);

        // Workspace panel
        updateWorkspacePanel(0);
        PanelHelper.updateGBConstraints(gbc, 0, 1, 1, 1, GridBagConstraints.BOTH,
                0, 0, .5, .5);
        add(workspacePanel, gbc);
    }

    private JPanel makeTitlePanel() {
        // Setup panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(128, 0, 0));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Title text
        JLabel label = new JLabel(" iFilm");
        label.setFont(new Font("Arial", Font.BOLD, 36));
        label.setForeground(Color.BLACK);
        panel.add(label, BorderLayout.WEST);

        // Return created panel
        return panel;
    }

    private void updateWorkspacePanel(int mode) {
        // Setup panel
        workspacePanel = new JPanel(new GridBagLayout());
        workspacePanel.setBackground(new Color(231, 202, 177));
        GridBagConstraints gbc = new GridBagConstraints();

        // Editor view
        PanelHelper.updateGBConstraints(gbc, 0, 0, 1, 1, GridBagConstraints.BOTH,
                0, 0, .5, .5);
        workspacePanel.add(editorPanel, gbc);

        // Browser view
        PanelHelper.updateGBConstraints(gbc, 1, 0, 1, 1, GridBagConstraints.BOTH,
                0, 0, .5, .5);
        gbc.insets = new Insets(15, 0, 20, 0);
        workspacePanel.add(browserPanel, gbc);
    }
}
