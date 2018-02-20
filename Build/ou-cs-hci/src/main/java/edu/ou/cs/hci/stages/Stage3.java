//******************************************************************************
// Copyright (C) 2016-2018 University of Oklahoma Board of Trustees.
//******************************************************************************
// Last modified: Tue Feb  9 20:33:16 2016 by Chris Weaver
//******************************************************************************
// Major Modification History:
//
// 20160209 [weaver]:	Original file (for CS 4053/5053 homeworks).
// 20180123 [weaver]:	Modified for use in CS 3053 team projects.
//
//******************************************************************************
// Notes:
//
//******************************************************************************

package edu.ou.cs.hci.stages;

//import java.lang.*;

import edu.ou.cs.hci.resources.Resources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

//******************************************************************************

/**
 * The <CODE>BuildTest</CODE> class.<P>
 *
 * @author  Chris Weaver
 * @version %I%, %G%
 */
public final class Stage3
{
	//**********************************************************************
	// Public Class Members
	//**********************************************************************

	private static final Font	FONT =
		new Font(Font.SERIF, Font.BOLD, 36);

	private static JList<String> scenariosList;
	private static JTextArea scenariosTextArea;

    //**********************************************************************
	// Main
	//**********************************************************************

	public static void main(String[] args)
	{
		
		//Create the frame and main panel
		JFrame			frame = new JFrame("iFilm");
		JPanel			panel = new JPanel(new GridBagLayout());
		//Add an empty border around the edge
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		//Use GridBagConstraints to arrange items
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,3,3,3);

		//Initialize the frame
		frame.setBounds(50, 50, 800, 600);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		//Create big heading
		makelabel("iFilm", 0, 0, c, panel, FONT);
		//Placeholders for link to account info
		makelabel("My Movies | Account", 5, 0, c, panel);
		
		//Categories of movies and a search bar in one row
		makebutton("All", 0, 1, c, panel);
		makebutton("Actors", 1, 1, c, panel);
		makebutton("Genre", 2, 1, c, panel);
		makebutton("Top", 3, 1, c, panel);
		makebutton("Random", 4, 1, c, panel);
		
		maketext("Search", 5, 1, c, panel);
		
		//Main body of information
		//Movie Poster is large
		JLabel moviePoster=new JLabel("Movie Poster");
		moviePoster.setHorizontalAlignment(JLabel.CENTER);
	    moviePoster.setVerticalAlignment(JLabel.CENTER);
		moviePoster.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    c.gridx = 0;
	    c.gridy = 2;
	    c.gridwidth = 2;
	    c.ipady = 375;
	    panel.add(moviePoster, c);

        //Next there is a description of the movie, including several key items
        JTextArea movieDescription=new JTextArea("Movie Name \nStar Actors \nRatings"
            + "\nLength of Movie \nRelease Date \nDescription");
        c.gridx = 2;
        c.ipady = 300;
        panel.add(movieDescription, c);

        //Finally there is a panel for related movies
        // Related movies has its own panel
        JPanel relatedMovies=new JPanel(new GridBagLayout());
        c.gridx = 4;
        c.ipady = 1;
        panel.add(relatedMovies, c);

        //Add movie poster placeholders
        c.gridwidth = 2;
        makelabel("Related Movies", 0, 0, c, relatedMovies);
        makemovieposter(0, 1, c, relatedMovies);
        makemovieposter(1, 1, c, relatedMovies);
        makemovieposter(0, 2, c, relatedMovies);
        makemovieposter(1, 2, c, relatedMovies);

        //Displays the frame
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Closing frame exits the program
        frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

		//**********************************************************************
		// Frame for Personas and Scenarios
		//**********************************************************************
        JFrame personasFrame = new JFrame("Personas and Scenarios");
        JPanel personasPanel = new JPanel();
        personasPanel.setBackground(Color.WHITE);

        // JList
        scenariosList = new JList<>();
        scenariosList.setListData(Resources.getLines("/edu/ou/cs/hci/resources/scenarios/titles.txt")
                .toArray(new String[]{}));
        scenariosList.setSelectedIndex(0);
        scenariosList.addListSelectionListener(new ScenariosListSelectionListener());
        personasPanel.add(scenariosList, BorderLayout.LINE_START);

        // Text area
        scenariosTextArea = new JTextArea(20, 35);
        scenariosTextArea.setEditable(false);
        scenariosTextArea.setWrapStyleWord(true);
        scenariosTextArea.setLineWrap(true);
        ArrayList<String> lines = Resources.getLines("/edu/ou/cs/hci/resources/scenarios/descriptions.txt");
        if(lines.size() == 0) {
            scenariosTextArea.setText("Error, Unable to load descriptions!");
        } else {
            scenariosTextArea.setText(lines.get(0));
        }
        personasPanel.add(scenariosTextArea, BorderLayout.LINE_END);

        // Configure JFrame
        personasFrame.add(personasPanel);
		personasFrame.setBounds(100, 100, 600, 400);
		personasFrame.setVisible(false);
		personasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		//**********************************************************************
		// Frame for Questionaire
		//**********************************************************************
		JFrame questionaireFrame = new JFrame("questionaire");
		JPanel questionairePanel = new JPanel(new GridBagLayout());

