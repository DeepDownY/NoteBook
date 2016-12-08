package work.w.com.notebook.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import work.w.com.notebook.Entity.NoteEntity;

/**
 * Created by y1247 on 2016/12/7 0007.
 */

public class NoteDao {

    private MySQLHelper dbHelper;

    public NoteDao(Context context){
        dbHelper = new MySQLHelper(context);
    }

    public List<NoteEntity> getAllNote(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        List<NoteEntity> ls = new ArrayList<>();

        if(db.isOpen()){
            String sql = "Select [ID],[Title],[Content],[Attachment],[itemCreateYMD] from NoteItem where isdelete = 0 " +
                    " order by itemCreateYMD desc";
            Cursor cursor = db.rawQuery(sql,null);
            while (cursor.moveToNext()){
                String id = cursor.getString(0);
                String title = cursor.getString(1);
                String noteContent = cursor.getString(2);
                Long itemCreateYMD = cursor.getLong(4);
                NoteEntity note = new NoteEntity(id,title,noteContent,itemCreateYMD);
                ls.add(note);
            }
            cursor.close();
        }
        return ls;
    }

    public void deleteNote(String id){
        SQLiteDatabase  db = dbHelper.getReadableDatabase();
        if(db.isOpen()){
            ContentValues cv = new ContentValues();
            cv.put("isDelete", 1);
            String[] args = {id};
            db.update("NoteItem", cv, "Id=?",args);
        }

    }

    public void AddNote(NoteEntity note){
        SQLiteDatabase  db = dbHelper.getReadableDatabase();
        if(db.isOpen()){
            ContentValues cv = new ContentValues();
            cv.put("Title",note.getTitle());
            cv.put("itemCreateYMD",note.getIntDate());
            cv.put("Content",note.getNoteContent());
            cv.put("isDelete",0);
            db.insert("NoteItem",null,cv);
        }
    }

    public void updateNote(NoteEntity note){
        SQLiteDatabase  db = dbHelper.getReadableDatabase();
        if(db.isOpen()){
            ContentValues cv = new ContentValues();
            cv.put("Title", note.getTitle());
            cv.put("Content", note.getNoteContent());
            cv.put("itemCreateYMD", note.getIntDate());
            String[] args = {String.valueOf(note.getId())};
            db.update("NoteItem", cv, "Id=?",args);
        }
    }
}
