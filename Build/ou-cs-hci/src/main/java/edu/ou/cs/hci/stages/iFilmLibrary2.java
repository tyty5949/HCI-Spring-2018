/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ou.cs.hci.stages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

/**
 *
 * @author StoryTellr
 */
public class iFilmLibrary2 {
    //**********************************************************************
    // Enumerations
    //**********************************************************************

    public enum MPAA_Rating {
        RATED_G, RATED_PG, RATED_PG13, RATED_R, RATED_NC17, NOT_RATED
    }
    
    // State (internal) variables

    //**********************************************************************
    // Public Class Members
    //**********************************************************************
    
    public static final Font FONT_Logo = new Font(Font.SERIF, Font.BOLD, 36);
    public static final Font FONT_Header = new Font(Font.SERIF, Font.PLAIN, 24);
    public static final Border BLACKLINE = BorderFactory.createLineBorder(Color.black);
    
    public static final String DEFAULT_MOVIE_TITLE = "Enter Movie Title Here";
    public JButton addButton = new JButton("+  Add Movie");
    public JTextArea movieTitle = new JTextArea("No Name");
    //probably replace with images
    public JComboBox maturityRating = new JComboBox(MPAA_Rating.values());
    //probably replace this with a set of image icons (stars) later
    public JSpinner score = new JSpinner();
    public JTextArea summary = new JTextArea("Add Desc?");
    public JPanel infoTags = new JPanel(new FlowLayout());
    public JTextField searchText = new JTextField("Search title");
    public JButton searchButton = new JButton("search");
    public JList browseList = new JList();
    public JComboBox sortCombo = new JComboBox();
    public FilterGroup genreFilter = new FilterGroup("Genre");
    public FilterGroup actorFilter = new FilterGroup("Actor");
    public FilterGroup miscFilter = new FilterGroup("Miscellaneous Tag");
    
