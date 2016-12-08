package work.w.com.notebook.Bean;

import java.util.ArrayList;
import java.util.List;

import work.w.com.notebook.Entity.NoteEntity;

/**
 * Created by y1247 on 2016/12/7 0007.
 */

public class ListBean {
    private List<NoteEntity> ls = new ArrayList<>();

    public ListBean(List<NoteEntity> ls){
        this.ls = ls;
    }

    public List<NoteEntity> getLs() {
        return ls;
    }

    public void setLs(List<NoteEntity> ls) {
        this.ls = ls;
    }
}
