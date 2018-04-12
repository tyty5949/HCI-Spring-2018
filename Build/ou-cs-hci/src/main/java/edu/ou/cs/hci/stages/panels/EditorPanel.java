package edu.ou.cs.hci.stages.panels;

import edu.ou.cs.hci.stages.handlers.EditorHandler;
import edu.ou.cs.hci.stages.util.PanelHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * The <CODE>EditorPanel</CODE> class which is the JPanel for the editor portion of the window. The editor panel
 * houses all the metadata options, movie poster, a button that deletes the movie, and a button that enables
 * edit mode for the movie.
 * *********************************************************************************************************************
 * Major Modification History:
 * 20180313 [tyler]:  Original file created.
 */
@SuppressWarnings("FieldCanBeLocal")
public class EditorPanel extends JPanel {

    //**********************************************************************
    // Private Class Members
    //**********************************************************************

    //==============================================
    // !?!?!? HELP LOCATED HERE !?!?!?!
    //==============================================
    /*
     * HELP FOR ACCESSING THE COMPONENTS WITHIN THE METADATA FIELDS.
     *
     * For example, I wanted to read the value within a metadata FIELD for rating.
     *     ((JTextArea) ratingComponents[2]).getText();
     * Notice how we are accessing the 2nd index within the array of components and then type-casting it to a
     *   JTextArea before trying to call getText() on it!
     *
     * For example, I wanted to read the value within a metadata AREA for description.
     *     ((JTextArea) descriptionComponents[2]).getText();
     * Notice how we are still type-casting to a JTextArea, however, this text area will have longer strings
     *   that could span multiple lines in the text area!
     */
    /**
     * JComponents that are used in the title metadata field. Values can be seen in PanelHelper.makeMetadataField()
     */
    public Component[] titleComponents;

    /**
     * JComponents that are used in the rating metadata field. Values can be seen in PanelHelper.makeMetadataField()
     */
    public Component[] ratingComponents;

    /**
     * JComponents that are used in the actor metadata area. Values can be seen in PanelHelper.makeMetadataArea()
     */
    public Component[] actorComponents;

    /**
     * JComponents that are used in the imdb rating metadata field. Values can be seen in PanelHelper.makeMetadataField()
     */
    public Component[] imdbRatingComponents;

    /**
     * JComponents that are used in the runtime metadata field. Values can be seen in PanelHelper.makeMetadataField()
     */
    public Component[] runtimeComponents;

    /**
     * JComponents that are used in the release date metadata field. Values can be seen in PanelHelper.makeMetadataField()
     */
    public Component[] releaseDateComponents;

    /**
     * JComponents that are used in the description metadata area. Values can be seen in PanelHelper.makeMetadataArea()
     */
    public Component[] descriptionComponents;

    /**
     * The label for the movie poster which can be used to set its image.
     */
    public JLabel moviePosterLabel;

    /**
     * The JPanel which houses all the metadata, including the movie poster. Separate from the delete and edit buttons.
     */
    private JPanel metadataPanel;

    private EditorHandler editorHandler;

    //**********************************************************************
    // Public Methods
    //**********************************************************************

    EditorPanel() {
        this(null);
    }

