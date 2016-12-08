package work.w.com.notebook.Model;

import android.content.Context;

import work.w.com.notebook.Entity.NoteEntity;
import work.w.com.notebook.SQL.NoteDao;

/**
 * Created by y1247 on 2016/12/8 0008.
 */

public class NoteModel implements INoteModel {
    @Override
    public void saveNote(NoteEntity note, Context context) {
        NoteDao dao = new NoteDao(context);
        dao.AddNote(note);
    }

    @Override
    public void updateNote(NoteEntity note, Context context) {
        NoteDao dao = new NoteDao(context);
        dao.updateNote(note);
    }

    @Override
    public void deleteNote(String id,Context context) {
        NoteDao dao = new NoteDao(context);
        dao.deleteNote(id);
    }
}
