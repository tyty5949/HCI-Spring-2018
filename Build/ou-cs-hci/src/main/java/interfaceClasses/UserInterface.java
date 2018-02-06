package interfaceClasses;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.*;

/**
 * This is the frame. It will contain and maneuver all the panels.
 * @author Shobey Stanley
 *
 */
public class UserInterface extends JFrame{
	
	private JPanel bigPanel;//This holds all of the panels.
	private JPanel movieInfoDoublePanel;//This holds two of the panels.
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu edit;
	private JMenuItem editInfo;
	private JMenuItem addItem;
	
	//Default Constructor
	public UserInterface(){
		super("iFilm");
		setSize(1400,1000);
		bigPanel = new JPanel(new BorderLayout());
		movieInfoDoublePanel = new JPanel(new BorderLayout());
		//Sets and configures menu bar and items
		menuBar = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("Edit");
		addItem = new JMenuItem("Add Movie to Library");
		editInfo = new JMenuItem("Edit Selected Movie");
		menuBar.add(file);
		menuBar.add(edit);
		edit.add(editInfo);
		file.add(addItem);
		this.setJMenuBar(menuBar);
		//This section adds everything to the frame
		movieInfoDoublePanel.add(new MoviePicPanel(), BorderLayout.NORTH);
		movieInfoDoublePanel.add(new MovieInfoPanel(), BorderLayout.CENTER);
		bigPanel.add(new MovieListPanel(), BorderLayout.WEST);
		bigPanel.add(movieInfoDoublePanel, BorderLayout.CENTER);
		this.add(bigPanel);
		this.pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
