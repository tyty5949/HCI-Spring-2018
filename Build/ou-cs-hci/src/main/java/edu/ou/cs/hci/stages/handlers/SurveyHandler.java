package edu.ou.cs.hci.stages.handlers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

/**
 * The <CODE>SurveyHandler</CODE> class which is designed to hold the action listeners and events for the survey UI.
 * *********************************************************************************************************************
 * Major Modification History:
 * 20180313 [tyler]:  Original file created.
 */
public class SurveyHandler {

    /**
     * Action listeners
     */
    private ActionListener question3AL;
    private ActionListener question4AL;
    private FocusListener question5FL;
    private ActionListener finishButtonAL;

    /**
     * Interaction toggles
     */
    private boolean hasQ3Interacted = false;
    private boolean hasQ4Interacted = false;
    private boolean hasQ5Interacted = false;
    private JButton finishButton;

    /**
     * Other private variables
     */
    private ArrayList<String> selectedSearchMetrics;
    private String selectedLikert;
    private JSlider question1Slider;
    private JSpinner question2Spinner;
    private JTextArea question5TextArea;
    private JFrame surveyFrame;
    private long startTime;

    /**
     * Constructor which will initialize all the action listeners.
     */
    public SurveyHandler() {
        question3AL = new Question3ActionListener();
        question4AL = new Question4ActionListener();
        question5FL = new Question5FocusListener();
        finishButtonAL = new FinishButtonActionListener();
        selectedSearchMetrics = new ArrayList<>();
        startTime = System.currentTimeMillis();
    }

    /**
     * Gets the action listener instance for question 3 of the survey.
     *
     * @return - The question 3 action listener
     */
    public ActionListener getQuestion3AL() {
        return question3AL;
    }

    /**
     * Gets the action listener instance for question 4 of the survey.
     *
     * @return - The question 4 action listener
     */
    public ActionListener getQuestion4AL() {
        return question4AL;
    }

    /**
     * Gets the focus listener instance for question 5 of the survey.
     *
     * @return - The question 5 focus listener
     */
    public FocusListener getQuestion5FL() {
        return question5FL;
    }

    /**
     * Gets the action listener instance for the finish button of the survey.
     *
     * @return - The finish button action listener
     */
    public ActionListener getFinishButtonAL() {
        return finishButtonAL;
    }

    /**
     * Links the given JButton to this survey handler as the finish button.
     *
     * @param finishButton - The finish button in the survey.
     */
    public void linkFinishButton(JButton finishButton) {
        this.finishButton = finishButton;
    }

    /**
     * Links the given JSlider to this survey handler as the question 1 slider.
     *
     * @param slider - The question 1 slider in the survey.
     */
    public void linkQuestion1Slider(JSlider slider) {
        this.question1Slider = slider;
    }

    /**
     * Links the given JSpinner to this survey handler as the question 2 spinner.
     *
     * @param spinner - The question 2 spinner in the survey.
     */
    public void linkQuestion2Spinner(JSpinner spinner) {
        this.question2Spinner = spinner;
    }

    /**
     * Links the given JFrame to this survey handler as the frame for the survey.
     *
     * @param surveyFrame - The frame for the survey.
     */
    public void linkSurveyFrame(JFrame surveyFrame) {
        this.surveyFrame = surveyFrame;
    }

    /**
     * The ActionListener class for question 3.
     */
    private class Question3ActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            hasQ3Interacted = true;
            // Enable finish button if necessary
            if (hasQ4Interacted && hasQ5Interacted) {
                finishButton.setEnabled(true);
            }

            // Update which metrics are selected
            JCheckBox button = (JCheckBox) e.getSource();
            if (selectedSearchMetrics.contains(button.getText())) {
                selectedSearchMetrics.remove(button.getText());
            } else {
                selectedSearchMetrics.add(button.getText());
            }
        }
    }

    /**
     * The ActionListener class for question 4.
     */
    private class Question4ActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            hasQ4Interacted = true;
            // Enable finish button if necessary
            if (hasQ3Interacted && hasQ5Interacted) {
                finishButton.setEnabled(true);
            }

            // Update selected likert
            JRadioButton button = (JRadioButton) e.getSource();
            selectedLikert = button.getText();
        }
    }

    /**
     * The FocusListener class for question 5.
     */
    private class Question5FocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            hasQ5Interacted = true;
            // Enable finish button if necessary
            if (hasQ4Interacted && hasQ3Interacted) {
                finishButton.setEnabled(true);
            }

            // Link text area
            question5TextArea = (JTextArea) e.getSource();
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }

    /**
     * The ActionListener for the finish button. Prints out the time it took to complete the survey, the survey
     * answers, and then hides the linked survey frame.
     */
    private class FinishButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Took " + ((System.currentTimeMillis() - startTime) / 1000.0) + " seconds.\n");
            String[] options = new String[]{"None", "Some", "A lot"};
            System.out.println("1) How much effort would you say you put into finding new movies to watch?\n\t" +
                    options[question1Slider.getValue()]);
            System.out.println("2) On average, how many movies do you stream to your devices from home a week?\n\t" +
                    question2Spinner.getValue());
            System.out.println("3) Select the search metrics you are most likely to use when trying to find a " +
                    "movie?\"\n\t" + selectedSearchMetrics);
            System.out.println("4) I am comfortable with utilizing search and sort functions to find movies that I " +
                    "might like to watch?\n\t" + selectedLikert);
            System.out.println("5) In a couple sentences describe your current method for finding new movies to " +
                    "watch.\n\t" + question5TextArea.getText());
            surveyFrame.setVisible(false);
        }
    }
}
