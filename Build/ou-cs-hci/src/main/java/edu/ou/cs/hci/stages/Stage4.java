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
import javax.swing.*;
import edu.ou.cs.hci.resources.*;
import javax.swing.border.Border;

//******************************************************************************

/**
 * The <CODE>Stage4</CODE> class.<P>
 *
 * @author  Chris Weaver
 * @version %I%, %G%
 */
public final class Stage4
{
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
    public static JButton addButton = new JButton("+  Add Movie");
    public static JTextArea movieTitle = new JTextArea("No Name");
    //probably replace with images
    public static JComboBox maturityRating = new JComboBox(MPAA_Rating.values());
    //probably replace this with a set of image icons (stars) later
    public static JSpinner score = new JSpinner();
    public static JTextArea summary = new JTextArea("Add Desc?");
    public static JPanel infoTags = new JPanel(new FlowLayout());
    public static JTextField searchText = new JTextField("Search title");
    public static JButton searchButton = new JButton("search");
    public static JList browseList = new JList();
    public static JComboBox sortCombo = new JComboBox();

    //**********************************************************************
    // Private Class Members
    //**********************************************************************
    
    //for the prototype
    private static GridBagConstraints thumbnailConstraints = new GridBagConstraints();

    //**********************************************************************
    // Main
    //**********************************************************************

    public static void main(String[] args)
    {
        //makeProtoFrame();
        //ScenarioFrame scenarios = new ScenarioFrame();
        //scenarios.makeScenarioFrame();
        iFilmLibrary2 iFilmBrowser = new iFilmLibrary2();
        iFilmBrowser.makeFrame();
    }
    
