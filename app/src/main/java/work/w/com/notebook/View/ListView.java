package work.w.com.notebook.View;

import android.content.Context;

import java.util.List;

import work.w.com.notebook.Entity.NoteEntity;

/**
 * Created by y1247 on 2016/12/7 0007.
 */

public interface ListView {
    void setList(List<NoteEntity> ls);
    Context getContext();
    void refresh(List<NoteEntity> ls);
}