    /**
     * Constructor which builds the editor panel.
     */
    EditorPanel(Stage7Panel stage7Panel) {
        // Link stage7panel
        editorHandler = new EditorHandler();
        editorHandler.setStage7Panel(stage7Panel);

        // Setup panel
        setBackground(new Color(231, 202, 177));
        setBorder(new EmptyBorder(0, 3, 20, 0));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Metadata panel
        PanelHelper.updateGBConstraints(gbc, 0, 0, 2, 1, GridBagConstraints.BOTH,
                0, 0, .5, .5);
        gbc.insets = new Insets(20, 10, 0, 20);
        metadataPanel = makeMetadataPanel();
        add(metadataPanel, gbc);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(231, 202, 177));
        PanelHelper.updateGBConstraints(gbc, 1, 1, 1, 1, GridBagConstraints.NONE,
                0, 0, .1, 0);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 0, 20);
        add(buttonPanel, gbc);

        // Add button
        JButton addButton = new JButton("Add Movie");
        addButton.setBackground(new Color(204, 228, 255));
        addButton.addActionListener(editorHandler.getAddButtonAL());
        buttonPanel.add(addButton);

        // Edit button
        JButton editButton = new JButton("Edit Movie");
        editButton.setBackground(new Color(204, 228, 255));
        editButton.addActionListener(editorHandler.getEditButtonAL());
        buttonPanel.add(editButton);

        // Delete button
        JButton deleteButton = new JButton("Delete Movie");
        deleteButton.setBackground(new Color(204, 228, 255));
        deleteButton.addActionListener(editorHandler.getDeleteButtonAL());
        buttonPanel.add(deleteButton);
    }

    //**********************************************************************
    // Private Methods
    //**********************************************************************

    // TODO - Implementation for basic and advanced views
    // TODO - Implementation for toggling all the fields/areas editable or non-editable
    // TODO - Fix resizing issue with text fields
    // TODO - Fix resizing issue with movie poster

    /**
     * Helper method which constructs the metadata sub-panel which contains all of the metadata lables and fields/areas
     * as well as the movies poster.
     *
     * @return - The JPanel containing the constructed metadata sub-panel.
     */
    private JPanel makeMetadataPanel() {
        // Setup sub-panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(204, 228, 255));
        panel.setBorder(new LineBorder(Color.BLACK));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        // Display movie poster
        JPanel moviePosterPanel = new JPanel(new BorderLayout());
        moviePosterLabel = new JLabel("Movie Poster", SwingConstants.CENTER);
        moviePosterPanel.add(moviePosterLabel, BorderLayout.CENTER);
        moviePosterPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        PanelHelper.updateGBConstraints(gbc, 0, 0, 1, 6,
                GridBagConstraints.BOTH, 20, 0, 1, .2);
        panel.add(moviePosterPanel, gbc);

        // Display title
        titleComponents = PanelHelper.makeMetadataField("", "Movie Title Here");
        titleComponents[2].setFont(PanelHelper.underlineFont(new Font("Arial", Font.BOLD, 24), true));
        ((JTextArea) titleComponents[2]).getDocument().addDocumentListener(editorHandler.getTitleDL());
        PanelHelper.updateGBConstraints(gbc, 1, 0, 1, 1, GridBagConstraints.HORIZONTAL,
                0, 0, .5, .5);
        panel.add(titleComponents[0], gbc);         // Accessing the JPanel portion of the component array

        // Display rating
        ratingComponents = PanelHelper.makeMetadataField("Rating: ", "PG-13");
        ((JTextArea) ratingComponents[2]).getDocument().addDocumentListener(editorHandler.getRatingDL());
        PanelHelper.updateGBConstraints(gbc, 1, 1, 1, 1, GridBagConstraints.HORIZONTAL,
                0, 0, .5, .5);
        panel.add(ratingComponents[0], gbc);        // Accessing the JPanel portion of the component array

        // Display actors
        actorComponents = PanelHelper.makeMetadataField("Actors: ", "Actor 1, Actor 2, and Actress 3");
        ((JTextArea) actorComponents[2]).getDocument().addDocumentListener(editorHandler.getActorDL());
        PanelHelper.updateGBConstraints(gbc, 1, 2, 1, 1, GridBagConstraints.HORIZONTAL,
                0, 0, .5, .5);
        panel.add(actorComponents[0], gbc);         // Accessing the JPanel portion of the component array

        // Display IMDB rating
        imdbRatingComponents = PanelHelper.makeMetadataField("IMDB Rating: ", "8/10");
        ((JTextArea) imdbRatingComponents[2]).getDocument().addDocumentListener(editorHandler.getIMDBRatingDL());
        PanelHelper.updateGBConstraints(gbc, 1, 3, 1, 1, GridBagConstraints.HORIZONTAL,
                0, 0, .5, .5);
        panel.add(imdbRatingComponents[0], gbc);    // Accessing the JPanel portion of the component array

        // Display Duration
        runtimeComponents = PanelHelper.makeMetadataField("Run Time: ", "120 minutes");
        ((JTextArea) runtimeComponents[2]).getDocument().addDocumentListener(editorHandler.getRuntimeDL());
        PanelHelper.updateGBConstraints(gbc, 1, 4, 1, 1, GridBagConstraints.HORIZONTAL,
                0, 0, .5, .5);
        panel.add(runtimeComponents[0], gbc);       // Accessing the JPanel portion of the component array

        // Display release date
        releaseDateComponents = PanelHelper.makeMetadataField("Release Date: ", "January 1, 1970");
        ((JTextArea) releaseDateComponents[2]).getDocument().addDocumentListener(editorHandler.getReleaseDateDL());
        PanelHelper.updateGBConstraints(gbc, 1, 5, 1, 1, GridBagConstraints.HORIZONTAL,
                0, 0, .5, .5);
        panel.add(releaseDateComponents[0], gbc);   // Accessing the JPanel portion of the component array

        // Display description
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque gravida a massa eget posuere. " +
                "Sed hendrerit sapien nec commodo malesuada. Sed rutrum a quam eu aliquam. Fusce efficitur, urna nec luctus " +
                "tincidunt, eros diam posuere nisl, eget mollis neque sapien vel lacus. Donec et sapien a massa dictum pharetra " +
                "a sed metus. Aenean turpis eros, aliquam vitae ultricies vel, placerat at tortor. Praesent mattis malesuada" +
                " magna, vel tempor turpis mattis sed.";
        descriptionComponents = PanelHelper.makeMetadataArea("Description:", loremIpsum);
        ((JTextArea) descriptionComponents[2]).getDocument().addDocumentListener(editorHandler.getDescriptionDL());
        PanelHelper.updateGBConstraints(gbc, 0, 6, 2, 1,
                GridBagConstraints.BOTH, 0, 0, .5, .5);
        panel.add(descriptionComponents[0], gbc);   // Accessing the JPanel portion of the component array
        ((JTextArea) descriptionComponents[2]).setRows(5);  // Accessing the JTextArea portion of the component array

        // Return constructed sub-panel
        return panel;
    }
}
