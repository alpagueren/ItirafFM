package com.erenyel.itiraffm_giris;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class feedRecyclerAdapter extends RecyclerView.Adapter<feedRecyclerAdapter.PostHolder> {

    private ArrayList<String> userRumuzList;
    private ArrayList<String> userItirafList;

    public feedRecyclerAdapter(ArrayList<String> userRumuzList, ArrayList<String> userItirafList) {
        this.userRumuzList = userRumuzList;
        this.userItirafList = userItirafList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row,parent,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder( PostHolder holder, int position) {

        holder.rumuzText.setText(userRumuzList.get(position));
        holder.itirafText.setText(userItirafList.get(position));

    }

    @Override
    public int getItemCount() {
        return userItirafList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder{

        TextView rumuzText;
        TextView itirafText;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            rumuzText = itemView.findViewById(R.id.Rumuzlar_Text);
            itirafText = itemView.findViewById(R.id.Itiraflar_Text);
        }
    }
}
