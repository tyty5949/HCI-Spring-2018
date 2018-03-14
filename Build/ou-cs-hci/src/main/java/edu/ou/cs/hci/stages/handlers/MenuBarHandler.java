package edu.ou.cs.hci.stages.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The <CODE>MenuBarHandler</CODE> class which is designed to hold the action listeners and events for the menu bar.
 * <p/>
 * This class works by using action listeners to call pre-written action commands. This can be induced artificially by
 * calling:
 * getMenuItemAL().actionPerformed(new ActionEvent(this, 0, "action_here"));
 * Where "action_here" is a string which represents the action you want to issue.
 * <p/>
 * All action that you are trying to fire must be written within the class and linked within the action listener
 * classes.
 * *********************************************************************************************************************
 * Major Modification History:
 * 20180313 [tyler]:  Original file created.
 */
public class MenuBarHandler {
    // TODO - Rename to be more fitting for menu bar and tool bar.
    // TODO - Link panel components to handler, so action methods can actually do stuff

    /**
     * The action listener instance for all JMenuItems in the menubar.
     */
    private MenuItemActionListener menuItemAL;

    /**
     * The action listener instance for all JButtons in the toolbar.
     */
    private ToolBarActionListener toolBarAL;

    /**
     * Constructor which initializes the action listener instances.
     */
    public MenuBarHandler() {
        menuItemAL = new MenuItemActionListener();
        toolBarAL = new ToolBarActionListener();
    }

    /**
     * Gets the action listener instance for all menu items in the menubar.
     *
     * @return - The ActionListener for the menubar items.
     */
    public ActionListener getMenuItemAL() {
        return menuItemAL;
    }

    /**
     * Gets the action listener instance for all tool bar buttons in the tool bar.
     *
     * @return - The ActionListener for the tool bar button.
     */
    public ActionListener getToolBarAL() {
        return toolBarAL;
    }

    /**
     * The action which is fired when the open button is pressed.
     */
    private void openAction() {
        System.out.println("File->Open - Opens the database metadata from a file.");
    }

    /**
     * The action which is fired when the save button is pressed.
     */
    private void saveAction() {
        System.out.println("File->Save - Save the database metadata to a file.");
    }

    /**
     * The action which is fired when the print button is pressed.
     */
    private void printAction() {
        System.out.println("File->Print - Prints the database metadata to a document in a readable format.");
    }

    /**
     * The action which is fired when the quit button is pressed.
     */
    private void quitAction() {
        System.out.println("File->Quit - Quits the program without saving.");

        // Call actions for 10 menu bar events
        menuItemAL.actionPerformed(new ActionEvent(this, 1, "Clear Filters"));
        menuItemAL.actionPerformed(new ActionEvent(this, 2, "Clear Metadata"));
        menuItemAL.actionPerformed(new ActionEvent(this, 3, "Detail View"));
        menuItemAL.actionPerformed(new ActionEvent(this, 4, "Poster View"));
        menuItemAL.actionPerformed(new ActionEvent(this, 5, "Basic View"));
        menuItemAL.actionPerformed(new ActionEvent(this, 6, "Advanced View"));
        menuItemAL.actionPerformed(new ActionEvent(this, 7, "Browser Only"));
        menuItemAL.actionPerformed(new ActionEvent(this, 8, "Editor Only"));
        menuItemAL.actionPerformed(new ActionEvent(this, 9, "Reset View"));
        menuItemAL.actionPerformed(new ActionEvent(this, 10, "Fullscreen"));

        // Exit
        System.exit(0);
    }

    /**
     * The action which is fired when the paste button is pressed.
     */
    private void pasteAction() {
        System.out.println("Edit->Paste - Pastes a copied movie into the database.");
    }

    /**
     * The action which is fired when the copy button is pressed.
     */
    private void copyAction() {
        System.out.println("Edit->Copy - Copies the selected movie from the database.");
    }

    /**
     * The action which is fired when the cut button is pressed.
     */
    private void cutAction() {
        System.out.println("Edit->Cut - Cuts the selected movie from the database. (Copy then delete)");
    }

    /**
     * The action which is fired when the clear filters button is pressed.
     */
    private void clearFiltersAction() {
        System.out.println("Edit->Clear Filters - Clears all of the enabled browsers filters.");
    }

    /**
     * The action which is fired when the clear metadata action is pressed.
     */
    private void clearMetadataAction() {
        System.out.println("Edit->Clear Metadata - Clears metadata within the currently selected movie.");
    }

    /**
     * The action which is fired when the detail view button is pressed.
     */
    private void detailViewAction() {
        System.out.println("View->Browser->Detail View - Shows details in browser instead of poster.");
    }

    /**
     * The action which is fired when the poster view button is pressed.
     */
    private void posterViewAction() {
        System.out.println("View->Browser->Poster View - Shows poster in browser instead of details.");
    }

