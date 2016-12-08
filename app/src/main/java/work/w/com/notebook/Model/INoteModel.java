package work.w.com.notebook.Model;

import android.content.Context;

import work.w.com.notebook.Entity.NoteEntity;

/**
 * Created by y1247 on 2016/12/8 0008.
 */

public interface INoteModel {
    void saveNote(NoteEntity note, Context context);
    void updateNote(NoteEntity note, Context context);
    void deleteNote(String id,Context context);
}
