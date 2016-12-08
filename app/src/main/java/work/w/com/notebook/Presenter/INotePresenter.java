package work.w.com.notebook.Presenter;

import work.w.com.notebook.Entity.NoteEntity;

/**
 * Created by y1247 on 2016/12/8 0008.
 */

public interface INotePresenter {
    void saveNote(NoteEntity note);
    void updateNote(NoteEntity note);
    void deleteNote(String id);
}
