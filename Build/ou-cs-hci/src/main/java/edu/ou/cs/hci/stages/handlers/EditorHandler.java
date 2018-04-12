package edu.ou.cs.hci.stages.handlers;

import edu.ou.cs.hci.stages.actions.Actions;
import edu.ou.cs.hci.stages.panels.Stage7Panel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorHandler {

    private Stage7Panel stage7Panel;

    private DocumentListener titleDL;
    private DocumentListener ratingDL;
    private DocumentListener actorDL;
    private DocumentListener imdbRatingDL;
    private DocumentListener runtimeDL;
    private DocumentListener releaseDateDL;
    private DocumentListener descriptionDL;

    private ActionListener addButtonAL;
    private ActionListener editButtonAL;
    private ActionListener deleteButtonAL;

    public EditorHandler() {
        titleDL = new GenericDocumentListener();
        ratingDL = new GenericDocumentListener();
        actorDL = new GenericDocumentListener();
        imdbRatingDL = new GenericDocumentListener();
        runtimeDL = new GenericDocumentListener();
        releaseDateDL = new GenericDocumentListener();
        descriptionDL = new GenericDocumentListener();

        addButtonAL = new ButtonActionListener();
        editButtonAL = new ButtonActionListener();
        deleteButtonAL = new ButtonActionListener();
    }

    public void setStage7Panel(Stage7Panel stage7Panel) {
        this.stage7Panel = stage7Panel;
    }

    public DocumentListener getTitleDL() {
        return titleDL;
    }

    public DocumentListener getRatingDL() {
        return ratingDL;
    }

    public DocumentListener getActorDL() {
        return actorDL;
    }

    public DocumentListener getIMDBRatingDL() {
        return imdbRatingDL;
    }

    public DocumentListener getRuntimeDL() {
        return runtimeDL;
    }

    public DocumentListener getReleaseDateDL() {
        return releaseDateDL;
    }

    public DocumentListener getDescriptionDL() {
        return descriptionDL;
    }

    public ActionListener getAddButtonAL() {
        return addButtonAL;
    }

    public ActionListener getEditButtonAL() {
        return editButtonAL;
    }

    public ActionListener getDeleteButtonAL() {
        return deleteButtonAL;
    }

    private class GenericDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            Actions.metadataEditedAction(stage7Panel, e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            Actions.metadataEditedAction(stage7Panel, e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            Actions.metadataEditedAction(stage7Panel, e);
        }
    }

    private class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Add Movie":
                    Actions.addButtonAction(stage7Panel);
                    break;
                case "Edit Movie":
                    Actions.editButtonAction(stage7Panel);
                    break;
                case "Delete Movie":
                    Actions.deleteButtonAction(stage7Panel);
                    break;
            }
        }
    }
}
