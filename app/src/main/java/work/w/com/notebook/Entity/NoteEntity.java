package work.w.com.notebook.Entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by y1247 on 2016/12/7 0007.
 */

public class NoteEntity implements Serializable{
    private String id;
    private String title;
    private String firstWord;
    private String noteContent;

    private Date date;
    SimpleDateFormat int2Date = new SimpleDateFormat("yyyyMMddHHmm", Locale.getDefault());
    SimpleDateFormat date2String = new SimpleDateFormat("yyyy年MM月dd日 HH:mm", Locale.getDefault());
    SimpleDateFormat int2Time = new SimpleDateFormat("HH:mm", Locale.getDefault());


    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public NoteEntity(String id,String title,String noteContent,Long itemCreateYMD){
        try {
            date = int2Date.parse(String.valueOf(itemCreateYMD));
        }catch (Exception e){
            System.out.print(e.toString());
        }
        this.id = id;
        this.title = title;
        this.noteContent = noteContent;
        if(noteContent.length()<=200){
            this.firstWord = noteContent;
        }else {

            this.firstWord = noteContent.substring(200) + "...";
        }

    }

    public NoteEntity(String title,String noteContent,long itemCreateYMD){
        try {
            date = int2Date.parse(String.valueOf(itemCreateYMD));
        }catch (Exception e){
            System.out.print(e.toString());
        }
        this.title = title;
        this.noteContent = noteContent;
        if(noteContent.length()<=15){
            this.firstWord = noteContent;
        }else {
            this.firstWord = noteContent.substring(15) + "...";
        }
    }

    public NoteEntity(String title,String noteContent,Date date){
        this.date = date;
        this.title = title;
        this.noteContent = noteContent;
        if(noteContent.length()<=15){
            this.firstWord = noteContent;
        }else {
            this.firstWord = noteContent.substring(15) + "...";
        }
    }


    public String getStringDate() {

        String date = date2String.format(this.date);
        return date;
    }

    public Date getDate(){
        return date;
    }

    public Long getIntDate(){
        String x = int2Date.format(date);
        Long n = Long.parseLong(x);
        return n;
    }

    /**
     * 将数据库中的Long类型的日期数据转化为Calender
     * @param itemCreateYMD 传入的long值日期
     */
    public void setCalendar(Long itemCreateYMD) {

        try {
            date = int2Date.parse(String.valueOf(itemCreateYMD));
        }catch (Exception e){
            System.out.print(e.toString());
        }

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
