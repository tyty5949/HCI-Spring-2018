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

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

//******************************************************************************

/**
 * The <CODE>BuildTest</CODE> class.<P>
 *
 * @author Chris Weaver
 * @version %I%, %G%
 */
public final class Stage1 {
    //**********************************************************************
    // Public Class Members
    //**********************************************************************

    private static final Font FONT =
            new Font(Font.SERIF, Font.ITALIC, 36);
    private static final Color FILL_COLOR = Color.YELLOW;
    private static final Color EDGE_COLOR = Color.RED;

    private static String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer et sapien ut nisl sollicitudin condimentum. In quis ullamcorper nunc. Proin laoreet neque sit amet justo pulvinar venenatis. Phasellus a vulputate magna. Nulla interdum elementum massa, et consectetur nisi hendrerit vel. Curabitur sit amet arcu in tortor facilisis tincidunt. Donec ex tellus, tempor at condimentum vel, consectetur eget lectus. Morbi hendrerit lacus quis sapien luctus, et rhoncus nulla tempor. Vivamus maximus sapien nec lacinia malesuada. Suspendisse potenti. Donec nec diam quis nisl mollis molestie ac a ipsum. Sed blandit tellus quis luctus sodales.\n" +
            "\n" +
            "Phasellus nisi odio, hendrerit a tellus hendrerit, dapibus suscipit mauris. Vivamus convallis dignissim imperdiet. Integer fermentum nunc lorem, non fringilla velit vehicula nec. Aliquam erat volutpat. Cras maximus augue id augue viverra suscipit. Nulla id ipsum mollis, efficitur mauris vel, tempus lorem. Ut eget tincidunt odio. Aliquam varius cursus ipsum vel dapibus. Sed a laoreet tellus.\n" +
            "\n" +
            "Proin id erat ut turpis eleifend ullamcorper ut id risus. Nulla facilisi. Praesent accumsan fringilla sollicitudin. Morbi nec blandit augue. Etiam convallis mauris cursus nisl auctor, vitae efficitur turpis porta. Cras sed ornare velit. Nullam vel nulla sem. Ut eget pellentesque quam, et dapibus ex. Aliquam metus neque, commodo vel hendrerit in, aliquet at tellus. Aliquam erat volutpat. Aliquam nibh risus, pellentesque et neque a, posuere tempor ante. Aenean scelerisque felis id lectus posuere malesuada.";

    //**********************************************************************
    // Private Members
    //**********************************************************************

    // State (internal) variables
    private static String message;

    //**********************************************************************
    // Main
    //**********************************************************************

    public static void main(String[] args) {
        // Initialize frame
        JFrame frame = new JFrame("Stage 1");
        frame.setBounds(50, 50, 900, 600);
        frame.setMinimumSize(new Dimension(900, 600));
        frame.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Add browse pane
        JPanel browsePanel = new BrowsePanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .4;
        gbc.weighty = 1;
        frame.getContentPane().add(browsePanel, gbc);

        // Add view pane
        JPanel viewPanel = new ViewPanel();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .8;
        gbc.weighty = 1;
        frame.getContentPane().add(viewPanel, gbc);

        // Show frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static final class BrowsePanel extends JPanel {

        /**
         * View options
         **/
        private JButton viewOptions;

        /**
         * Search bar.
         */
        private JTextField searchTextField;

        /**
         * Main view pane.
         */
        private JLabel viewPane;

        public BrowsePanel() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            // View options (Will be collection of buttons)
            viewOptions = new JButton("View Options");
            gbc.insets = new Insets(10, 10, 5, 10);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 0;
            this.add(viewOptions, gbc);

            // Main view area (Will be some sort of ListPane)
            viewPane = new JLabel("View Panel", SwingConstants.CENTER);
            viewPane.setBorder(new EtchedBorder());
            gbc.insets = new Insets(0, 10, 0, 10);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weighty = 1;
            gbc.weightx = 1;
            this.add(viewPane, gbc);

            // Search bar
            searchTextField = new JTextField("Search");
            gbc.insets = new Insets(10, 10, 5, 10);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.weighty = 0;
            gbc.weightx = 0;
            this.add(searchTextField, gbc);
        }
    }

    private static final class ViewPanel extends JPanel {

        /**
         * Cover Image
         */
        private JLabel coverImage;

        /**
         * Title
         */
        private JLabel titleLabel;

        /**
         * Key Metadata
         */
        private JTextArea keyMetadata;

        /**
         * Other metadata
         */
        private JTextArea otherMetadata;


        public ViewPanel() {
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            // View options (Will be collection of buttons)
            coverImage = new JLabel("Movie Poster", SwingConstants.CENTER);
            coverImage.setBorder(new EtchedBorder());
            gbc.insets = new Insets(20, 20, 20, 20);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.ipady = 80;
            gbc.ipadx = 150;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridheight = 2;
            gbc.gridwidth = 1;
            gbc.weightx = .5;
            gbc.weighty = .5;
            this.add(coverImage, gbc);

            // View options (Will be collection of buttons)
            titleLabel = new JLabel("Movie Title", SwingConstants.CENTER);
            Font font = new Font("Arial", Font.BOLD, 35);
            Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            titleLabel.setFont(font.deriveFont(attributes));
            gbc.insets = new Insets(20, 20, 0, 20);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            gbc.weightx = .6;
            gbc.weighty = .05;
            this.add(titleLabel, gbc);

            // View options (Will be collection of buttons)
            keyMetadata = new JTextArea(loremIpsum);
            keyMetadata.setLineWrap(true);
            JScrollPane scroll = new JScrollPane(keyMetadata);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            gbc.insets = new Insets(20, 20, 20, 20);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            gbc.weightx = .6;
            gbc.weighty = .95;
            this.add(scroll, gbc);

            // View options (Will be collection of buttons)
            otherMetadata = new JTextArea(loremIpsum);
            otherMetadata.setLineWrap(true);
            JScrollPane scroll2 = new JScrollPane(otherMetadata);
            scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            gbc.insets = new Insets(20, 20, 20, 20);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 1;
            gbc.weighty = .7;
            this.add(scroll2, gbc);
        }
    }
}

//******************************************************************************
