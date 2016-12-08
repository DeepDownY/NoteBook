package work.w.com.notebook.Model;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

import work.w.com.notebook.Entity.NoteEntity;
import work.w.com.notebook.SQL.NoteDao;

/**
 * Created by y1247 on 2016/12/7 0007.
 */

public class ListModel implements IListModel {


    @Override
    public List<NoteEntity> getData(Context context) {
        NoteDao dao = new NoteDao(context);
        List<NoteEntity> ls = dao.getAllNote();
        Log.i("ListNumber", "getData: "+String.valueOf(ls.size()));
        return ls;
    }
}
