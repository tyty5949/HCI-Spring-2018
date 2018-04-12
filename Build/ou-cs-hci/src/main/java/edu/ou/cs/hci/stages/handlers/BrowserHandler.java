package edu.ou.cs.hci.stages.handlers;

import edu.ou.cs.hci.stages.actions.Actions;
import edu.ou.cs.hci.stages.panels.Stage7Panel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BrowserHandler {

    private Stage7Panel stage7Panel;

    private ListSelectionListener movieListSL;

    public BrowserHandler() {
        movieListSL = new MovieListSelectionListener();
    }

    public void setStage7Panel(Stage7Panel stage7Panel) {
        this.stage7Panel = stage7Panel;
    }

    public ListSelectionListener getMovieListSL() {
        return movieListSL;
    }

    private class MovieListSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // Fires the required action
            Actions.movieListValueChangedAction(stage7Panel, e);
        }
    }
}
