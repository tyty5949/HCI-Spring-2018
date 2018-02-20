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
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import edu.ou.cs.hci.resources.Resources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//******************************************************************************

/**
 * The <CODE>BuildTest</CODE> class.<P>
 *
 * @author  Chris Weaver
 * @version %I%, %G%
 */
public final class Stage2
{
	//**********************************************************************
	// Public Class Members
	//**********************************************************************

	private static final Font	FONT =
		new Font(Font.SERIF, Font.BOLD, 36);

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
	     //Related movies has its own panel
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
	     frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Closing frame exits the program
			frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		
		//New frame to display scenarios
		JFrame			f = new JFrame("Scenarios");
		JPanel			p = new JPanel(new GridBagLayout());
		//Add an empty border around the edge
		p.setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagConstraints co = new GridBagConstraints();
		co.insets = new Insets(3,3,3,3);

		//Initialize the frame
		f.setBounds(100, 100, 800, 600);
		f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add(p, BorderLayout.CENTER);
		
		final ArrayList<String> stitles = 
				Resources.getLines("scenarios/titles.txt");
		final ArrayList<String> sdescriptions = 
				Resources.getLines("scenarios/descriptions.txt");
		
		
		
		
		while(stitles.size() < 20) {
			stitles.add("");
		}
		
		JList list = new JList(stitles.toArray());
		
		list.setFixedCellHeight(15);  
		co.weightx = 0.5;
		co.fill = GridBagConstraints.HORIZONTAL;
		co.gridx = 0;
		co.gridy = 0;
		p.add(list, co);
		
		JTextArea tarea = new JTextArea(); 
		tarea.setRows(15);
		tarea.setEditable(false);
		co.fill = GridBagConstraints.HORIZONTAL;
		co.gridx = 1;
		co.gridy = 0;
		tarea.setLineWrap(true);
		tarea.setWrapStyleWord(true);
		p.add(tarea, co);
		
		
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent listSelectionEvent) {
		    	  	tarea.setText(sdescriptions.get(list.getSelectedIndex()));
		    	  }
		    };
		    list.addListSelectionListener(listSelectionListener);
		    list.setSelectedIndex(0);
		f.setVisible(true);
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
}

//******************************************************************************
