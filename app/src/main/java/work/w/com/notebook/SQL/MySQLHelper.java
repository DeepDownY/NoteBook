package work.w.com.notebook.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by y1247 on 2016/12/7 0007.
 */

public class MySQLHelper extends SQLiteOpenHelper {

    private static final String name = "count"; //数据库名称
    private static final int version = 1; //数据库版本
    public  static final int TYPE_EXPEND = 1;
    public  static final int TYPE_INCOME = 0;

    public MySQLHelper(Context context){
        super(context,name,null,version);
    }
    public MySQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE table NoteItem (" +
                "[ID]  INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "[Title] Varchar ," +
                "[Content] Varchar ," +
                "[Attachment] Varchar ," +
                "[itemCreateYMD] Long ," +
                "[isDelete] Boolean" +
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
