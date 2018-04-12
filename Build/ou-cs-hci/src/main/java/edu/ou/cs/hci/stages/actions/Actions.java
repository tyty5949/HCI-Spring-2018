package edu.ou.cs.hci.stages.actions;

import edu.ou.cs.hci.stages.panels.Stage7Panel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.text.BadLocationException;

/**
 * Class which holds all of the static actions that the program will call using different handlers.
 */
public class Actions {

    // ********************************************************************************************
    // MenuBar / Toolbar Actions
    // ********************************************************************************************

    /**
     * The action which is fired when the open button is pressed.
     */
    public static void openAction(Stage7Panel stage7Panel) {
        // TODO - PUT CODE HERE THAT WILL RUN WHEN ANY OPEN BUTTON IS PRESSED
        // TODO - USE THE stage7Panel VARIABLE TO ACCESS DATA WITHIN THE PANELS AND SUB-PANELS
        System.out.println("File->Open - Opens the database metadata from a file.");
    }

    /**
     * The action which is fired when the save button is pressed.
     */
    public static void saveAction(Stage7Panel stage7Panel) {
        // TODO - PUT CODE HERE THAT WILL RUN WHEN ANY SAVE BUTTON IS PRESSED
        // TODO - USE THE stage7Panel VARIABLE TO ACCESS DATA WITHIN THE PANELS AND SUB-PANELS
        System.out.println("File->Save - Save the database metadata to a file.");
    }

    /**
     * The action which is fired when the print button is pressed.
     */
    public static void printAction(Stage7Panel stage7Panel) {
        System.out.println("File->Print - Prints the database metadata to a document in a readable format.");
    }

    /**
     * The action which is fired when the quit button is pressed.
     */
    public static void quitAction(Stage7Panel stage7Panel) {
        // TODO - PUT CODE HERE TO QUIT THE PROGRAM
        System.out.println("File->Quit - Quits the program without saving.");

        // Exit
        System.exit(0);
    }

    /**
     * The action which is fired when the paste button is pressed.
     */
    public static void pasteAction(Stage7Panel stage7Panel) {
        System.out.println("Edit->Paste - Pastes a copied movie into the database.");
    }

    /**
     * The action which is fired when the copy button is pressed.
     */
    public static void copyAction(Stage7Panel stage7Panel) {
        System.out.println("Edit->Copy - Copies the selected movie from the database.");
    }

    /**
     * The action which is fired when the cut button is pressed.
     */
    public static void cutAction(Stage7Panel stage7Panel) {
        System.out.println("Edit->Cut - Cuts the selected movie from the database. (Copy then delete)");
    }

    /**
     * The action which is fired when the clear filters button is pressed.
     */
    public static void clearFiltersAction(Stage7Panel stage7Panel) {
        System.out.println("Edit->Clear Filters - Clears all of the enabled browsers filters.");
    }

    /**
     * The action which is fired when the clear metadata action is pressed.
     */
    public static void clearMetadataAction(Stage7Panel stage7Panel) {
        System.out.println("Edit->Clear Metadata - Clears metadata within the currently selected movie.");
    }

    /**
     * The action which is fired when the detail view button is pressed.
     */
    public static void detailViewAction(Stage7Panel stage7Panel) {
        System.out.println("View->Browser->Detail View - Shows details in browser instead of poster.");
    }

    /**
     * The action which is fired when the poster view button is pressed.
     */
    public static void posterViewAction(Stage7Panel stage7Panel) {
        System.out.println("View->Browser->Poster View - Shows poster in browser instead of details.");
    }

    /**
     * The action which is fired when the basic view button is pressed.
     */
    public static void basicViewAction(Stage7Panel stage7Panel) {
        System.out.println("View->Editor->Basic View - Only shows basic metadata of selected movie in the editor.");
    }

    /**
     * The action which is fired when the advanced view button is pressed.
     */
    public static void advancedViewAction(Stage7Panel stage7Panel) {
        System.out.println("View->Editor->Advanced View - Shows all metadata of selected movie in the editor.");
    }

    /**
     * The action which is fired when the browser only button is pressed.
     */
    public static void browserOnlyAction(Stage7Panel stage7Panel) {
        System.out.println("View->Browser Only - Shows only the movie browser.");
    }

    /**
     * The action which is fired when the editor only button is pressed.
     */
    public static void editorOnlyAction(Stage7Panel stage7Panel) {
        System.out.println("View->Editor Only - Shows only the movie editor.");
    }

    /**
     * The action which is fired when the reset view button is pressed.
     */
    public static void resetViewAction(Stage7Panel stage7Panel) {
        System.out.println("View->Reset View - Resets the view to the default. (Browser and editor)");
    }

    /**
     * The action which is fired when the fullscreen button is pressed.
     */
    public static void fullscreenAction(Stage7Panel stage7Panel) {
        System.out.println("View->Fullscreen - Toggles back and forth between fullscreen and windowed modes.");
    }

    /**
     * The action which is fired when the help website button is pressed.
     */
    public static void websiteAction(Stage7Panel stage7Panel) {
        System.out.println("Help->Website - Opens up a tasteful website.");
    }


    // ********************************************************************************************
    // BrowserPanel Actions
    // ********************************************************************************************

    /**
     * The action which is fired when a new item in the browser list is selected.
     */
    public static void movieListValueChangedAction(Stage7Panel stage7Panel, ListSelectionEvent listSelectionEvent) {
        // TODO - PUT CODE HERE THAT LOADS THE METADATA OF THE SELECTED MOVIE INTO THE METADATA FIELDS
        // TODO - HELP FOR SETTING METADATA FIELDS/AREAS CAN BE FOUND IN EditorPanel
        // TODO - HELP FOR GETTING THE SELECTED MOVIE CAN BE FOUND IN BrowserPanel

        System.out.println("A new value has been selected...");
        System.out.println("    " + stage7Panel.getBrowserPanel().movieList.getSelectedValue());
    }


    // ********************************************************************************************
    // EditorPanel Actions
    // ********************************************************************************************

    /**
     * The action which is fired when ANY metadata field/area is edited within the metadata panel.
     */
    public static void metadataEditedAction(Stage7Panel stage7Panel, DocumentEvent documentEvent) {
        // TODO - PUT CODE HERE THAT HAPPENS WHEN ANY METADATA FIELDS/AREAS ARE EDITED

        System.out.println("Metadata edited...");
        System.out.println("    eventType=" + documentEvent.getType());
        try {
            System.out.println("    textChanged=" + documentEvent.getDocument().getText(documentEvent.getOffset(),
                    documentEvent.getLength()));
        } catch (BadLocationException e) {
            System.out.println("    textChanged=REMOVED BLOCK");
        }
    }

    /**
     * The action which is fired when the Add button is pressed in the editor panel.
     */
    public static void addButtonAction(Stage7Panel stage7Panel) {
        System.out.println("Add button was pressed!");
    }

    /**
     * The action which is fired when the Edit button is pressed in the editor panel.
     */
    public static void editButtonAction(Stage7Panel stage7Panel) {
        System.out.println("Edit button was pressed!");
    }

    /**
     * The action which is fired when the Delete button is pressed in the editor panel.
     */
    public static void deleteButtonAction(Stage7Panel stage7Panel) {
        System.out.println("Delete button was pressed!");
    }
}
