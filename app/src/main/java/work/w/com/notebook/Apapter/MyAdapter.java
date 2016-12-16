package work.w.com.notebook.Apapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import work.w.com.notebook.Entity.NoteEntity;
import work.w.com.notebook.Presenter.ListPresenter;
import work.w.com.notebook.R;
import work.w.com.notebook.View.NoteActivity;

/**
 * Created by y1247 on 2016/12/7 0007.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> implements View.OnClickListener {

    private List<NoteEntity> ls;

    private LayoutInflater inflater;

    Context context ;


    public MyAdapter(List<NoteEntity> ls, Context context){
        this.ls = ls;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void Refresh(List<NoteEntity> ls){
        this.ls = ls;
        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.notelist_item,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tt_title.setText(ls.get(position).getTitle());
        holder.tt_datetime.setText(ls.get(position).
                getStringDate());
        holder.tt_word.setText(ls.get(position).getFirstWord());
        holder.ll.setTag(position);
        holder.ll.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    @Override
    public void onClick(View v) {
        int position = (int)v.getTag();
        Intent intent = new Intent(context, NoteActivity.class);
        intent.putExtra("note",ls.get(position));
        context.startActivity(intent);
    }


    class MyHolder extends RecyclerView.ViewHolder {
        TextView tt_title,tt_datetime,tt_word;
        LinearLayout ll;

        public MyHolder(View itemView) {
            super(itemView);

            ll = (LinearLayout) itemView.findViewById(R.id.ll_linearLayout);
            tt_title = (TextView) itemView.findViewById(R.id.tt_title);
            tt_datetime = (TextView) itemView.findViewById(R.id.tt_time);
            tt_word = (TextView) itemView.findViewById(R.id.tt_word);
        }
    }
}
