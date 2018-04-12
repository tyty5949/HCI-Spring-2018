package edu.ou.cs.hci.stages.panels;

import edu.ou.cs.hci.stages.handlers.BrowserHandler;
import edu.ou.cs.hci.stages.util.PanelHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * The <CODE>BrowserPanel</CODE> class which is the JPanel for the browser portion of the window. The browser panel
 * is the panel where the user browses for movies and contains sub-panels such as the search bar, filter sections, and
 * the actual list of movies which are being browsed.
 * *********************************************************************************************************************
 * Major Modification History:
 * 20180313 [tyler]:  Original file created.
 */
@SuppressWarnings("FieldCanBeLocal")
public class BrowserPanel extends JPanel {

    //**********************************************************************
    // Private Class Members
    //**********************************************************************

    /**
     * JComponents that are used in the genre filter. Values can be seen in PanelHelper.makeFilterSection()
     */
    private Component[] genreFilterComponents;

    /**
     * JComponents that are used in the rating filter. Values can be seen in PanelHelper.makeFilterSection()
     */
    private Component[] ratingFilterComponents;

    /**
     * JComponents that are used in the imdb rating filter. Values can be seen in PanelHelper.makeFilterSection()
     */
    private Component[] imdbRatingFilterComponents;

    private BrowserHandler browserHandler;

    //==============================================
    // !?!?!? HELP LOCATED HERE !?!?!?!
    //==============================================
    /*
     * HELP FOR ACCESSING THE SELECTED MOVIE IN THE LIST
     *
     * You can get the value of the list by using...
     *     movieList.getSelectedValue();
     * This will return the String is currently selected by the list.
     */
    /**
     * Opening up the movieList JList object so that it can be accessed externally.
     */
    public JList<String> movieList;

    //**********************************************************************
    // Public Methods
    //**********************************************************************

    /**
     * Constructor which builds the browser panel.
     */
    BrowserPanel() {
        this(null);
    }

    /**
     * Constructor which builds the browser panel.
     */
    BrowserPanel(Stage7Panel stage7Panel) {
        // Assign stage7panel
        browserHandler = new BrowserHandler();
        browserHandler.setStage7Panel(stage7Panel);

        // Setup panel
        setBorder(new EmptyBorder(0, 0, 0, 3));
        setBackground(new Color(231, 202, 177));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Create search bar
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setBackground(new Color(231, 202, 177));
        JLabel searchLabel = new JLabel("Search: ");
        searchPanel.add(searchLabel);
        JTextField searchTextField = new JTextField("");
        searchTextField.setColumns(28);
        searchTextField.setBackground(new Color(204, 228, 255));
        searchPanel.add(searchTextField);
        PanelHelper.updateGBConstraints(gbc, 0, 0, 2, 1, GridBagConstraints.HORIZONTAL,
                0, 0, .5, .001);
        add(searchPanel, gbc);

        // Add browse sub-panel
        JPanel browsePanel = makeBrowsePanel();
        PanelHelper.updateGBConstraints(gbc, 0, 1, 1, 1, GridBagConstraints.BOTH,
                0, 0, .5, .9);
        add(browsePanel, gbc);

        // Add filter sub-panel
        JPanel filterPanel = makeFilterPanel();
        JScrollPane filterScrollPane = new JScrollPane(filterPanel);
        filterScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        filterScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        filterScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PanelHelper.updateGBConstraints(gbc, 1, 1, 1, 1, GridBagConstraints.BOTH,
                0, 0, .5, .9);
        gbc.insets = new Insets(0, 10, 0, 0);
        add(filterScrollPane, gbc);
    }

    //**********************************************************************
    // Private Methods
    //**********************************************************************


    /**
     * Helper method for building the browse sub-panel which contains the sort functionality and the actual JList
     * for browsing.
     *
     * @return - The JPanel containing the constructed browse panel.
     */
    private JPanel makeBrowsePanel() {
        // Create sub-panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(231, 202, 177));
        GridBagConstraints gbc = new GridBagConstraints();

        // Sort-by panel
        JPanel sortByPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        sortByPanel.setBackground(new Color(231, 202, 177));
        JLabel sortByLabel = new JLabel("Sort by: ");
        sortByPanel.add(sortByLabel);
        JComboBox<String> sortByComboBox = new JComboBox<>(new String[]{"Title", "Runtime", "Release Date"});
        sortByComboBox.setBackground(new Color(204, 228, 255));
        sortByPanel.add(sortByComboBox);
        PanelHelper.updateGBConstraints(gbc, 0, 0, 1, 1, GridBagConstraints.HORIZONTAL,
                0, 0, .5, 0);
        panel.add(sortByPanel, gbc);

        // Create list of movies
        movieList = new JList<>(new String[]{"Test 1", "Test 2"});
        movieList.addListSelectionListener(browserHandler.getMovieListSL());
        movieList.setBackground(new Color(204, 228, 255));
        JScrollPane movieListScollPane = new JScrollPane(movieList);
        movieListScollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        movieListScollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        movieListScollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PanelHelper.updateGBConstraints(gbc, 0, 1, 1, 1, GridBagConstraints.BOTH,
                0, 0, .5, .5);
        panel.add(movieListScollPane, gbc);

        // Return created sub-panel
        return panel;
    }

    /**
     * Helper method for building the filter sub-panel. This sub-panel contains other sub-panels called filter sections
     * which each represent a different filter. The filters are created by the helper method
     * PanelHelper.makeFilterSection(), see that for details on how to use it.
     *
     * @return - The JPanel containing the constructed filter panel with all the filter sections within it.
     */
    private JPanel makeFilterPanel() {
        // Create sub-panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(204, 228, 255));

        // Filter label
        JLabel filterLabel = new JLabel("Filter By ...");
        filterLabel.setFont(PanelHelper.underlineFont(new Font("Arial", Font.BOLD, 14), true));
        panel.add(filterLabel);

        // Add genre filter section
        genreFilterComponents = PanelHelper.makeFilterSection("Genre", new String[]{"Action", "Adventure",
                "Comedy", "Drama", "Horror", "Romance", "Sci-Fi"});
        panel.add(genreFilterComponents[0]);

        // Add rating filter section
        ratingFilterComponents = PanelHelper.makeFilterSection("Rating", new String[]{"G", "PG",
                "PG-13", "R", "NC-17"});
        panel.add(ratingFilterComponents[0]);

        // Add IMDB rating section
        imdbRatingFilterComponents = PanelHelper.makeFilterSection("IMDB Rating", new String[]{"5/10", "6/10",
                "7/10", "8/10", "9/10", "10/10"});
        panel.add(imdbRatingFilterComponents[0]);

        // Return created sub-panel
        return panel;
    }
}