		// Question 1
		JPanel q1Panel = new JPanel(new GridLayout(2,1));
		JLabel question1Label = new JLabel("1) How much effort would you say you put into finding new movies to watch?");
		q1Panel.add(question1Label);
		c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = .5;
        c.weighty = .5;
        questionairePanel.add(q1Panel, c);
        

		// Question 2
		JPanel q2Panel = new JPanel(new GridLayout(2,1));
		JLabel question2Label = new JLabel("2) On average, how many movies do you stream to your devices from home a week?");
		q2Panel.add(question2Label)
        SpinnerModel spinnerModel = new SpinnerNumberModel(1,0,10,1);
        JSpinner q2Spinner = new JSpinner(spinnerModel);
        q2Panel.add(q2Spinner);
        c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = .5;
        c.weighty = .5;
        questionairePanel.add(q2Panel, c);

		// Question 3
		JPanel q3Panel = new JPanel(new GridLayout(5,1));
        JLabel question3Label = new JLabel("3) Select the search metrics you are most likely to use when trying to find a movie?");
        q3Panel.add(question3Label);
        JCheckBox genre = new JCheckBox("Genre");
        q3Panel.add(genre);
        JCheckBox runtime = new JCheckBox("Runtime");
        q3Panel.add(runtime);
        JCheckBox actorsDirectors = new JCheckBox("Actors/Directors");
        q3Panel.add(actorsDirectors);
        JCheckBox rottenTomatoes = new JCheckBox("Rotten Tomatoes");
        q3Panel.add(rottenTomatoes);
        c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = .5;
        c.weighty = .5;
        questionairePanel.add(q3Panel, c);

		// Question 4
		JPanel q4Panel = new JPanel(new GridLayout(2,1));
		JLabel question4Label = new JLabel("4) I am comfortable with utilizing search and sort functions to find movies that I might like to watch?");
		q4Panel.add(question4Label);
		JRadioButton stronglyAgree = new JRadioButton("Strongly Agree");
	    JRadioButton agree = new JRadioButton("Agree");
	    JRadioButton neutral = new JRadioButton("Neutral");
	    JRadioButton disagree = new JRadioButton("Disagree");
	    JRadioButton stronglyDisagree = new JRadioButton("Strongly Disagree");
	    ButtonGroup q4Group = new ButtonGroup();
	    q4Group.add(stronglyAgree);
	    q4Group.add(agree);
	    q4Group.add(neutral);
	    q4Group.add(disagree);
	    q4Group.add(stronglyDisagree);
	    q4Panel.add(q4Group);
	    c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = .5;
        c.weighty = .5;
        questionairePanel.add(q4Panel, c);

		// Question 5
		JPanel q5Panel = new JPanel(new GridLayout(2,1));
        JLabel question5Label = new JLabel("5) In a couple sentences describe your current method for finding new movies to watch.");
        q5Panel.add(question5Label);
        JTextArea q5TextArea = new JTextArea("Test");
        q5Panel.add(q5TextArea);
		c.insets = new Insets(20, 20, 20, 20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = .5;
        c.weighty = .5;
        questionairePanel.add(q5Panel, c);

        //Displays the frame
        questionAireFrame.add(questionairePanel);
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Closing frame exits the program
        frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
	}

	//**********************************************************************
	// Private Inner Classes
	//**********************************************************************
	
	//helper method for making buttons
	protected static void makebutton(String name, int x, int y,
            GridBagConstraints c, JPanel panel) {
		JButton button = new JButton(name);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = x;
		c.gridy = y;
		panel.add(button, c);
	}
	
	//helper method for creating text fields (used for search bar)
	protected static void maketext(String name, int x, int y,
            GridBagConstraints c, JPanel panel) {
		JTextField text = new JTextField(name);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = x;
		c.gridy = y;
		panel.add(text, c);
	}
	
	//helper method for creating labels (used for headings)
	protected static void makelabel(String name, int x, int y,
            GridBagConstraints c, JPanel panel) {
		JLabel label = new JLabel(name);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = x;
		c.gridy = y;
		panel.add(label, c);
	}
	
	//helper method for creating labels with a custom font
	//used to make the iFilm logo
	protected static void makelabel(String name, int x, int y,
            GridBagConstraints c, JPanel panel, Font font) {
		JLabel label = new JLabel(name);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = x;
		c.gridy = y;
		label.setFont(font);
		panel.add(label, c);
	}
	
	//helper method to create small movie posters for related movies
	protected static void makemovieposter(int x, int y,
            GridBagConstraints c, JPanel panel) {
		JLabel lab = new JLabel("Movie\nPoster");
		lab.setHorizontalAlignment(JLabel.CENTER);
	    lab.setVerticalAlignment(JLabel.CENTER);
		lab.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.ipady = 150;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = x;
		c.gridy = y;
		panel.add(lab, c);
	}

	// List selection listener
    private static class ScenariosListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            ArrayList<String> lines = Resources.getLines("/edu/ou/cs/hci/resources/scenarios/descriptions.txt");

            // Graceful error checking
            if (lines.size() <= scenariosList.getSelectedIndex()) {
                scenariosTextArea.setText("Error occurred, unable to read descriptions!");
            } else {
                scenariosTextArea.setText(lines.get(scenariosList.getSelectedIndex()));
            }
        }
    }
}

//******************************************************************************
