package com.example.latihannavbarbawah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MAdapter extends RecyclerView.Adapter<MAdapter.MyViewHolder> {

    Context context;
    List<Items> itemsArraylist;
    static ItemClickListener mClickListener;

    public MAdapter(Context context, List<Items> items) {
        this.context = context;
        this.itemsArraylist = items;
    }

    @NonNull
    @Override
    public MAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

        return new MAdapter.MyViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return itemsArraylist.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MAdapter.MyViewHolder holder, int position) {

        Items items = itemsArraylist.get(position);
        holder.name.setText(items.name);
        holder.image.setImageResource(items.images);

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView name;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            image = itemView.findViewById(R.id.profile);
            name = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public androidx.fragment.app.Fragment getFragment(int id){
        return itemsArraylist.get(id).fragment;
    }
}