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
import java.util.Hashtable;

import edu.ou.cs.hci.resources.Resources;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	     frame.setVisible(false);
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
		f.setVisible(false);
		
		
		//New frame to display survey
		JFrame			fr = new JFrame("Survey");
		JPanel			pa = new JPanel(new GridBagLayout());
		//Add an empty border around the edge
		pa.setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagConstraints con = new GridBagConstraints();
		con.insets = new Insets(3,3,3,3);
		
		fr.setBounds(100, 100, 700, 700);
		fr.getContentPane().setLayout(new BorderLayout());
		fr.getContentPane().add(pa, BorderLayout.CENTER);
		
		String[] responses = new String[5];
		boolean[] selected = new boolean[5];
		for (int i = 0; i < 5; i++) {
			responses[i] = "";
			selected[i] = false;
		}
		
		JButton finish = new JButton("Finish");

		makelabel("Which of the following devices do you search for movies on?", 0, 0, con, pa);
		
		
		JCheckBox laptop = new JCheckBox("Laptop");
		JCheckBox tablet = new JCheckBox("Tablet");
		JCheckBox smartphone = new JCheckBox("Smartphone");
		JCheckBox smartTV = new JCheckBox("SmartTV");
		JCheckBox streaming = new JCheckBox("Streaming Device (Chromecast, FireTV, etc.)");
		ItemListener itemlistener = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
		        AbstractButton abstractButton = (AbstractButton)itemEvent.getSource();
		        int state = itemEvent.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		        		selected[0] = true;
		        		if (selected[0] == true && selected[1] == true && selected[2] == true
								&& selected[3] == true && selected[4] == true)
						finish.setEnabled(true);
		        }
		     }
		};
		
		laptop.addItemListener(itemlistener); 
		tablet.addItemListener(itemlistener);
		smartphone.addItemListener(itemlistener);
		smartTV.addItemListener(itemlistener);
		streaming.addItemListener(itemlistener);
		con.gridy = 1;
		pa.add(laptop, con);
		con.gridy = 2;
		pa.add(tablet, con);
		con.gridy = 3;
		pa.add(smartphone, con);
		con.gridy = 4;
		pa.add(smartTV, con);
		con.gridy = 5;
		pa.add(streaming, con);
		
		
		makelabel("On average, how many minutes do you spend selecting your movies?", 0, 6, con, pa);
		
		ButtonGroup radio = new ButtonGroup();
		JRadioButton one = new JRadioButton("0-9");
		JRadioButton two = new JRadioButton("10-19");
		JRadioButton three = new JRadioButton("20-29");
		JRadioButton four = new JRadioButton("30-39");
		JRadioButton five = new JRadioButton("40-49");
		JRadioButton six = new JRadioButton("50+");
		ItemListener itemlis = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
		        int state = itemEvent.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		        		selected[1] = true;
		        		if (selected[0] == true && selected[1] == true && selected[2] == true
								&& selected[3] == true && selected[4] == true)
						finish.setEnabled(true);
		        }
		     }
		};
		
		one.addItemListener(itemlis);
		two.addItemListener(itemlis);
		three.addItemListener(itemlis);
		four.addItemListener(itemlis);
		five.addItemListener(itemlis);
		six.addItemListener(itemlis);
		radio.add(one);
		radio.add(two);
		radio.add(three);
		radio.add(four);
		radio.add(five);
		radio.add(six);
		
		
		
		con.gridy = 7;
		pa.add(one, con);
		con.gridy = 8;
		pa.add(two, con);
		con.gridy = 9;
		pa.add(three, con);
		con.gridy = 10;
		pa.add(four, con);
		con.gridy = 11;
		pa.add(five, con);
		con.gridy = 12;
		pa.add(six, con);
		
		makelabel("How many factors (such as genre, actors, ratings) do you consider when choosing your movies?",
				0, 13, con, pa);
		String[] factors = {"0", "1", "2", "3", "4", "5+"};
		SpinnerListModel factor = new SpinnerListModel(factors);
		JSpinner fac = new JSpinner(factor);
		fac.addComponentListener(new ComponentListener() {
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				selected[2] = true;
				if (selected[0] == true && selected[1] == true && selected[2] == true
						&& selected[3] == true && selected[4] == true)
				finish.setEnabled(true);
			}

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
	    });
		con.gridy = 14;
		pa.add(fac, con);
		
		makelabel("How important is movie selection to you when streaming movies?", 0, 15, con, pa);
		JSlider levels = new JSlider(JSlider.HORIZONTAL, 0, 4, 2);
		levels.setMajorTickSpacing(1);
		levels.setPaintTicks(true);
		levels.setSnapToTicks(true);
		Hashtable<Integer, JLabel> labeltable = new Hashtable<Integer, JLabel>();
		labeltable.put(new Integer(0), new JLabel("Very Unimportant"));
		labeltable.put(new Integer(1), new JLabel("Unimportant"));
		labeltable.put(new Integer(2), new JLabel("Neutral"));
		labeltable.put(new Integer(3), new JLabel("Important"));
		labeltable.put(new Integer(4), new JLabel("Very Important"));
		levels.setLabelTable(labeltable);
		
		levels.setPaintLabels(true);
		
		levels.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					// TODO Auto-generated method stub
					selected[3] = true;
					if (selected[0] == true && selected[1] == true && selected[2] == true
							&& selected[3] == true && selected[4] == true)
					finish.setEnabled(true);
				}
		});
		
		con.gridy = 16;
		pa.add(levels, con);
		
		makelabel("Describe which feature in iFilm is best for your movie selection process. What makes it so effective?",
				0, 17, con, pa);
		
		JTextArea answer = new JTextArea();
		answer.setLineWrap(true);
	    answer.setWrapStyleWord(true);
		answer.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				// TODO Auto-generated method stub
				selected[4] = true;
				if (selected[0] == true && selected[1] == true && selected[2] == true
						&& selected[3] == true && selected[4] == true)
				finish.setEnabled(true);
			}
			
		});
		
		JScrollPane scroll = new JScrollPane(answer);
		scroll.setPreferredSize(new Dimension(100, 100));
		con.gridy = 18;
		con.gridheight = 2;
		pa.add(scroll, con);
		
		con.gridy = 20;
		con.gridheight = 1;
		finish.setEnabled(false);
		finish.addActionListener(new ActionListener() {
		       @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
		             // this makes sure the button you are pressing is the button variable
		             if(e.getSource() == finish) {
		            	 	if (laptop.isSelected()) 
		            	 		responses[0] += laptop.getLabel() + " ";
		            	 	if (tablet.isSelected()) 
		            	 		responses[0] += tablet.getLabel() + " ";
		            	 	if (smartphone.isSelected()) 
		            	 		responses[0] += smartphone.getLabel() + " ";
		            	 	if (smartTV.isSelected()) 
		            	 		responses[0] += smartTV.getLabel() + " ";
		            	 	if (streaming.isSelected()) 
		            	 		responses[0] += streaming.getLabel() + " ";
		            	 	if (one.isSelected()) 
		            	 		responses[1] += one.getLabel();
		            	 	if (two.isSelected()) 
		            	 		responses[1] += two.getLabel();
		            	 	if (three.isSelected()) 
		            	 		responses[1] += three.getLabel();
		            	 	if (four.isSelected()) 
		            	 		responses[1] += four.getLabel();
		            	 	if (five.isSelected()) 
		            	 		responses[1] += five.getLabel();
		            	 	if (six.isSelected()) 
		            	 		responses[1] += six.getLabel();
		            	 	responses[2] += fac.getValue();
		            	 	responses[3] += labeltable.get(levels.getValue()).getText();
		            	 	responses[4] += answer.getText();
		            	 	for (int i = 0; i < 5; i++) {
		            	 		System.out.println(responses[i]);
		            	 	}
		            	 	fr.dispatchEvent(new WindowEvent(fr, WindowEvent.WINDOW_CLOSING));
		              }
		       }
		 });
		con.fill = GridBagConstraints.HORIZONTAL;
		pa.add(finish, con);
		
		fr.pack();
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
