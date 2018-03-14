package edu.ou.cs.hci.stages.panels;

import edu.ou.cs.hci.stages.handlers.SurveyHandler;
import edu.ou.cs.hci.stages.util.PanelHelper;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class SurveyPanel extends JPanel {

    private final String[] SEARCH_METRICS = new String[] {"Genre", "Runtime", "Actors/Directors", "Rotten Tomatoes"};

    private SurveyHandler surveyHandler;

    public SurveyPanel(JFrame surveyFrame) {
        // Setup panel layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Create survey handler
        surveyHandler = new SurveyHandler();
        surveyHandler.linkSurveyFrame(surveyFrame);

        // Create question 1
        PanelHelper.updateGBConstraints(gbc, 0, 0, 1, 1, GridBagConstraints.HORIZONTAL,
                20, 0, .5, .5);
        gbc.insets = new Insets(0, 20, 0, 0);
        JPanel question1Panel = makeQuestion1();
        add(question1Panel, gbc);


        // Create question 2
        PanelHelper.updateGBConstraints(gbc, 0, 1, 1, 1, GridBagConstraints.HORIZONTAL,
                20, 0, .25, .75);
        gbc.insets = new Insets(0, 20, 5, 0);
        JPanel question2Panel = makeQuestion2();
        add(question2Panel, gbc);

        // Create question 3
        PanelHelper.updateGBConstraints(gbc, 0, 2, 1, 1, GridBagConstraints.HORIZONTAL,
                0, 0, .5, .5);
        JPanel question3Panel = makeQuestion3();
        add(question3Panel, gbc);

        // Create question 4
        PanelHelper.updateGBConstraints(gbc, 0, 3, 1, 1, GridBagConstraints.HORIZONTAL,
                20, 0, .5, .5);
        JPanel question4Panel = makeQuestion4();
        add(question4Panel, gbc);

        // Create question 5
        PanelHelper.updateGBConstraints(gbc, 0, 4, 1, 1, GridBagConstraints.HORIZONTAL,
                20, 0, .5, .5);
        JPanel question5Panel = makeQuestion5();
        add(question5Panel, gbc);

        // Create finish button
        JPanel finishPanel = new JPanel(new BorderLayout());
        JButton finishButton = new JButton("Finish");
        surveyHandler.linkFinishButton(finishButton);
        finishButton.setEnabled(false);
        finishButton.setMaximumSize(new Dimension(100, 30));
        finishButton.addActionListener(surveyHandler.getFinishButtonAL());
        finishPanel.add(finishButton, BorderLayout.EAST);
        PanelHelper.updateGBConstraints(gbc, 0, 5, 1, 1, GridBagConstraints.HORIZONTAL,
                20, 20, .2, .8);
        gbc.insets = new Insets(0, 0, 0, 0);
        add(finishPanel, gbc);
    }

    private JPanel makeQuestion1() {
        JPanel q1Panel = new JPanel(new BorderLayout());
        JLabel question1Label = new JLabel("1) How much effort would you say you put into finding new movies to watch?");
        q1Panel.add(question1Label, BorderLayout.NORTH);
        JSlider q1Slider = new JSlider(JSlider.HORIZONTAL, 0, 2, 0);
        surveyHandler.linkQuestion1Slider(q1Slider);
        q1Slider.setSize(200, 30);
        Hashtable<Integer, JLabel> sliderTable = new Hashtable<>();
        sliderTable.put(0, new JLabel("None"));
        sliderTable.put(1, new JLabel("Some"));
        sliderTable.put(2, new JLabel("A lot"));
        q1Slider.setLabelTable(sliderTable);
        q1Slider.setPaintLabels(true);
        q1Panel.add(q1Slider, BorderLayout.WEST);
        return q1Panel;
    }

    private JPanel makeQuestion2() {
        JPanel q2Panel = new JPanel(new BorderLayout());
        JLabel question2Label = new JLabel("2) On average, how many movies do you stream to your devices from home a week?");
        q2Panel.add(question2Label, BorderLayout.NORTH);
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 0, 10, 1);
        JSpinner q2Spinner = new JSpinner(spinnerModel);
        surveyHandler.linkQuestion2Spinner(q2Spinner);
        ((JSpinner.DefaultEditor) q2Spinner.getEditor()).getTextField().setColumns(2);
        q2Panel.add(q2Spinner, BorderLayout.WEST);
        return q2Panel;
    }

    private JPanel makeQuestion3() {
        JPanel q3Panel = new JPanel(new GridLayout(5, 1));
        JLabel question3Label = new JLabel("3) Select the search metrics you are most likely to use when trying to find a movie?");
        q3Panel.add(question3Label);
        JCheckBox genre = new JCheckBox(SEARCH_METRICS[0]);
        genre.addActionListener(surveyHandler.getQuestion3AL());
        q3Panel.add(genre);
        JCheckBox runtime = new JCheckBox(SEARCH_METRICS[1]);
        runtime.addActionListener(surveyHandler.getQuestion3AL());
        q3Panel.add(runtime);
        JCheckBox actorsDirectors = new JCheckBox(SEARCH_METRICS[2]);
        actorsDirectors.addActionListener(surveyHandler.getQuestion3AL());
        q3Panel.add(actorsDirectors);
        JCheckBox rottenTomatoes = new JCheckBox(SEARCH_METRICS[3]);
        rottenTomatoes.addActionListener(surveyHandler.getQuestion3AL());
        q3Panel.add(rottenTomatoes);
        return q3Panel;
    }

    private JPanel makeQuestion4() {
        JPanel q4Panel = new JPanel(new GridLayout(6, 1));
        JLabel question4Label = new JLabel("4) I am comfortable with utilizing search and sort functions to find movies that I might like to watch?");
        q4Panel.add(question4Label);
        JRadioButton stronglyAgree = new JRadioButton("Strongly Agree");
        stronglyAgree.addActionListener(surveyHandler.getQuestion4AL());
        q4Panel.add(stronglyAgree);
        JRadioButton agree = new JRadioButton("Agree");
        agree.addActionListener(surveyHandler.getQuestion4AL());
        q4Panel.add(agree);
        JRadioButton neutral = new JRadioButton("Neutral");
        neutral.addActionListener(surveyHandler.getQuestion4AL());
        q4Panel.add(neutral);
        JRadioButton disagree = new JRadioButton("Disagree");
        disagree.addActionListener(surveyHandler.getQuestion4AL());
        q4Panel.add(disagree);
        JRadioButton stronglyDisagree = new JRadioButton("Strongly Disagree");
        stronglyDisagree.addActionListener(surveyHandler.getQuestion4AL());
        q4Panel.add(stronglyDisagree);
        ButtonGroup q4Group = new ButtonGroup();
        q4Group.add(stronglyAgree);
        q4Group.add(agree);
        q4Group.add(neutral);
        q4Group.add(disagree);
        q4Group.add(stronglyDisagree);
        return q4Panel;
    }

    private JPanel makeQuestion5() {
        JPanel q5Panel = new JPanel(new GridLayout(2, 1));
        JLabel question5Label = new JLabel("5) In a couple sentences describe your current method for finding new movies to watch.");
        q5Panel.add(question5Label);
        JTextArea q5TextArea = new JTextArea();
        q5TextArea.addFocusListener(surveyHandler.getQuestion5FL());
        q5TextArea.setLineWrap(true);
        JScrollPane q5Scroll = new JScrollPane(q5TextArea);
        q5Scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        q5Scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        q5Panel.add(q5Scroll);
        return q5Panel;
    }
}
