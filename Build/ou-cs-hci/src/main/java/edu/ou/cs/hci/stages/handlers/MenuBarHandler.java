package edu.ou.cs.hci.stages.handlers;

import edu.ou.cs.hci.stages.actions.Actions;
import edu.ou.cs.hci.stages.panels.Stage7Panel;

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

    /**
     * The action listener instance for all JMenuItems in the menubar.
     */
    private MenuItemActionListener menuItemAL;

    /**
     * The action listener instance for all JButtons in the toolbar.
     */
    private ToolBarActionListener toolBarAL;

    /**
     * Instance of the Stage7Panel class that is currently being run on the main JFrame.
     * NOTE: USEFUL SO THAT WE POLL FIELDS WITHIN THE PANEL AND SUB-PANELS.
     */
    private Stage7Panel stage7Panel;

    /**
     * Constructor which initializes the action listener instances.
     */
    public MenuBarHandler() {
        menuItemAL = new MenuItemActionListener();
        toolBarAL = new ToolBarActionListener();
    }

    /**
     * Helper method which allows the instance of the Stage7Panel that will be running on the JFrame to be assigned.
     *
     * @param stage7Panel - The current instance of the Stage7Panel class that is running on the JFrame.
     */
    public void setPanel(Stage7Panel stage7Panel) {
        this.stage7Panel = stage7Panel;
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
                    Actions.openAction(stage7Panel);
                    break;
                case "Save":
                    // Save menu item pressed
                    Actions.saveAction(stage7Panel);
                    break;
                case "Print":
                    // Print menu item pressed
                    Actions.printAction(stage7Panel);
                    break;
                case "Quit":
                    // Quit menu item pressed
                    Actions.quitAction(stage7Panel);
                    break;
                case "Paste":
                    // Paste menu item pressed
                    Actions.pasteAction(stage7Panel);
                    break;
                case "Copy":
                    // Copy menu item pressed
                    Actions.copyAction(stage7Panel);
                    break;
                case "Cut":
                    // Cut menu item pressed
                    Actions.cutAction(stage7Panel);
                    break;
                case "Clear Filters":
                    // Clear filters menu item pressed
                    Actions.clearFiltersAction(stage7Panel);
                    break;
                case "Clear Selected Movie":
                    // Clear metadata menu item pressed
                    Actions.clearMetadataAction(stage7Panel);
                    break;
                case "List View":
                    // Browser detailed view menu item pressed
                    Actions.detailViewAction(stage7Panel);
                    break;
                case "Poster View":
                    // Browser poster view menu item pressed
                    Actions.posterViewAction(stage7Panel);
                    break;
                case "Basic View":
                    // Editor basic view menu item pressed
                    Actions.basicViewAction(stage7Panel);
                    break;
                case "Advanced View":
                    // Editor advanced menu item pressed
                    Actions.advancedViewAction(stage7Panel);
                    break;
                case "Browser Only":
                    // Browser only menu item pressed
                    Actions.browserOnlyAction(stage7Panel);
                    break;
                case "Editor Only":
                    // Editor only menu item pressed
                    Actions.editorOnlyAction(stage7Panel);
                    break;
                case "Default View":
                    // Reset view menu item pressed
                    Actions.resetViewAction(stage7Panel);
                    break;
                case "Fullscreen":
                    // Fullscreen menu item pressed
                    Actions.fullscreenAction(stage7Panel);
                    break;
                case "Website":
                    // Website menu item pressed
                    Actions.websiteAction(stage7Panel);
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
                    Actions.clearFiltersAction(stage7Panel);
                    break;
                case "Detail View":
                    // Browser detailed view menu item pressed
                    Actions.detailViewAction(stage7Panel);
                    break;
                case "Poster View":
                    // Browser poster view menu item pressed
                    Actions.posterViewAction(stage7Panel);
                    break;
                case "Editor Only":
                    // Editor only menu item pressed
                    Actions.editorOnlyAction(stage7Panel);
                    break;
                case "Reset View":
                    // Reset view menu item pressed
                    Actions.resetViewAction(stage7Panel);
                    break;
            }
        }
    }
}