    /**
     * The action which is fired when the basic view button is pressed.
     */
    private void basicViewAction() {
        System.out.println("View->Editor->Basic View - Only shows basic metadata of selected movie in the editor.");
    }

    /**
     * The action which is fired when the advanced view button is pressed.
     */
    private void advancedViewAction() {
        System.out.println("View->Editor->Advanced View - Shows all metadata of selected movie in the editor.");
    }

    /**
     * The action which is fired when the browser only button is pressed.
     */
    private void browserOnlyAction() {
        System.out.println("View->Browser Only - Shows only the movie browser.");
    }

    /**
     * The action which is fired when the editor only button is pressed.
     */
    private void editorOnlyAction() {
        System.out.println("View->Editor Only - Shows only the movie editor.");
    }

    /**
     * The action which is fired when the reset view button is pressed.
     */
    private void resetViewAction() {
        System.out.println("View->Reset View - Resets the view to the default. (Browser and editor)");
    }

    /**
     * The action which is fired when the fullscreen button is pressed.
     */
    private void fullscreenAction() {
        System.out.println("View->Fullscreen - Toggles back and forth between fullscreen and windowed modes.");
    }

    /**
     * The action which is fired when the help website button is pressed.
     */
    private void websiteAction() {
        System.out.println("Help->Website - Opens up a tasteful website.");
    }

    /**
     * The action listener for all menu items in the menubar. The action command from each menu bar item is simply
     * the text that it displays, or if specified on the JMenuItem creation a specific action command.
     * <p/>
     * This listener simply calls the corresponding action method, all located within the class, for the button
     * which this listener was performed on.
     * <p/>
     * NOTE: An instance of this class must be linked to each menu item which is created for it to work, via
     * myMenuItem.addActionListener(myHandler.getMenuItemAL())
     * <p/>
     * NOTE: If a new item is added or the text the item displays is changed, this class must be modified to reflect
     * those changes. A corresponding action method must also be created and linked in this method.
     */
    private class MenuItemActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Open":
                    // Open menu item pressed
                    openAction();
                    break;
                case "Save":
                    // Save menu item pressed
                    saveAction();
                    break;
                case "Print":
                    // Print menu item pressed
                    printAction();
                    break;
                case "Quit":
                    // Quit menu item pressed
                    quitAction();
                    break;
                case "Paste":
                    // Paste menu item pressed
                    pasteAction();
                    break;
                case "Copy":
                    // Copy menu item pressed
                    copyAction();
                    break;
                case "Cut":
                    // Cut menu item pressed
                    cutAction();
                    break;
                case "Clear Filters":
                    // Clear filters menu item pressed
                    clearFiltersAction();
                    break;
                case "Clear Metadata":
                    // Clear metadata menu item pressed
                    clearMetadataAction();
                    break;
                case "Detail View":
                    // Browser detailed view menu item pressed
                    detailViewAction();
                    break;
                case "Poster View":
                    // Browser poster view menu item pressed
                    posterViewAction();
                    break;
                case "Basic View":
                    // Editor basic view menu item pressed
                    basicViewAction();
                    break;
                case "Advanced View":
                    // Editor advanced menu item pressed
                    advancedViewAction();
                    break;
                case "Browser Only":
                    // Browser only menu item pressed
                    browserOnlyAction();
                    break;
                case "Editor Only":
                    // Editor only menu item pressed
                    editorOnlyAction();
                    break;
                case "Reset View":
                    // Reset view menu item pressed
                    resetViewAction();
                    break;
                case "Fullscreen":
                    // Fullscreen menu item pressed
                    fullscreenAction();
                    break;
                case "Website":
                    // Website menu item pressed
                    websiteAction();
                    break;
            }
        }
    }

    /**
     * The action listener for all buttons in the tool bar. The action command from each button is simply
     * the text that it displays, or if specified on the JButton creation a specific action command.
     * <p/>
     * This listener simply calls the corresponding action method, all located within the class, for the button
     * which this listener was performed on.
     * <p/>
     * NOTE: An instance of this class must be linked to each button which is created for it to work, via
     * myButton.addActionListener(myHandler.getToolBarAL())
     * <p/>
     * NOTE: If a new button is added or the text the button displays is changed, this class must be modified to reflect
     * those changes. A corresponding action method must also be created and linked in this method.
     */
    private class ToolBarActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Clear Filters":
                    // Clear filters menu item pressed
                    clearFiltersAction();
                    break;
                case "Detail View":
                    // Browser detailed view menu item pressed
                    detailViewAction();
                    break;
                case "Poster View":
                    // Browser poster view menu item pressed
                    posterViewAction();
                    break;
                case "Editor Only":
                    // Editor only menu item pressed
                    editorOnlyAction();
                    break;
                case "Reset View":
                    // Reset view menu item pressed
                    resetViewAction();
                    break;
            }
        }
    }
}
