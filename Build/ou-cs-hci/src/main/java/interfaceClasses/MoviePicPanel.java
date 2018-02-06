package interfaceClasses;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is a simple panel that will hold artwork for the movie that is selected
 * by the user in the list.
 * @author Shobey Stanley
 *
 */
public class MoviePicPanel extends JPanel{
	
	private JLabel artLbl;
	public MoviePicPanel(){
		artLbl = new JLabel();
		artLbl.setIcon(new ImageIcon("artworkExample.jpg"));
		artLbl.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(artLbl);
	}

}
