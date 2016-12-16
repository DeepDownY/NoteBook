package work.w.com.notebook.View;

import android.content.Context;

import java.util.List;

import work.w.com.notebook.Entity.NoteEntity;

/**
 * Created by y1247 on 2016/12/7 0007.
 */

public interface ListView {
    /**
     * 设置Note列表的内容
     * @param ls 含有所有未被删除的Note的list集合
     */
    void setList(List<NoteEntity> ls);
    Context getContext();

    /**
     * 重新进入ListActivity用于刷新列表内容的方法
     * @param ls 含有所有未被删除的Note的list集合
     */
    void refresh(List<NoteEntity> ls);
}