    public void makeFrame()
    {
        //temporary component adresses
        JLabel tempLabel;
        JButton tempButton;
        JPanel tempPanel;
        JScrollPane tempScroll;
        
        //initiallize the primary top level containers
        JFrame frame = new JFrame("iFilm (Revised)");
        frame.getContentPane().setLayout(new GridBagLayout());
        //frame.getContentPane().setBackground(Color.WHITE);
        JPanel header = new JPanel(new FlowLayout());
        header.setBackground(Color.GRAY);
	//JPanel infoPanel = new JPanel(new GridBagLayout());
        //infoPanel.setBackground(Color.WHITE);
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBackground(Color.LIGHT_GRAY);
        JPanel sortPanel = new JPanel();
        sortPanel.setBackground(Color.GRAY);
        
        GridBagConstraints frameConstraints = new GridBagConstraints();
        
        //creating the header is simple enough
        tempLabel = new JLabel("iFilm");
        tempLabel.setFont(FONT_Logo);
        header.add(tempLabel);
        //put it in the frame
        //frameConstraints.weightx = 0.5;
        //frameConstraints.ipady = 30;
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        frameConstraints.gridwidth = 5;
        frameConstraints.fill = GridBagConstraints.HORIZONTAL;
        frame.getContentPane().add(header);
        
        //Structuring the movie information not-"panel"
        //***** ***** ***** ***** ****** ***** ***** *****
        //set the poster
        tempLabel = new JLabel("Poster");
        //frameConstraints.weightx = 0.5;
        //frameConstraints.ipady = 30;
        //frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        frameConstraints.gridwidth = 1;
        frameConstraints.gridheight = 4;
        frameConstraints.fill = GridBagConstraints.VERTICAL;
        tempLabel.setBorder(BLACKLINE);
        frame.getContentPane().add(tempLabel, frameConstraints);
        
        //set the add movie button
        movieTitle.setRows(2);
        //frameConstraints.weightx = 0.5;
        frameConstraints.gridx = 1;
        frameConstraints.gridheight = 1;
        //frameConstraints.ipady = 0;
        //TODO later: reduce to 1 after replacing score spinner with stars
        frameConstraints.gridwidth = 2;
        frameConstraints.fill = GridBagConstraints.NONE;
        frame.getContentPane().add(addButton, frameConstraints);
        
        //set the movie title (keep it editable)
        movieTitle.setEditable(true);//set the title
        //frameConstraints.weightx = 0.5;
        frameConstraints.gridy = 2;
        frame.getContentPane().add(movieTitle, frameConstraints);
        
        //set the MPPA maturity rating
        //frameConstraints.weightx = 0.5;
        frameConstraints.gridy = 3;
        frame.getContentPane().add(maturityRating, frameConstraints);
        
        //set the star rating (eventually replace with actual stars)
        //frameConstraints.weightx = 0.5;
        frameConstraints.gridy = 4;
        frameConstraints.gridwidth = 1;
        frame.getContentPane().add(new JLabel("Rating:"), frameConstraints);
        //frameConstraints.weightx = 0.5;
        frameConstraints.gridx = 2;
        frame.getContentPane().add(score, frameConstraints);
        
        //set the description
        summary.setRows(5);
        //frameConstraints.weightx = 0.5;
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 5;
        frameConstraints.gridwidth = 3;
        frame.getContentPane().add(summary, frameConstraints);
        
        //finally, set the tag list
        //frameConstraints.weightx = 0.5;
        frameConstraints.gridy = 6;
        frame.getContentPane().add(infoTags, frameConstraints);
        
        //structuring the movie list panel in the middle
        //***** ***** ***** ***** ****** ***** ***** *****
        //make the search bar at the top
        tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(searchText);
        tempPanel.add(searchButton);
        listPanel.add(tempPanel, BorderLayout.PAGE_START);
        
        //make the list of titles in the library
        browseList.setLayoutOrientation(JList.VERTICAL);
        browseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tempScroll = new JScrollPane(browseList);
        listPanel.add(tempScroll, BorderLayout.CENTER);
        
        //add it to the frame
        //frameConstraints.weightx = 0.5;
        frameConstraints.gridx = 3;
        frameConstraints.gridy = 1;
        frameConstraints.gridheight = 6;
        frameConstraints.gridwidth = 1;
        frame.getContentPane().add(listPanel, frameConstraints);
        
        //structuring the sort and filter panel on the right
        //***** ***** ***** ***** ****** ***** ***** *****
        sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.PAGE_AXIS));
        sortPanel.add(new JLabel("Sort by:"));
        sortPanel.add(sortCombo);
        sortPanel.add(new JLabel("Filter by:"));
        sortPanel.add(genreFilter);
        sortPanel.add(actorFilter);
        sortPanel.add(miscFilter);
        
        //add it to the frame
        //frameConstraints.weightx = 0.5;
        frameConstraints.gridx = 4;
        frame.getContentPane().add(sortPanel, frameConstraints);
        
        //give polish to the frame
        //***** ***** ***** ***** ****** ***** ***** *****
        frame.setBounds(50, 50, 1100, 800);
        frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
		System.exit(0);
            }
	});
    }

    //**********************************************************************
    // Helper Classes
    //**********************************************************************
    
    //used by Make Frame 2
    public class FilterGroup extends JPanel
    {
        public JLabel filterName;
        public ArrayList<JCheckBox> filters;
        public JButton addButton = new JButton("+  Add Filter");
                
        private JPanel checkPanel = new JPanel();
        
        public FilterGroup(String name)
        {
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            filterName = new JLabel(name);
            add(filterName);
            
            //create the list of checkboxes
            add(addButton);
        }
    }
    
    //the actual movie info used in Make frame 2
    public class movieInfo
    {
        public String title;
        public MPAA_Rating maturity;
        public String description;
        public ArrayList<String> tagList;
                
        private int stars;
        
        public movieInfo(String newTitle, MPAA_Rating newMat, int newStars, String newDesc)
        {
            title = newTitle;
            maturity = newMat;
            description = newDesc;
            
            
        }
        public movieInfo(String newTitle, MPAA_Rating newMat, int newStars)
        {
            this(newTitle, newMat, newStars, "Add description?");
        }
        public movieInfo()
        {
            this("No title", MPAA_Rating.NOT_RATED, 0, "");
        }
        
        int getStars()
        {
            return stars;
        }
        void setStars(int newStars){
            if (newStars < 0) {
                stars = 0;
            }
            else if (newStars > 5){
                stars = 5;
            }
            else {
                stars = newStars;
            }
        }
    }
}

//******************************************************************************