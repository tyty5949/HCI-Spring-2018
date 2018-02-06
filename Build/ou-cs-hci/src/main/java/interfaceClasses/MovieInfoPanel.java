package interfaceClasses;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * This panel's purpose is to display the information of a movie
 * that the user selects from the list on the panel on the left 
 * side of the main frame.
 * @author Shobey Stanley
 *
 */
public class MovieInfoPanel extends JPanel {
	
	private JLabel title;
	private JLabel year;
	private JLabel rating;
	private JLabel director;
	private JLabel studio;
	private JLabel synopsis;
	private JLabel metascore;
	private JList<String> castList;
	private JScrollPane castPane;
	private JList<String> genreList;
	private JScrollPane genrePane;
	private JList<String> reviewList;
	private JScrollPane reviewPane;
	
	public MovieInfoPanel(){
		//These are lists to be implemented later in the panel
		String[] castArray = new String[5];
		String[] genreArray = new String[5];
		String[] reviewArray = new String[5];
		for(int i = 0; i < 5; i++){
			castArray[i] = ("Star #" + (i + 1));
			genreArray[i] = ("Genre #" + (i + 1));
			reviewArray[i] = ("Review #" + (i + 1));
		}
		this.castList = new JList<String>(castArray);
		this.genreList = new JList<String>(genreArray);
		this.reviewList = new JList<String>(reviewArray);
		this.castPane = new JScrollPane(castList);
		this.genrePane = new JScrollPane(genreList);
		this.reviewPane = new JScrollPane(reviewPane);
		
		this.setLayout((new GridBagLayout()));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		GridBagConstraints constraints = new GridBagConstraints();
		
		//The following code will add the components to the panel in a grid
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		constraints.weightx = .5;
		constraints.weighty = .5;
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(title = new JLabel("Title: "), constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		this.add(year = new JLabel("Year: "), constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		this.add(rating = new JLabel("Rating: "), constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 0;
		this.add(director = new JLabel("Director: "), constraints);
		
		constraints.gridx = 4;
		constraints.gridy = 0;
		this.add(studio = new JLabel("Studio: "), constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		this.add(title = new JLabel("Synopsis: "), constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		this.add(title = new JLabel("Metascore: "), constraints);
		
	}
}
