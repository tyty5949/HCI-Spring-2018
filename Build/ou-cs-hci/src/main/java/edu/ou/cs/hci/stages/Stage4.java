package edu.ou.cs.hci.stages;

import edu.ou.cs.hci.stages.panels.PersonaScenarioPanel;
import edu.ou.cs.hci.stages.panels.Stage4Panel;
import edu.ou.cs.hci.stages.panels.SurveyPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class Stage4 {

    private static final boolean ENABLE_MAIN_FRAME = true;
    private static final boolean ENABLE_PERSONA_SCENARIO = false;
    private static final boolean ENABLE_SURVEY = false;

    //**********************************************************************
    // Main
    //**********************************************************************
    public static void main(String[] args) {
        new Stage4();
    }

    private JFrame stage4Frame;
    private Stage4Panel stage4Panel;

    private Stage4() {
        // Create main panel
        stage4Panel = new Stage4Panel();

        // Create main frame
        stage4Frame = new JFrame("iFilm - Stage 4");
        stage4Frame.setBounds(50, 50, 1100, 650);
        stage4Frame.getContentPane().setLayout(new BorderLayout());
        stage4Frame.getContentPane().add(stage4Panel, BorderLayout.CENTER);
        stage4Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stage4Frame.addWindowListener(new MainWindowAdapter());
        stage4Frame.setVisible(ENABLE_MAIN_FRAME);

        // Create personas and scenarios panel
        PersonaScenarioPanel personaScenarioPanel = new PersonaScenarioPanel();

        // Create personas and scenarios frame
        JFrame personaScenarioFrame = new JFrame("Personas and Scenarios");
        personaScenarioFrame.setBounds(100, 100, 600, 400);
        personaScenarioFrame.getContentPane().setLayout(new BorderLayout());
        personaScenarioFrame.getContentPane().add(personaScenarioPanel, BorderLayout.CENTER);
        personaScenarioFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        personaScenarioFrame.setVisible(ENABLE_PERSONA_SCENARIO);

        // Create survey frame
        JFrame surveyFrame = new JFrame("iMovie Questionnaire");

        // Create survey panel
        SurveyPanel surveyPanel = new SurveyPanel(surveyFrame);

        // Finish creating survey frame
        surveyFrame.setBounds(50, 50, 700, 800);
        surveyFrame.getContentPane().setLayout(new BorderLayout());
        surveyFrame.getContentPane().add(surveyPanel, BorderLayout.CENTER);
        surveyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        surveyFrame.setVisible(ENABLE_SURVEY);
    }

    private class MainWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            // Select .txt file
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File",
                    "txt");
            fileChooser.setFileFilter(extensionFilter);
            int choice = fileChooser.showSaveDialog(stage4Frame);
            if (choice != 0) {
                System.exit(0);
            }
            File file = fileChooser.getSelectedFile();
            if (!file.exists()) {
                boolean success;
                try {
                    success = file.createNewFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    success = false;
                }
                if (!success) {
                    System.err.println("Unable to save file!");
                    System.exit(-1);
                }
            }

            // Write .txt file
            stage4Panel.writeWidgets(file);

            // Exit
            System.exit(0);
        }
    }
}