    public static void makeProtoFrame()
    {
        //message = "Build Test";	// Could use an arg for this
        //temporary component adresses
        JLabel tempLabel;
        JButton tempButton;

        //initialize the primary top-level containers
	JFrame frame = new JFrame("iFilm (Home_Prototype)");
        JPanel header = new JPanel(new FlowLayout());
        header.setBackground(Color.GRAY);
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(Color.LIGHT_GRAY);
	JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        
        //put the featured section together
        JPanel featured = new JPanel(new BorderLayout());
        JLabel banner = new JLabel("Featured Banner");
        banner.setBorder(BLACKLINE);
        featured.add(banner, BorderLayout.CENTER);
        tempLabel = new JLabel("Featured");
        tempLabel.setFont(FONT_Header);
        featured.add(tempLabel, BorderLayout.PAGE_START);
        featured.add(new JButton("<-"), BorderLayout.LINE_START);
        featured.add(new JButton("->"), BorderLayout.LINE_END);
        JPanel bannerButtons = new JPanel(new FlowLayout());
        bannerButtons.add(new JRadioButton());
        bannerButtons.add(new JRadioButton());
        bannerButtons.add(new JRadioButton());
        featured.add(bannerButtons, BorderLayout.PAGE_END);
        
        //put the main view together
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(featured);
        mainPanel.add(new ThumbnailGroup("New"));
        mainPanel.add(new ThumbnailGroup("Recommended"));
        //make this Panel vertically scrollable
        //JScrollPane mainScroll = new ScrollPane

        //put the header together
        tempLabel = new JLabel("iFilm");
        tempLabel.setFont(FONT_Logo);
        header.add(tempLabel);
        tempButton = new JButton("Film Store");
        tempButton.setFont(FONT_Header);
        header.add(tempButton);
        tempButton = new JButton("In Library");
        tempButton.setFont(FONT_Header);
        header.add(tempButton);
        tempButton = new JButton("News");
        tempButton.setFont(FONT_Header);
        header.add(tempButton);
        tempButton = new JButton("Community");
        tempButton.setFont(FONT_Header);
        header.add(tempButton);
        header.add(new JTextField("Search", 20));
        header.add(new JButton("Search"));
        
        //put the side pane together
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.PAGE_AXIS));
        tempLabel = new JLabel("Search by Genre");
        tempLabel.setFont(FONT_Header);
        sidePanel.add(tempLabel);
        sidePanel.add(new JLabel("Action"));
        sidePanel.add(new JLabel("Adventure"));
        sidePanel.add(new JLabel("Classic"));
        sidePanel.add(new JLabel("Comedy"));
        sidePanel.add(new JLabel("Documentary"));
        sidePanel.add(new JLabel("Drama"));
        sidePanel.add(new JLabel("For the Family"));
        sidePanel.add(new JLabel("Fantasy"));
        sidePanel.add(new JLabel("Foreign"));
        sidePanel.add(new JLabel("Horror"));
        sidePanel.add(new JLabel("Romance"));
        sidePanel.add(new JLabel("Sci-fi"));
        sidePanel.add(new JLabel("Sports"));
        sidePanel.add(new JLabel("Thriller"));
        
        tempLabel = new JLabel("On Your Wishlist");
        tempLabel.setFont(FONT_Header);
        sidePanel.add(tempLabel);
        for (int i = 0; i < 5; i++) {
            sidePanel.add(new JLabel("Snoozing Beauty"));
        }
        tempLabel = new JLabel("Recently Viewed");
        tempLabel.setFont(FONT_Header);
        sidePanel.add(tempLabel);
        for (int i = 0; i < 5; i++) {
            sidePanel.add(new JLabel("Plaything Tale"));
        }
        
        //put the entire thing all together and display it
	frame.setBounds(50, 50, 1100, 800);
        BorderLayout frameLayout = new BorderLayout();
        frameLayout.setHgap(15);
	frame.getContentPane().setLayout(frameLayout);
	frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.getContentPane().add(sidePanel, BorderLayout.LINE_START);
        frame.getContentPane().add(header, BorderLayout.PAGE_START);
        frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
		System.exit(0);
            }
	});
    }//end make Proto Frame

    //used by make protoframe
    public static class ThumbnailPanel extends JPanel
    {
	private String title;
        private MPAA_Rating maturity;
        private double stars;
        //placeholder for image declaration

	public ThumbnailPanel(String newTitle,
            MPAA_Rating newMaturity, double starRating)
	{
            this.title = ((newTitle != null) ? newTitle : "");
            this.maturity = ((newMaturity != null) ? newMaturity : MPAA_Rating.NOT_RATED);
            this.stars = ((starRating > 0) ? starRating : 0);
            
            setLayout(new GridBagLayout());
            
            JLabel tempLabel = new JLabel("Poster");
            
            //set the image 
            thumbnailConstraints.weightx = 0.5;
            thumbnailConstraints.ipady = 30;
            thumbnailConstraints.gridx = 0;
            thumbnailConstraints.gridy = 0;
            thumbnailConstraints.gridheight = 3;
            tempLabel.setBorder(BLACKLINE);
            add(tempLabel, thumbnailConstraints);
            
            //set the title
            tempLabel = new JLabel(this.title);
            thumbnailConstraints.weightx = 0.5;
            thumbnailConstraints.gridx = 1;
            thumbnailConstraints.gridheight = 1;
            thumbnailConstraints.ipady = 0;
            add(tempLabel, thumbnailConstraints);
            
            //set the MPPA maturity rating
            tempLabel = new JLabel(maturity.toString());
            thumbnailConstraints.weightx = 0.5;
            thumbnailConstraints.gridy = 1;
            add(tempLabel, thumbnailConstraints);
            
            //set the star rating should probably replace with an image
            String starIcon = "";
            for (int i = 0; i < this.stars; i++) {
                starIcon += '*';
            }
            tempLabel = new JLabel(starIcon);
            thumbnailConstraints.weightx = 0.5;
            thumbnailConstraints.gridy = 2;
            add(tempLabel, thumbnailConstraints);
        }

	public ThumbnailPanel()
	{
            this("", MPAA_Rating.NOT_RATED, 0.0);
	}
    }
    
    //used by make protoframe
    public static class ThumbnailGroup extends JPanel
    {
        public ThumbnailGroup(String catName)
        {
            JPanel header = new JPanel(new FlowLayout());
            JLabel category = new JLabel(catName);
            category.setFont(FONT_Header);
            header.add(category);
            header.add(new JLabel("see more"));
            JPanel thumbnailList = new JPanel();
            
            thumbnailList.setLayout(new GridLayout(2, 3));
            for (int i = 0; i < 6; i++) {
                thumbnailList.add(new ThumbnailPanel("The Lion Queen",
                    MPAA_Rating.RATED_R, 2.5));
            }
            
            setLayout(new BorderLayout());
            add(thumbnailList, BorderLayout.CENTER);
            add(header, BorderLayout.PAGE_START);
        }
    }
}

//******************************************************************************
