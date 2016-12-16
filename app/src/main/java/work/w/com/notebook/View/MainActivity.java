package work.w.com.notebook.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import work.w.com.notebook.Apapter.MyAdapter;
import work.w.com.notebook.Entity.NoteEntity;
import work.w.com.notebook.Presenter.ListPresenter;
import work.w.com.notebook.R;
import work.w.com.notebook.SQL.NoteDao;

public class MainActivity extends AppCompatActivity implements ListView,View.OnClickListener{

    MyAdapter adapter;
    RecyclerView recyclerView;
    ListPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

//        NoteDao dao = new NoteDao(this);
//        for(int i=0;i<3;i++){
//            NoteEntity noteEntity = new NoteEntity("AAA","bbb",20161201+i);
//            dao.AddNote(noteEntity);
//        }

    }

    /**
     * 初始化页面方法
     */
    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.ry_noteList);
        presenter = new ListPresenter(this);
        presenter.setList();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setList(List<NoteEntity> ls) {
        adapter = new MyAdapter(ls,this);
        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager
//                (new StaggeredGridLayoutManager
//                        (2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter.Refresh();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void refresh(List<NoteEntity> ls) {
        Log.i("ISSuccess", "refresh: 123123213");
       adapter.Refresh(ls);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,NoteActivity.class);
        startActivity(intent);
    }
}
