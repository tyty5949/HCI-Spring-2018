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


import edu.ou.cs.hci.resources.Resources;
import edu.ou.cs.hci.stages.handlers.MenuBarHandler;
import edu.ou.cs.hci.stages.panels.Stage7Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * The <CODE>EditorPanel</CODE> class which is the driver class for stage 7. Creates the Stage7Panel within a frame
 * and adds a menu bar and a tool bar to it. Also links the action handler to all of the menu items and tool bar
 * buttons.
 * *********************************************************************************************************************
 * Major Modification History:
 * 20180412 [tyler]:  Original file created.
 * 20180412 [tyler]:  Copied from Stage7.java.
 */
@SuppressWarnings("FieldCanBeLocal")
public final class Stage7 {

    //**********************************************************************
    // Private Class Members
    //**********************************************************************

    /**
     * The handler class for handling all of the actions in the menu bars and tool bars.
     */
    private MenuBarHandler menuBarHandler;

    /**
     * The JPanel which holds all of the components that make up the stage 6 GUI.
     */
    private Stage7Panel stage7Panel;

    /**
     * The JFrame which holds the the stage 6 panel
     */
    private JFrame stage7Frame;

    //**********************************************************************
    // Public Methods
    //**********************************************************************

    /**
     * Constructor which constructs and shows the frame for stage 7. Includes the stage 7 panel, menu bar, and tool
     * bar.
     */
    private Stage7() {

        // Create main panel
        stage7Panel = new Stage7Panel();

        // Create main frame
        stage7Frame = new JFrame("iFilm - Stage 7");
        stage7Frame.setBounds(50, 50, 1100, 650);
        stage7Frame.getContentPane().setLayout(new BorderLayout());
        stage7Frame.getContentPane().add(stage7Panel, BorderLayout.CENTER);
        stage7Frame.setBackground(new Color(231, 202, 177));
        stage7Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        stage7Frame.addWindowListener(new MainWindowAdapter());

        // Initialize menu bar event handler
        menuBarHandler = new MenuBarHandler();
        menuBarHandler.setPanel(stage7Panel);

        // Build menu
        makeMenu();

        // Built toolbar
        JToolBar toolBar = makeToolBar();
        stage7Frame.getContentPane().add(toolBar, BorderLayout.PAGE_START);

        // Show frame
        stage7Frame.setVisible(true);
    }

    //**********************************************************************
    // Private Methods
    //**********************************************************************

    /**
     * Helper method for creating the menu bar. When it is done building its self, it then is added to the frame.
     */
    private void makeMenu() {
        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // -------------------------------------------------------------------
        // File menu
        // -------------------------------------------------------------------
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Open menu item
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        fileMenu.add(openMenuItem);

        // Save menu item
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        fileMenu.add(saveMenuItem);

        // Separator
        fileMenu.addSeparator();

        // Print menu item
        JMenuItem printMenuItem = new JMenuItem("Print");
        printMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        fileMenu.add(printMenuItem);

        // Quit menu item
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        fileMenu.add(quitMenuItem);

        // -------------------------------------------------------------------
        // Edit menu
        // -------------------------------------------------------------------
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        // Paste menu item
        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        editMenu.add(pasteMenuItem);

        // Copy menu item
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        editMenu.add(copyMenuItem);

        // Cut menu item
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        editMenu.add(cutMenuItem);

        // Separator
        editMenu.addSeparator();

        // Clear filters menu item
        JMenuItem clearFiltersMenuItem = new JMenuItem("Clear Filters");
        clearFiltersMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        editMenu.add(clearFiltersMenuItem);

        // Clear metadata menu item
        JMenuItem clearMetadataMenuItem = new JMenuItem("Clear Selected Movie");
        clearMetadataMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        editMenu.add(clearMetadataMenuItem);

        // -------------------------------------------------------------------
        // View menu
        // -------------------------------------------------------------------
        JMenu viewMenu = new JMenu("View");
        menuBar.add(viewMenu);

        // Browser submenu
        JMenu browserSubMenu = new JMenu("Browser");
        JMenuItem detailViewMenuItem = new JMenuItem("List View");
        detailViewMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        browserSubMenu.add(detailViewMenuItem);
        JMenuItem posterViewMenuItem = new JMenuItem("Poster View");
        posterViewMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        browserSubMenu.add(posterViewMenuItem);
        viewMenu.add(browserSubMenu);

        // Editor submenu
        JMenu editorSubMenu = new JMenu("Editor");
        JMenuItem basicViewMenuItem = new JMenuItem("Basic View");
        basicViewMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        editorSubMenu.add(basicViewMenuItem);
        JMenuItem advancedViewMenuItem = new JMenuItem("Advanced View");
        advancedViewMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        editorSubMenu.add(advancedViewMenuItem);
        viewMenu.add(editorSubMenu);

        // Separator
        viewMenu.addSeparator();

        // Browser only menu item
        JMenuItem browserOnlyMenuItem = new JMenuItem("Browser Only");
        browserOnlyMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        viewMenu.add(browserOnlyMenuItem);

        // Editor only menu item
        JMenuItem editorOnlyMenuItem = new JMenuItem("Editor Only");
        editorOnlyMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        viewMenu.add(editorOnlyMenuItem);

        // Reset view menu item
        JMenuItem resetViewMenuItem = new JMenuItem("Default View");
        resetViewMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        viewMenu.add(resetViewMenuItem);

        // Separator
        viewMenu.addSeparator();

        // Fullscreen menu item
        JMenuItem fullscreenMenuItem = new JMenuItem("Fullscreen");
        fullscreenMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        viewMenu.add(fullscreenMenuItem);

        // -------------------------------------------------------------------
        // View menu
        // -------------------------------------------------------------------
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        // Website menu item
        JMenuItem websiteMenuItem = new JMenuItem("Website");
        websiteMenuItem.addActionListener(menuBarHandler.getMenuItemAL());
        helpMenu.add(websiteMenuItem);

        // Add menu bar to frame
        stage7Frame.setJMenuBar(menuBar);
    }

