package work.w.com.notebook.Presenter;

import android.content.Intent;

import java.util.List;

import javax.security.auth.callback.Callback;

import work.w.com.notebook.Entity.NoteEntity;
import work.w.com.notebook.Model.IListModel;
import work.w.com.notebook.Model.ListModel;
import work.w.com.notebook.View.ListView;
import work.w.com.notebook.View.MainActivity;
import work.w.com.notebook.View.NoteActivity;

/**
 * Created by y1247 on 2016/12/7 0007.
 */

public class ListPresenter implements IListPresenter {

    IListModel model;
    ListView view;

    public ListPresenter(ListView view ){
        this.view = view;
        model = new ListModel();
    }

    @Override
    public void setList() {
        List<NoteEntity> ls = model.getData(view.getContext());
        view.setList(ls);
    }

    @Override
    public void Refresh() {
        List<NoteEntity> ls = model.getData(view.getContext());
        view.refresh(ls);
    }


}
