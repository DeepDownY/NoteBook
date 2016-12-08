package work.w.com.notebook.Presenter;

import work.w.com.notebook.Entity.NoteEntity;
import work.w.com.notebook.Model.INoteModel;
import work.w.com.notebook.Model.NoteModel;
import work.w.com.notebook.View.NoteView;

/**
 * Created by y1247 on 2016/12/8 0008.
 */

public class NotePresenter implements INotePresenter {

    INoteModel model;
    NoteView view;

    public NotePresenter(NoteView view){
        model = new NoteModel();
        this.view = view;
    }

    @Override
    public void saveNote(NoteEntity note) {
        model.saveNote(note,view.getContext());
    }

    @Override
    public void updateNote(NoteEntity note) {
        model.updateNote(note,view.getContext());
    }

    @Override
    public void deleteNote(String id) {
        model.deleteNote(id,view.getContext());
    }
}
