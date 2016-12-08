package work.w.com.notebook.View;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import work.w.com.notebook.Entity.NoteEntity;
import work.w.com.notebook.Presenter.NotePresenter;
import work.w.com.notebook.R;

public class NoteActivity extends AppCompatActivity implements NoteView{
    NotePresenter presenter;
    EditText ed_noteTitle,ed_noteContext;
    int flag = 0;
    String id = String.valueOf(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        init();
    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_note);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_note);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = ed_noteTitle.getText().toString();
                String context = ed_noteContext.getText().toString();
                Calendar calendar = Calendar.getInstance();
                Date date = calendar.getTime();
                if(flag == 0) {
                    presenter.saveNote(new NoteEntity(title, context, date));
                }else {
                    NoteEntity note = new NoteEntity(title, context, date);
                    note.setId(id);
                    presenter.updateNote(note);
                }
                 onBackPressed();

            }
        });

        ed_noteContext = (EditText) findViewById(R.id.ed_noteContext);
        ed_noteTitle = (EditText) findViewById(R.id.ed_noteTitle);


        presenter = new NotePresenter(this);

        Intent intent = getIntent();
        NoteEntity note = (NoteEntity) intent.getSerializableExtra("note");

        if(note != null) {
            id = note.getId();
            flag = 1;
            String context = note.getNoteContent();
            String title = note.getTitle();
            ed_noteContext.setText(context);
            ed_noteTitle.setText(title);
            ed_noteTitle.setSelection(title.length());
            ed_noteContext.setSelection(context.length());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            if(!(this.id.equals(String.valueOf(0)))) {
                presenter.deleteNote(this.id);
                Toast.makeText(this,this.id,Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void saveNote() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void deleteNote() {

    }

}
