/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ou.cs.hci.stages;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author StoryTellr
 */
public class SurveyFrame {
    
    //member variables used for the survey portion's event listeners
    private static boolean[] questionnairFlags;
    private static JButton submitButton;
    
    public static void makeSurveyFrame()
    {
        // Frame for Survey Questionnair
        JFrame surveyFrame = new JFrame("Survey and Analysis");
        surveyFrame.getContentPane().setLayout(new BoxLayout(
                surveyFrame.getContentPane(), BoxLayout.PAGE_AXIS));
        
        //make sure there is a bit of space around each panel
        Border questionBorder = new EmptyBorder(15, 15, 15, 15);
        
        //initialize the flags
        questionnairFlags = new boolean[5];
        for (int i = 0; i < questionnairFlags.length; i++) {
            questionnairFlags[i] = false;
        }
        
        //make the panel for the first question
        JPanel q1Panel = new JPanel();
        q1Panel.setLayout(new BoxLayout(q1Panel, BoxLayout.PAGE_AXIS));
        q1Panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        q1Panel.setBorder(questionBorder);
        JLabel question1 = new JLabel
            ("1) What parameters do you usually use to search for movies?");
        //this question requires non-exclusive choices
        JCheckBox[] q1CheckBoxes = {
            new JCheckBox("The Title of the movie"),
            new JCheckBox("The Genre"),
            new JCheckBox("Actors Cast"),
            new JCheckBox("The directors and/or studios that worked on it"),
            new JCheckBox("Critic reviews and scores"),
            new JCheckBox("Audiance reviews and scores"),
            new JCheckBox("The MPAA Maturity Rating")
        };
        q1Panel.add(question1);
        for (int i = 0; i < q1CheckBoxes.length; i++) {
            q1CheckBoxes[i].setSelected(false);
            q1Panel.add(q1CheckBoxes[i]);
        }
        
        //make the panel for the second question
        JPanel q2Panel = new JPanel();
        q2Panel.setLayout(new BoxLayout(q2Panel, BoxLayout.PAGE_AXIS));
        q2Panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        q2Panel.setBorder(questionBorder);
        JLabel question2 = new JLabel
            ("2) Out of all of these parameters, which would you say is the most important?");
        //the answers for this question require will come directly from the first
        //and there can only be one "most important parameter"
        JRadioButton[] q2Buttons = new JRadioButton[q1CheckBoxes.length];
        ButtonGroup q2Group = new ButtonGroup();
        q2Panel.add(question2);
        for (int i = 0; i < q2Buttons.length; i++) {
            //initialize each button
            q2Buttons[i] = new JRadioButton();
            q2Buttons[i].setText(q1CheckBoxes[i].getText());
            q2Buttons[i].setSelected(false);
            q2Group.add(q2Buttons[i]);
            q2Panel.add(q2Buttons[i]);
        }
        
        //make the panel for the third question
        JPanel q3Panel = new JPanel();
        q3Panel.setLayout(new BoxLayout(q3Panel, BoxLayout.PAGE_AXIS));
        q3Panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        q3Panel.setBorder(questionBorder);
        JLabel question3 = new JLabel
            ("3) How well do your search results typically match what you are looking for?");
        JSlider q3Slider = new JSlider(JSlider.HORIZONTAL, 0, 4, 2);
        q3Slider.setMajorTickSpacing(1);
        q3Slider.setPaintTicks(true);
        //add the labels to the slider
        Hashtable labelTable = new Hashtable();
        labelTable.put(0, new JLabel("Way off target"));
        labelTable.put(1, new JLabel("Poor match"));
        labelTable.put(2, new JLabel("Somewhat related"));
        labelTable.put(3, new JLabel("Very relevant"));
        labelTable.put(4, new JLabel("Perfect match"));
        q3Slider.setLabelTable(labelTable);
        q3Slider.setPaintLabels(true);
        q3Panel.add(question3);
        q3Panel.add(q3Slider);
        
        //make the panel for the fourth question
        JPanel q4Panel = new JPanel();
        q4Panel.setLayout(new BoxLayout(q4Panel, BoxLayout.PAGE_AXIS));
        q4Panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        q4Panel.setBorder(questionBorder);
        JLabel question4 = new JLabel
            ("4) How many movies and at what rate do you view, on average?");
        //make the spinner model first
        SpinnerModel q4SModel = new SpinnerListModel(
                new String[] {"1 per month or less", "2 to 4 per month",
                "1 or 2 per week", "3 to 6 per week", "7 per week (about 1 per day)",
                "at least 8 per week"});
        //then use it to make the spinner itself
        JSpinner q4Spinner = new JSpinner(q4SModel);
        q4Panel.add(question4);
        q4Panel.add(q4Spinner);
        
        //make the panel for the fifth and final question
        JPanel q5Panel = new JPanel();
        q5Panel.setLayout(new BoxLayout(q5Panel, BoxLayout.PAGE_AXIS));
        q5Panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        q5Panel.setBorder(questionBorder);
        JLabel question5 = new JLabel
            ("5) What positive feature(s) do you wish more movie streaming services had?");
        question5.setAlignmentX(Component.LEFT_ALIGNMENT);
        JTextArea q5ShortAnswer = new JTextArea();
        q5ShortAnswer.setRows(3);
        q5ShortAnswer.setAlignmentX(Component.LEFT_ALIGNMENT);
        q5ShortAnswer.setLineWrap(true);
        q5ShortAnswer.setWrapStyleWord(true);
        q5ShortAnswer.setEditable(true);
        q5Panel.add(question5);
        q5Panel.add(q5ShortAnswer);
        
        //finally, make the button to submit the answers given
        submitButton = new JButton("Finish and Submit Answers");
        JPanel submitPanel = new JPanel();
        submitPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        submitButton.setHorizontalAlignment(JButton.CENTER);
        submitPanel.setBorder(questionBorder);
        submitPanel.add(submitButton);
        //the button should initially be inactive
        submitButton.setEnabled(false);
        
        //put all the questions and answers together into the list
        surveyFrame.getContentPane().add(q1Panel);
        surveyFrame.getContentPane().add(q2Panel);
        surveyFrame.getContentPane().add(q3Panel);
        surveyFrame.getContentPane().add(q4Panel);
        surveyFrame.getContentPane().add(q5Panel);
        surveyFrame.getContentPane().add(submitPanel);
        //surveyFrame.setBounds(150, 100, 550, 850);
        surveyFrame.pack();
        surveyFrame.setVisible(true);
        surveyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //give functionality to the various survey components:
        //flag the check boxes as changed when the user clicks on one of them
        SurveyCheckBoxListener checkListener = new SurveyCheckBoxListener();
        SurveyRadioButtonListener radioListener = new SurveyRadioButtonListener();
        for (int i = 0; i < q1CheckBoxes.length; i++) {
            q1CheckBoxes[i].addItemListener(checkListener);
        }
        //flag the radio buttons as changed when the user clicks on one of them
        for (int i = 0; i < q2Buttons.length; i++) {
            q2Buttons[i].addActionListener(radioListener);
        }
        //flag the slider as changed when the user drags or clicks it
        q3Slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                questionnairFlags[2] = true;
                enableSubmit(questionnairFlags, submitButton);
                //test function to see if it actually works
                //System.out.println("3) match slider");
            }
        });
        //flag the spinner as changed when the user increases or decreases its value
        q4Spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                questionnairFlags[3] = true;
                enableSubmit(questionnairFlags, submitButton);
                //test function to see if it actually works
                //System.out.println("4) frequency spinner");
            }
        });
        //flag the text box as changed when the user types in it
        q5ShortAnswer.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                questionnairFlags[4] = true;
                enableSubmit(questionnairFlags, submitButton);
                //test function to see if it actually works
                //System.out.println("5) short answer text box");
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(question1.getText());
                int numSelected = 0;
                System.out.print("\t[");
                for (int i = 0; i < q1CheckBoxes.length; i++) {
                    if (q1CheckBoxes[i].isSelected()) {
                        if (numSelected > 0) {
                            System.out.print(", ");
                        }
                        System.out.print(q1CheckBoxes[i].getText());
                        numSelected++;
                    }
                }
                System.out.println(']');
                System.out.println(question2.getText());
                for (int i = 0; i < q2Buttons.length; i++) {
                    if (q2Buttons[i].isSelected()) {
                        System.out.println('\t' + q1CheckBoxes[i].getText());
                    }
                }
                System.out.println(question3.getText());
                JLabel tempLabel = (JLabel) labelTable.get(q3Slider.getValue());
                System.out.println("\t" + tempLabel.getText());
                System.out.println(question4.getText());
                System.out.println("\t" + q4Spinner.getValue());
                System.out.println(question5.getText());
                System.out.println('\t' + q5ShortAnswer.getText());
                //close the questionnair when your done
                //surveyFrame.dispose();
            }
        });
    }
    
    //helper method to check if the submition button sould be active and
    //activate it if so
    protected static boolean enableSubmit(boolean[] flagList, JButton submitButton) {
        boolean shouldEnable = true;
        //go through the list of flags and check each flag
        for (int i = 0; i < flagList.length; i++) {
            if (flagList[i] == false) {
                shouldEnable = false;
            }
        }
        if (shouldEnable) {
            submitButton.setEnabled(true);
        }
        return shouldEnable;
    }
    
    //check box Item Listener for the survey and analysis
    private static class SurveyCheckBoxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            questionnairFlags[0] = true;
            enableSubmit(questionnairFlags, submitButton);
            
            //test function to see if it actually works
            //System.out.println("1) check boxes");
        }
    }
    //Radio Button Action Listener for the survey and analysis
    private static class SurveyRadioButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            questionnairFlags[1] = true;
            enableSubmit(questionnairFlags, submitButton);
            
            //test function to see if it actually works
            //System.out.println("2) radio buttons");
        }
    }
}
