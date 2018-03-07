package com.example.cx.greendaolianxi1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cx on 2018/2/25.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private List<Xigua> xiguas;
    Context con;
    private onClickListener listener;

    public RecyAdapter(List<Xigua> xiguas, Context con) {
        this.xiguas = xiguas;
        this.con = con;
    }

    @Override
    public RecyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(con).inflate(R.layout.recylayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyAdapter.ViewHolder holder, final int position) {
        holder.age.setText(xiguas.get(position).getAge());
        holder.name.setText(xiguas.get(position).getName());
        holder.sex.setText(xiguas.get(position).getSex());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnItemClick(position);
            }
        });


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.OnItemLongClick(position);


                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return xiguas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView sex;
        private final TextView age;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            sex = itemView.findViewById(R.id.sex);
            age = itemView.findViewById(R.id.age);

        }
    }

    public interface onClickListener{
        void OnItemClick(int position);
        void OnItemLongClick(int position);
    }
    public void setonClickListener(onClickListener listener){
        this.listener=listener;

    }

}
