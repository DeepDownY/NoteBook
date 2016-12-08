package work.w.com.notebook.Model;

import android.content.Context;

import java.util.List;

import javax.security.auth.callback.Callback;

import work.w.com.notebook.Entity.NoteEntity;

/**
 * Created by y1247 on 2016/12/7 0007.
 */

public interface IListModel {
    List<NoteEntity> getData(Context context);
}