    /**
     * Helper method for building the tool bar. Does not automatically add itself.
     *
     * @return - The constructed JToolBar ready to be added to the stage 5 frame.
     */
    private JToolBar makeToolBar() {
        JToolBar toolBar = new JToolBar("iFilm Tool Bar");
        toolBar.setBackground(Color.WHITE);

        // Browser view details
        JButton detailViewButton = new JButton("Detail View");
        detailViewButton.setBackground(Color.WHITE);
        detailViewButton.addActionListener(menuBarHandler.getToolBarAL());
        detailViewButton.setIcon(Resources.getImage("icons/view_details.png"));
        toolBar.add(detailViewButton);

        // Browser view poster
        JButton posterViewButton = new JButton("Poster View");
        posterViewButton.setBackground(Color.WHITE);
        posterViewButton.addActionListener(menuBarHandler.getToolBarAL());
        posterViewButton.setIcon(Resources.getImage("icons/view_poster.png"));
        toolBar.add(posterViewButton);

        // View editor only
        JButton editorOnlyButton = new JButton("Editor Only");
        editorOnlyButton.setBackground(Color.WHITE);
        editorOnlyButton.addActionListener(menuBarHandler.getToolBarAL());
        editorOnlyButton.setIcon(Resources.getImage("icons/editor_only.png"));
        toolBar.add(editorOnlyButton);

        // Separator
        toolBar.addSeparator();

        // Reset view
        JButton resetViewButton = new JButton("Reset View");
        resetViewButton.setBackground(Color.WHITE);
        resetViewButton.addActionListener(menuBarHandler.getToolBarAL());
        resetViewButton.setIcon(Resources.getImage("icons/reset_view.png"));
        toolBar.add(resetViewButton);

        // Clear Filters
        JButton clearFiltersButton = new JButton("Clear Filters");
        clearFiltersButton.setBackground(Color.WHITE);
        clearFiltersButton.addActionListener(menuBarHandler.getToolBarAL());
        clearFiltersButton.setIcon(Resources.getImage("icons/clear_filters.png"));
        toolBar.add(clearFiltersButton);

        // Return result
        return toolBar;
    }

    //**********************************************************************
    // Main
    //**********************************************************************

    /**
     * The main method for stage 6. Simply constructs a new stage 6 object for the sole reason of calling
     * the constructor.
     *
     * @param args - The program arguments (not used)
     */
    public static void main(String[] args) {
        new Stage7();
    }

    //**********************************************************************
    // Private Sub-Classes
    //**********************************************************************

    /**
     * The window adapter which handles the event of the window closing.
     */
    private class MainWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            // Call quit action using the handler
            menuBarHandler.getMenuItemAL().actionPerformed(new ActionEvent(this, 1, "Quit"));
        }
    }
}
