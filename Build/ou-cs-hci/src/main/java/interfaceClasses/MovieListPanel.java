package interfaceClasses;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * This panels job is to contain the list of movies that the user
 * has in the library. The button at the bottom of the list will play
 * the selected movie once implemented.
 * @author Shobey Stanley
 *
 */
public class MovieListPanel extends JPanel{
	
	private JLabel lbl;
	private JScrollPane pane;
	private JList<String> movieList;
	private JButton playButton;
	
	public MovieListPanel(){
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		//This loop is just to initialize the arrray values for the list
		String[] sArray = new String[20];
		for(int i = 0; i < 20; i++){
			sArray[i] = ("Movie #" + (i + 1));
		}
		
		GridBagConstraints constraints = new GridBagConstraints();
		//This configures the list
		this.lbl = new JLabel("Movies");
		this.movieList = new JList<String>(sArray);
		this.movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.movieList.setPrototypeCellValue("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		//The following places the components on the panel
		constraints.gridheight = 3;
		constraints.gridwidth = 0;
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(lbl);
		
		this.pane = new JScrollPane(movieList);
		constraints.fill = GridBagConstraints.VERTICAL;
		constraints.ipady = 700;
		constraints.gridy = 1;
		this.add(pane, constraints);
		
		this.playButton = new JButton("Play Movie");
		constraints.gridy = 2;
		this.add(playButton);
	}
}
