package com.codechefvit.jobber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OnboardAdapter extends RecyclerView.Adapter<OnboardAdapter.ViewHolder>{

    private String[] texts;
    private int[] images;
    private Context context;

    public OnboardAdapter(String[] texts,int[] images,Context context){
        this.context=context;
        this.images=images;
        this.texts=texts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder viewHolder=new ViewHolder(view,context,images,texts);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int imageid=images[position];
        String textid=texts[position];
        holder.image.setImageResource(imageid);
        holder.text.setText(textid);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text;
        Context context;
        String[] texts;
        int[] images;

        public ViewHolder(View itemView, Context context, int[] images, String[] texts){
            super(itemView);
            image=itemView.findViewById(R.id.onboardimage);
            text=itemView.findViewById(R.id.onboardtext);
            this.context=context;
            this.texts=texts;
            this.images=images;
        }
    }

}
