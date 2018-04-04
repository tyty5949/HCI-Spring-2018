package edu.ou.cs.hci.stages.panels;

import edu.ou.cs.hci.stages.util.PanelHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * The <CODE>Stage5Panel</CODE> class which is the JPanel for displaying stage 5 on a frame. Split up this way so that
 * the stages can be kept separate. Almost exactly the same as stage 4.
 * *********************************************************************************************************************
 * Major Modification History:
 * 20180404 [tyler]:  Original file created.
 * 20180404 [tyler]:  Copied from Stage5Panel
 */
public class Stage6Panel extends JPanel {

    private JPanel workspacePanel;
    private EditorPanel editorPanel;
    private BrowserPanel browserPanel;

    public Stage6Panel() {
        // Setup panel
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();

        // Title bar panel
        JPanel titlePanel = makeTitlePanel();
        PanelHelper.updateGBConstraints(gbc, 0, 0, 1, 1, GridBagConstraints.HORIZONTAL,
                0, 0, 1.0, 0.0);
        add(titlePanel, gbc);

        // Editor panel
        editorPanel = new EditorPanel();

        // Browser panel
        browserPanel = new BrowserPanel();

        // Workspace panel
        updateWorkspacePanel(0);
        PanelHelper.updateGBConstraints(gbc, 0, 1, 1, 1, GridBagConstraints.BOTH,
                0, 0, .5, .5);
        add(workspacePanel, gbc);
    }

    public void writeWidgets(File file) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file, "UTF-8");
            printWriter.println("Editor panel:");
            // TODO - Write file
            printWriter.println("Filter panel:");
            // TODO - Write file
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    private JPanel makeTitlePanel() {
        // Setup panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Title text
        JLabel label = new JLabel(" iFilm");
        label.setFont(new Font("Arial", Font.BOLD, 36));
        panel.add(label, BorderLayout.WEST);

        // Return created panel
        return panel;
    }

    private void updateWorkspacePanel(int mode) {
        // TODO - Implementation should change based on given mode
        // Setup panel
        workspacePanel = new JPanel(new GridBagLayout());
        workspacePanel.setBackground(Color.WHITE);
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
